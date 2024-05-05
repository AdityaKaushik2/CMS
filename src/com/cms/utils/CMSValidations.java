package com.cms.utils;
import com.cms.custom_exceptions.CustomerException;
import com.cms.customer.Customer;
import java.util.ArrayList;
import java.util.HashMap;

import static com.cms.utils.CustomerValidations.checkPassword;

public class CMSValidations {

    public static Customer verifyUser(String email, String password, HashMap<String,Customer> accounts) throws CustomerException   {
            if(accounts.containsKey(email)) {
                ArrayList<Customer> c = new ArrayList<>(accounts.values());
                Customer newCustomer = new Customer(email,password);
                int index = c.indexOf(newCustomer);
                if(index != -1){
                    Customer customer = c.get(index);
                    if(customer.getPassword().equals(password)){
                        return customer;
                    }
                }
            }
            throw new CustomerException("Invalid Credentials");
    }
    public static Customer resetPassword(String newPassword,Customer user, HashMap<String,Customer> accounts) throws CustomerException{
        if(!user.getPassword().equals(newPassword)){
            checkPassword(newPassword);
            user.setPassword(newPassword);
            System.out.println("Password Reset Success");
        }
        return user;
    }
    public static void unsubscribe(String email, HashMap<String, Customer> accounts)
    {
        accounts.remove(email);
    }
}
