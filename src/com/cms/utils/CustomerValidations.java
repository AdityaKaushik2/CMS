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


}
