package com.cms.tester;

import com.cms.customer.Customer;
import com.cms.utils.CustomerValidations.validateInputs;
import java.util.Scanner;

import static com.cms.utils.CustomerValidations.validateInputs;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            boolean exit = false;
            System.out.println("Enter the total no of customers");
            int size = sc.nextInt();
            Customer[] customers = new Customer[size];
            int counter  = 0;
            while (!exit){
                System.out.println("Enter The Choice+\n 1.Enter The Details toRegister\n 3. Exit");
                try{
                    switch (sc.nextInt()){
                        case 1:
                            if (counter < customers.length) {
                                System.out.println("Enter customers details -  acctNo,  firstName, lastName,email, password, registration amount, plan");
                                Customer cust = validateInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(),sc.next(), sc.nextDouble(), sc.nextDouble(),  sc.next(), customers);
                                customers[counter++] = cust;
                                System.out.println("A/c created !");

                            } else
                                System.out.println("Bank capacity full !!!!");

                            break;
                            break;
                        case 2:
                            break;
                        case 3:
                            exit = true;
                            break;
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }
        }
    }

}
