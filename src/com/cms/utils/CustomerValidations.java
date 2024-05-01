package com.cms.utils;

import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;
import com.cms.customer.ServicePlan;
import java.time.LocalDate;
import java.util.List;

public class CustomerValidations {
    public static Customer validateAllInputs(String fname, String lname, String email, String password, double registrationAmount,
                                                    String dob, String Plan, List<Customer> accounts) throws CustomerException {
        checkDuplicate(email, accounts);
        ServicePlan plan = parseAndValidateServicePlanAndCharges(Plan, registrationAmount);
        LocalDate birthDate = LocalDate.parse(dob);
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

    public static ServicePlan parseAndValidateServicePlanAndCharges(String plan, double amount) throws CustomerException {
        ServicePlan planType =  ServicePlan.valueOf(plan.toUpperCase());
        if(planType.getPlanCharge() == amount)
            return planType;
        throw new CustomerException("Registration Amt.. Doesn't Match");
    }

    public static int verifyUser(String email, String password, List<Customer> accounts) throws CustomerException   {
        Customer customer = new Customer(email);
        int index;
        if(accounts.contains(customer)){
            index = accounts.indexOf(customer);
            if(accounts.get(index).getPassword().equals(password)) {
                System.out.println("Login Success");
                return index;
            }
            else
                throw new CustomerException("Invalid Password");
        }
        else
            throw new CustomerException("Invalid Email");
    }
    public static Customer login(String email, String password, List<Customer> accounts) throws CustomerException{
        int index = verifyUser(email,password,accounts);
        Customer c = accounts.get(index);
        return c;
    }

    public static void resetPassword(String newPassword,Customer customer){
        customer.setPassword(newPassword);
        System.out.println("Password Reset Success");
    }
}
