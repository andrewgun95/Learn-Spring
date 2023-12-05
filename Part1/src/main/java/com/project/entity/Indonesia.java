package com.project.entity;

public class Indonesia {

    private String president;
    private String vicePresident;

    private String language;
    private String capital;
    private String currency;

    public Indonesia() {
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVicePresident() {
        return vicePresident;
    }

    public void setVicePresident(String vicePresident) {
        this.vicePresident = vicePresident;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Indonesia{" +
                "president='" + president + '\'' +
                ", vicePresident='" + vicePresident + '\'' +
                ", language='" + language + '\'' +
                ", capital='" + capital + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
