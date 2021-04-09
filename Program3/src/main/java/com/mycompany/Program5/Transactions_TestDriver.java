/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class Transactions_TestDriver 
{
    public static void main(String[] args)
    {
        Transaction t1 = new Transaction("00001", "Google", "Truck", "3d", "$100.00");
        Transaction t2 = new Transaction("12345", "Yahoo", "Car", "1m", "$600.00");
        Transaction t3 = new Transaction("50005", "Gideons Catering", "SUV", "1w", "$350.00");
        Transaction t4 = new Transaction("1", "Washington Post", "Car", "2M", "$600.00");
        Transaction t5 = new Transaction("1738", "Fortran", "SUV", "3M", "$1,000.00");
        
        Transactions t = new Transactions();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
        t.add(t5);
        
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        
    }
}
