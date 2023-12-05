package com.project.service;

import com.project.entity.Employee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CH3d_EmployeeService3 {

    private Employee employee;

    public CH3d_EmployeeService3(){
        System.out.println(getClass().getCanonicalName() + " constructor with no-args is called");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // our custom post-init and pre-destroy method

    @PostConstruct
    public void init(){ // post-init method
        System.out.println(getClass().getCanonicalName() + " initializing");
        // when we forgot injecting the name properties, will set into default name = "Unknown"
        if (employee.getName() == null) employee.setName("Unknown");
    }

    @PreDestroy
    public void destroy(){ // pre-destroy method
        System.out.println(getClass().getCanonicalName() + " closing resources");
    }
}
