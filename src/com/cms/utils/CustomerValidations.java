package com.cms.utils;

import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;
import com.cms.customer.ServicePlan;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerValidations {
    public static Customer validateAllInputs(String fname, String lname, String email, String password, double registrationAmount,
                                             String dob, String Plan, HashMap<String, Customer> accounts) throws CustomerException {

        checkDuplicate(email, accounts);
        checkEmail(email);
        checkPassword(password);
        LocalDate birthDate = LocalDate.parse(dob);
        ServicePlan plan = parseAndValidateServicePlanAndCharges(Plan, registrationAmount);
        checkAge(birthDate);
        return new Customer(fname, lname, email, password, registrationAmount,
                birthDate, plan);
    }

    public static void checkDuplicate(String email, HashMap<String, Customer> accounts) throws CustomerException {
        // create customer class instance wrapping PK
        Customer c = new Customer(email);
        if (accounts.containsKey(email))
            throw new CustomerException("Duplicate");
    }

    public static void checkPassword(String password) throws CustomerException {
        String passRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
        if (password.matches(passRegex) == false)
            throw new CustomerException("Enter Strong Password");
    }
    public static void checkEmail(String email) throws CustomerException {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email.matches(emailRegex) == false)
            throw new CustomerException("Enter Valid Email");
    }

    public static void checkAge(LocalDate dob) throws CustomerException {
        LocalDate current = LocalDate.now();
        Period age = Period.between(dob, current);
        if (age.getYears() < 18)
            throw new CustomerException("Age Must be above 18");
    }

    public static ServicePlan parseAndValidateServicePlanAndCharges(String plan, double amount) throws CustomerException {
        ServicePlan planType = ServicePlan.valueOf(plan.toUpperCase());
        if (planType.getPlanCharge() == amount)
            return planType;
        throw new CustomerException("Registration Amt.. Doesn't Match");
    }

    public static HashMap<String,Customer> populated() {
        Customer c1 = new Customer("Aditya", "Kaushik", "Adi@gmail.com", "Aditya@123", 1000, LocalDate.parse("2002-02-02"), ServicePlan.SILVER);
        Customer c2 = new Customer("Archit", "Kaushik", "Archit@gmail.com", "Archit@123", 2000, LocalDate.parse("2005-01-12"), ServicePlan.GOLD);
        Customer c3 = new Customer("Ankit", "Gupta", "Ankit@gmail.com", "Ankit@123", 5000, LocalDate.parse("2004-03-10"), ServicePlan.DIAMOND);
        Customer c4 = new Customer("Hency", "Kashyap", "Hency@gmail.com", "Hency@123", 10000, LocalDate.parse("2000-10-23"), ServicePlan.PLATINUM);
        Customer c5 = new Customer("Harsh", "Vardhan", "Harsh@gmail.com", "Harsh@123", 2000, LocalDate.parse("1999-08-15"), ServicePlan.GOLD);
        Customer c6 = new Customer("Tejas", "Vinod", "Tejas@gmail.com", "Tejas@123", 2000, LocalDate.parse("1999-08-15"), ServicePlan.GOLD);
        Customer[] customerArray = {c1, c2, c3, c4, c5, c6};
        HashMap<String,Customer> customerList = new HashMap<>();
        for (Customer c : customerArray)
            customerList.put(c.getEmail(), c);
        return customerList;
    }
}
