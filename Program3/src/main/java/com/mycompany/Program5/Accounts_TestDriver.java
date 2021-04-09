/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
import java.util.*;
public class Accounts_TestDriver 
{
    public static void main(String[] args) throws AccountNumberNotFoundException, InvalidAcctNumException
    {
        
        int menu;
        
        Scanner cin = new Scanner(System.in);
        Accounts accounts = new Accounts();
        
        Account a1 = new Account("00001", "Google", true);
        Account a2 = new Account("12345", "Yahoo", false);
        Account a3 = new Account("50005", "Gideons Catering", true);
        Account a4 = new Account("1", "Washington Post", true);
        Account a5 = new Account("1738", "Fortran", false);
        
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);
        
        
         do
        {
            System.out.println("1- Add new account");
            System.out.println("2- View existing account");

            menu = cin.nextInt();

            switch(menu)
            {
                case 1:
                    String accNum;
                    String CompanyName;
                    boolean Prime;
                    
                    
                     System.out.print("Enter Account #: ");
                     accNum = cin.next();
                     
                     System.out.print("Enter Company Name: ");
                     CompanyName = cin.next();
                     
                     System.out.print("Would you like to become a prime customer? (TRUE or FALSE): ");
                     Prime = cin.nextBoolean();
                     
                     Account newacc = new Account(accNum, CompanyName, Prime);
                     
                     accounts.add(newacc);
                     System.out.println(accounts.getAccount(accNum));
                     
                    break;
                    
                case 2:
                    
                    System.out.print("Enter Account #: ");
                    accNum = cin.next();
                    
                    System.out.println(accounts.getAccount(accNum));
                    
                    
                    
                    break;
                    
                default:
                    System.out.println("INVALID INPUT");
            }
        } while(menu >= 1 && menu < 3);
        
    }
}
