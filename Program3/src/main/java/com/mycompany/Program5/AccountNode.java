/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class AccountNode 
{
    private Account head;
    private AccountNode next;
    
    //Constructor
    public AccountNode(Account head, AccountNode next)
    {
        this.head = head;
        this.next = next;
    }
    
    public Account gethead() 
    {
        return head;
    }
    public AccountNode getNext() 
    {
        return next;
    }
    public void sethead(Account value)
    {
        head = value;
    }
    public void setNext (AccountNode next) 
    {
        this.next = next;
    }

}
