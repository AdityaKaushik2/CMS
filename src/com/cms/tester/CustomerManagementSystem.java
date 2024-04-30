package com.cms.tester;

import com.cms.customer.Customer;

import java.util.Scanner;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        try(Scanner Sc = new Scanner(System.in)){
            boolean exit = false;
            System.out.println("Enter the total no of customers");
            int size = Sc.nextInt();
            Customer[] customers = new Customer[size];
            while (!exit){
                System.out.println("Enter Details");
                try{
                    switch (Sc.nextInt()){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            exit = true;
                            break;
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    Sc.nextLine();
                }
            }
        }
    }

}
