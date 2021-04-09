/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class Account 
{
    private String acct_num;
    private String comany_name;
    private boolean prime_customer;
    
    //methods
    public Account(String acct_num, String comany_name, boolean prime_customer)
    {
        this.acct_num = acct_num;
        this.comany_name = comany_name;
        this.prime_customer = prime_customer;
    }
    
    public String getAcctNum()
    {
        return acct_num;
    }
    
    public boolean prime_customer()
    {
        return prime_customer == true;
    }
    
    public String toString()
    {
        return "Account number: " + getAcctNum() + " | Company Name: " + comany_name + " | Prime Customer?: " + prime_customer();
    }
}
