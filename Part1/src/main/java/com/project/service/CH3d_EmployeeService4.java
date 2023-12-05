package com.project.service;

import com.project.entity.Employee;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class CH3d_EmployeeService4 implements InitializingBean{

    public Employee employee;

    public CH3d_EmployeeService4() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "CH3d_EmployeeService4{" +
                "employee=" + employee +
                '}';
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(getClass().getCanonicalName() + " initializing using Initializing Bean");
    }

    public void init(){
        System.out.println(getClass().getCanonicalName() + " initializing using custom init method");
    }

    @PostConstruct
    public void construct(){
        System.out.println(getClass().getCanonicalName() + " initializing using custom post construct annotation");
    }
}
