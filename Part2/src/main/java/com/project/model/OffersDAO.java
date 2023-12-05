package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

// implementing DAO pattern

@Repository("offers")
public class OffersDAO {

    // * when only use query without parameter
    // private JdbTemplate jdbc;

    // * use query with parameter
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(@Value("#{sql.dataSource}") DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    // retrieve
    public List<Offer> getOffers() {
        // by default jdbc handle all possible exception occur in sql (don't need specify any sql exception)
        // try { // not necessary
        return jdbc.query("select * from offers", (ResultSet rs, int row) -> {

            Offer offer = new Offer();
            offer.setId(rs.getInt("id"));
            offer.setName(rs.getString("name"));
            offer.setEmail(rs.getString("email"));
            offer.setText(rs.getString("text"));

            return offer;
        });
        // } catch (DataAccessException e) { // catch any exception related to access database
        //      e.printStackTrace();
        // } catch (CannotGetJdbcConnectionException e) { // catch for specific exception when can't connect into database
        //      System.out.println("Connection fail !");
        // }
    }

    // BAD BEHAVIOR !, someone can use SQL injection
    //                 if name assign as drop table ...
    // public List<Offer> getOffers(String name){
    //    return jdbc.query("select * from offers where name = '"+ name + "'", ...)
    // }

    // retrieve using one parameter
    public List<Offer> getOffers(String name) {
        MapSqlParameterSource params = new MapSqlParameterSource("param1", name);
        // replace placeholder :param1 into 'name'
        return jdbc.query("select * from offers where name = :param1", params, (ResultSet rs, int row) -> {

            Offer offer = new Offer();
            offer.setId(rs.getInt("id"));
            offer.setName(rs.getString("name"));
            offer.setEmail(rs.getString("email"));
            offer.setText(rs.getString("text"));

            return offer;
        });
    }

    // retrieve using two parameter
    public List<Offer> getOffers(int id, String name) { // NOT NECESSARY using two parameter
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("param1", id);
        params.addValue("param2", name);
        // replace placeholder :param1 into 'id' and replace placeholder :param2 into 'name'
        return jdbc.query("select * from offers where id = :param1 and name = :param2", params, (ResultSet rs, int row) -> {

            Offer offer = new Offer();
            offer.setId(rs.getInt("id"));
            offer.setName(rs.getString("name"));
            offer.setEmail(rs.getString("email"));
            offer.setText(rs.getString("text"));

            return offer;
        });
    }

    // retrieve only one
    public Offer getOffer(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("param1", id);

        // replace placeholder :param1 into 'id'
        return jdbc.queryForObject("select * from offers where id = :param1", params, (ResultSet rs, int row) -> {
            Offer offer = new Offer();
            offer.setId(rs.getInt("id"));
            offer.setName(rs.getString("name"));
            offer.setEmail(rs.getString("email"));
            offer.setText(rs.getString("text"));

            return offer;
        });
    }

    // delete
    public boolean delete(int id) {
        // if you want to use old way using question mark (?) to replace placeholder
        // jdbc.getJdbcOperations().

        MapSqlParameterSource params = new MapSqlParameterSource("param1", id);
        return jdbc.update("delete from offers where id = :param1", params) > 0; // returning numb of rows being affected
    }

    // create
    public boolean create(Offer offer) {
        // getting placeholder value from bean
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer); // creating set of parameters source based of bean property
        // placeholder must have same name with bean property !
        return jdbc.update("insert into offers(name, email, text) values(:name, :email, :text)", params) == 1; // only one row affected
    }

    // update
    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer); // creating set of parameters source based of bean property

        return jdbc.update("update offers set name = :name, email = :email, text = :text where id = :id", params) == 1;
    }

    // using batch
    // * just like PrepareStatement, defined only one, you can executeQuery over and over again with different value
    public int create(List<Offer> offers) {
        // MapSqlParameterSource[] params = new MapSqlParameterSource[offers.size()];
        // for (int i = 0; i < offers.size(); i++) {
        // params[i] = new MapSqlParameterSource();
        // params[i].addValue("param1", offers.get(i).getName());
        // params[i].addValue("param2", offers.get(i).getEmail());
        // params[i].addValue("param3", offers.get(i).getText());
        // }

        // shorthand
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        // * interface SqlParameterSource is parent of BeanPropertySqlParameterSource and MapSqlParameterSource

        return jdbc.batchUpdate("insert into offers(name, email, text) values(:name, :email, :text)", params).length; // returning array of int, which for each value is numb of rows affected by each update
    }

    // Transaction
    // Case 1 :
    // trans1(no = '001', id_cashier = 'C001', no_detail = 'D001', total = 300) - SUCCESS !
    // trans1(no = '002', id_cashier = 'C001', no_detail = 'D002', total = 150) - SUCCESS !
    // trans1(no = '003', id_cashier = 'C001', no_detail = 'D003', total = 200) - FAIL !
    // trans1(no = '004', id_cashier = 'C001', no_detail = 'D004', total = 400) - SUCCESS !
    // Transaction is FAIL !, 001 and 002 need ROLL-BACK !

    // Case 2 :
    // trans2(no = '005', id_cashier = 'C002', no_detail = 'D005', total = 120) - SUCCESS !
    // trans2(no = '006', id_cashier = 'C002', no_detail = 'D006', total = 170) - SUCCESS !
    // trans2(no = '007', id_cashier = 'C002', no_detail = 'D007', total = 300) - SUCCESS !
    // trans2(no = '008', id_cashier = 'C002', no_detail = 'D008', total = 430) - SUCCESS !
    // Transaction is SUCCESS !
    @Transactional
    public int transaction(List<Offer> offers){
        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
        return jdbc.batchUpdate("insert into offers(id, name, email, text) values(:id, :name, :email, :text)", params).length; // returning array of int, which for each value is numb of rows affected by each update
    }

}
