package com.project.service;

import com.project.entity.Employee;

/**
 * EmployeeService is class to manage employee bean
 */
public class CH3d_EmployeeService2 {

    private Employee employee;

    public CH3d_EmployeeService2() {
        System.out.println(getClass().getCanonicalName() + " constructor with no-args is called");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // our custom post-init and pre-destroy method

    // post-init method
    public void init() {
        System.out.println(getClass().getCanonicalName() + " initializing");
        // when we forgot injecting the name properties, will set into default name = "Unknown"
        if (employee.getName() == null) employee.setName("Unknown");
    }

    // pre-destroy method
    public void destroy() {
        System.out.println(getClass().getCanonicalName() + " closing resources");
    }
}
