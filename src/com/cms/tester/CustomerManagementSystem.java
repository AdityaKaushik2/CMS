package com.cms.tester;

import com.cms.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.cms.utils.CustomerValidations.validateAllInputs;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            List<Customer> accounts = new ArrayList<>();
            while (!exit) {
                try {
                    System.out.println("1.Enter User Details\n 2.Display AllUsers\n3.Exit");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Enter Customer Details\n Fname Lname Email Password RegistrationAmount DOB plan");
                            Customer c = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),accounts);
                            accounts.add(c);
                            break;
                        case 2:
                            for (Customer customerAccount : accounts) {
                                System.out.println(customerAccount);
                            }
                            break;
                        case 3:

                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }
}
