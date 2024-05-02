package com.cms.tester;

import com.cms.custom_ordering.CustomerPlanTypeComparator;
import com.cms.customer.Customer;

import java.util.*;
import java.util.Collections;
import com.cms.custom_ordering.CustomerDobAndLastNameComparator;
import static com.cms.utils.CMSValidations.*;
import static com.cms.utils.CustomerValidations.*;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            List<Customer> accounts = populated();
            while (!exit) {
                try {
                    System.out.println("1.Enter User Details\n" + "2.Display AllUsers\n" + "3. To Login\n" + "4.To Unsubscribe\n" + "5. To Sort By Email\n" + "6. To Sort by DoB n Last Name\n" +"7. To Sort By Service Type\n" +"0.Exit");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println(
                                    "Enter Customer Details In Following Order\nFirstname Lastname Email Password RegistrationAmount DOB plan");
                            Customer c = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
                                    sc.next(), sc.next(), accounts);
                            accounts.add(c);
                            break;
                        case 2:
                            // Display All Users
                            for (Customer customerAccount : accounts) {
                                System.out.println(customerAccount);
                            }
                            break;
                        case 3:
                            // log in
                            System.out.println("Enter  Email and Password");
                            Customer newUser = verifyUser(sc.next(), sc.next(), accounts);
                            System.out.println("To reset Password press 1 and any other key to goto menu");
                            int n = sc.nextInt();
                            if (n == 1) {
                                System.out.println("Enter New Password");
                                resetPassword(sc.next(), newUser);
                                System.out.println("New Details");
                                System.out.println(newUser);
                            }
                            break;
                        case 4:
                            //UnSubscribe
                            System.out.println("Enter  Email and Password");
                            Customer loggedUser = verifyUser(sc.next(), sc.next(), accounts);
                            unsubscribe(loggedUser, accounts);
                            System.out.println("User UnSubscribed");
                            break;
                        case 5:
                            System.out.println("Sorting By Email");
                            Collections.sort(accounts);
                            for (Customer ca : accounts){
                                System.out.println(ca);
                            }
                            break;
                        case 6:
                            System.out.println("Sorting By DOB and LastName");
                            Collections.sort(accounts, new CustomerDobAndLastNameComparator());
                            for (Customer ca : accounts){
                                System.out.println(ca);
                            }
                            break;
                        case 7:
                            System.out.println("Sorting By Service Type");
                            Collections.sort(accounts, new CustomerPlanTypeComparator());
                            for (Customer ca : accounts){
                                System.out.println(ca);
                            }
                            break;
                        case 0:
                            exit = true;
                            System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }
}
