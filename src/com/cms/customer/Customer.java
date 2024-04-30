package com.cms.customer;

import java.time.LocalDate;

public class Customer {
    private static int customerId = 1;
    String fName;
    String lName;
    String password;
    double registrationAmount;
    LocalDate dob;
    ServicePlan plan;


    public Customer(String fName, String lName, String password, double registrationAmount, LocalDate dob, ServicePlan plan){
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.registrationAmount = registrationAmount;
        this.dob = dob;
        this.plan = plan;
        customerId++;
    }
}


