package com.cms.utils;

import com.cms.customer.Customer;
import com.cms.customer.ServicePlan;
import static com.cms.customer.Customer.getCustomerId;
import java.time.LocalDate;

public class CustomerValidations {
    public static Customer validateInputs(String fName,
    String lName,
    String password,
    double registrationAmount,
    String dob,
    String plan, Customer[] customer
)   {
        checkDup(getCustomerId(),customer);
        parseDate(dob);
        return new Customer(fName,lName,password,registrationAmount,dob,plan);
    }

    public static void checkDup(int accountId, Customer[] customer){

    }
    public static LocalDate parseDate(String dob) {
        return LocalDate.parse(dob);
    }
    public static ServicePlan parseAndValidateAcType(String plan) {
        return ServicePlan.valueOf(plan.toUpperCase());
    }


}
