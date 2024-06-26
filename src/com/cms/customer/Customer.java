package com.cms.customer;
import java.time.LocalDate;
import java.util.Objects;

public class Customer {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private double registrationAmount;
    private LocalDate dob;
    private ServicePlan plan;

    public Customer(String fname, String lname, String email, String password, double registrationAmount,
                    LocalDate dob, ServicePlan plan) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.registrationAmount = registrationAmount;
        this.dob = dob;
        this.plan = plan;
    }

    //Primary Key Checking Constructor
    public Customer(String email) {
        this.email = email;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return
                fname + " "+ lname  + " " +
                 email  + " " +
                 password  + " " +
                 registrationAmount + " " +
                dob + " " +
                 plan
                ;
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

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRegistrationAmount() {
        return registrationAmount;
    }

    public void setRegistrationAmount(double registrationAmount) {
        this.registrationAmount = registrationAmount;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public ServicePlan getPlan() {
        return plan;
    }

    public void setPlan(ServicePlan plan) {
        this.plan = plan;
    }
}


