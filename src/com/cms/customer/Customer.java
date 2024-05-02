package com.cms.customer;

import java.time.LocalDate;

public class Customer {
    private int customerid;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private double registrationAmount;
    private LocalDate dob;
    private ServicePlan plan;
    private static int idGeneration;

    public Customer(String fname, String lname, String email, String password, double registrationAmount,
                           LocalDate dob, ServicePlan plan) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.registrationAmount = registrationAmount;
        this.dob = dob;
        this.plan = plan;
        this.customerid = ++idGeneration;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationAmount=" + registrationAmount +
                ", dob=" + dob +
                ", plan=" + plan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Customer) {
            // Downcasting Object o to CustomerAccount and storing it in c object of
            // CustomerAccount
            Customer c = (Customer) o;
            // invoker's object email = this.email
            return this.email.equals(c.email);
        }
        return false;
    }
}


