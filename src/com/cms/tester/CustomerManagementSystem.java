package com.cms.tester;

import com.cms.custom_ordering.CustomerPlanTypeComparator;
import com.cms.customer.Customer;

import java.util.*;
import com.cms.custom_ordering.CustomerDobAndLastNameComparator;
import static com.cms.utils.CMSValidations.*;
import static com.cms.utils.CustomerValidations.*;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = false;
            HashMap<String,Customer> accounts = populated();
            while (!exit) {
                try {
                    System.out.println("1.Enter User Details\n" + "2.Display AllUsers\n" + "3. To Login\n" + "4.To Unsubscribe\n" + "5. To Sort By Email\n" + "6. To Sort by DoB n Last Name\n" +"7. To Sort By Service Type\n8. Delete User Based on DOB and Service Type\n" +"0.Exit");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println(
                                    "Enter Customer Details In Following Order\nFirstname Lastname Email Password RegistrationAmount DOB plan");
                            Customer c = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(),
                                    sc.next(), sc.next(), accounts);
                            accounts.put(c.getEmail(), c);
                            break;
                        case 2:
                            // Display All Users
                            for (Customer customerAccount : accounts.values()) {
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
                                Customer pas = resetPassword(sc.next(),newUser, accounts);
                                System.out.println("New Details");
                                System.out.println(pas);
                            }
                            break;
                        case 4:
                            //UnSubscribe
                            System.out.println("Enter  Email and Password");
                            String email= sc.next();
                            String password = sc.next();
                            verifyUser(email, password,  accounts);
                            unsubscribe(email,accounts);
                            System.out.println("User UnSubscribed");
                            break;
                        case 5:
                            System.out.println("Sorting By Email");
                            TreeMap<String, Customer> sortedAccounts = new TreeMap<>(accounts);
                            for (Customer ca : sortedAccounts.values()) {
                                System.out.println(ca);
                            }
                            break;
                        case 6:
                            System.out.println("Sorting By DOB and LastName");
                            LinkedList<Customer> list = new LinkedList<>(accounts.values());
                            list.sort(new CustomerDobAndLastNameComparator());
                            for (Customer ca : list){
                                System.out.println(ca);
                            }
                            break;
                        case 7:
                            LinkedList<Customer> list2 = new LinkedList<>(accounts.values());
                            System.out.println("Sorting By Service Type");
                            list2.sort(new CustomerPlanTypeComparator());
                            for (Customer ca : list2){
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
