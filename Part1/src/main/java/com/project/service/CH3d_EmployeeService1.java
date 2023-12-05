package com.project.service;

import com.project.entity.Employee;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CH3d_EmployeeService1 implements InitializingBean, DisposableBean {

    private Employee employee;

    public CH3d_EmployeeService1(){
        System.out.println(getClass().getCanonicalName() + " constructor with no-args is called");
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // NOT RECOMMENDED ! we can't create our method

    @Override
    public void afterPropertiesSet() { // post-init method
        System.out.println(getClass().getCanonicalName() + " initializing");
        // when we forgot injecting the name properties, will set into default name = "Unknown"
        if(employee.getName() == null) employee.setName("Unknown");
    }

    @Override
    public void destroy() { // pre-destroy method
        System.out.println(getClass().getCanonicalName() + " closing resources");
    }

}
