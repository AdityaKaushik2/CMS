package com.cms.utils;

import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;
import com.cms.customer.ServicePlan;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CustomerValidations {
    public static Customer validateAllInputs(String fname, String lname, String email, String password, double registrationAmount,
                                                    String dob, String Plan, List<Customer> accounts) throws CustomerException {
        checkDuplicate(email, accounts);
        checkPassword(password);
        ServicePlan plan = parseAndValidateServicePlanAndCharges(Plan, registrationAmount);
        LocalDate birthDate = LocalDate.parse(dob);
        checkAge(birthDate);
        return new Customer(fname, lname, email,  password, registrationAmount,
                birthDate,  plan);
    }
    public static void checkDuplicate(String email, List<Customer> accounts) throws CustomerException {
        // create customer class instance wrapping PK
        Customer c = new Customer(email);
        if (accounts.contains(c)) {
            throw new CustomerException("Duplicate email");
        }
    }
    public static void checkPassword(String password) throws CustomerException{
        String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
        if(password.matches(regex) == false)
            throw new CustomerException("Enter Strong Password");
    }

    public static void checkAge(LocalDate dob) throws CustomerException{
        LocalDate current = LocalDate.now();
        Period age = Period.between(dob,current);

        if(age.getYears() < 18)
            throw new CustomerException("Age Must be above 18");
    }
    public static ServicePlan parseAndValidateServicePlanAndCharges(String plan, double amount) throws CustomerException {
        ServicePlan planType =  ServicePlan.valueOf(plan.toUpperCase());
        if(planType.getPlanCharge() == amount)
            return planType;
        throw new CustomerException("Registration Amt.. Doesn't Match");
    }

    public static List<Customer> populated() {
        Customer c1 = new Customer("Aditya", "Kaushik", "Adi@gmail.com", "201204", 1000, LocalDate.parse("2002-02-02"), ServicePlan.SILVER);
        Customer c2 = new Customer("Archit", "Kaushik", "Archit@gmail.com", "23451", 2000, LocalDate.parse("2005-01-12"), ServicePlan.GOLD);
        Customer c3 = new Customer("Ankit", "Gupta", "Ankit@gmail.com", "123456", 5000, LocalDate.parse("2004-03-10"), ServicePlan.DIAMOND);
        Customer c4 = new Customer("Hency", "Kashyap", "Hency@gmail.com", "654321", 10000, LocalDate.parse("2000-10-23"), ServicePlan.PLATINUM);
        Customer c5 = new Customer("Harsh", "Vardhan", "Harsh@gmail.com", "112233", 2000, LocalDate.parse("1999-08-15"), ServicePlan.GOLD);
        Customer c6 = new Customer("ABC", "Aditya", "Harsh@gmail.com", "112233", 2000, LocalDate.parse("1999-08-15"), ServicePlan.GOLD);

        Customer[] customerArray = {c1, c2, c3, c4, c5,c6};
        List<Customer> customerList = new ArrayList<>();
        for (Customer c : customerArray)
            customerList.add(c);

        return customerList;
    }
}
