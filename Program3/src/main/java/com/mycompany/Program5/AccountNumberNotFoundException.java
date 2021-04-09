/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class AccountNumberNotFoundException extends Exception
{
    public AccountNumberNotFoundException(String acct_num)
    {
        System.out.println("This Account number: " + acct_num + " was not found.");
    }
    
}
