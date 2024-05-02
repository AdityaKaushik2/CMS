package com.cms.custom_ordering;

import com.cms.customer.Customer;
import java.util.Comparator;

public class CustomerDobAndLastNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        int value = o1.getDob().compareTo(o2.getDob());
        if(value == 0){
            if(o1.getLname().compareTo(o2.getLname()) < 0)
                return 1;
            if(o1.getLname().compareTo(o2.getLname()) > 0)
                return -1;
            return 0;
        }
        return value;
    }
}
