/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class Transaction 
{
    private String acct_num;    // five-digit acct number
    private String company_name;
    private String vehicle_type; // car, SUV or Truck
    private String rental_period; // days, week, months
    private String rental_cost;
    
    public Transaction(String a_num, String cName, String vType, String rp, String rCost)
    {
        acct_num = a_num;
        company_name = cName;
        vehicle_type = vType;
        rental_period = rp;
        rental_cost = rCost;
    }
    
    public String toString()
    {
        return "Account Number: " + acct_num + " |Company Name: " + company_name + " |Vehicle type: " + vehicle_type + " |Rental period: " + rental_period + " |Rental Cost: " + rental_cost; 
    }
}
