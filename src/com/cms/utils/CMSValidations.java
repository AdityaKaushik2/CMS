package com.cms.utils;

import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;

import java.util.List;

public class CMSValidations {
    public static Customer verifyUser(String email, String password, List<Customer> accounts) throws CustomerException   {
        Customer newCustomer = new Customer(email);
        int index = accounts.indexOf(newCustomer);
        if(index != -1){
            Customer customer = accounts.get(index);
            if(customer.getPassword().equals(password)){
                return customer;
            }
            throw new CustomerException("Wrong Password");
        }
        else{
            throw new CustomerException("Invalid Email");
        }
    }
    public static void resetPassword(String newPassword,Customer customer){
        customer.setPassword(newPassword);
        System.out.println("Password Reset Success");
    }

}
