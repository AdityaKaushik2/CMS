package com.cms.utils;
import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;
import com.cms.customer.ServicePlan;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class CMSValidations {
    public static Customer verifyUser(String email, String password, String dob, List<Customer> accounts) throws CustomerException   {
        LocalDate date = LocalDate.parse(dob);
        Customer newCustomer = new Customer(email ,date);
        int index = accounts.indexOf(newCustomer);
        if(index != -1){
            Customer customer = accounts.get(index);
            if(customer.getPassword().equals(password)){
                return customer;
            }
            throw new CustomerException("Wrong Password");
        }
        else{
            throw new CustomerException("Invalid Credentials");
        }
    }
    public static void resetPassword(String newPassword,Customer customer){
        customer.setPassword(newPassword);
        System.out.println("Password Reset Success");
    }
    public static void unsubscribe(Customer customer, List<Customer> accounts)
    {
        accounts.remove(customer);
    }
    public static void delUser(String dob,String plan, List<Customer> accounts){
        Iterator<Customer> itr = accounts.iterator();
        LocalDate date= LocalDate.parse(dob);
        ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
        while (itr.hasNext()){
            Customer c = itr.next();
            if((c.getDob().isAfter(date)) && (c.getPlan()==servicePlan)){
                itr.remove();
            }
        }
    }
}
