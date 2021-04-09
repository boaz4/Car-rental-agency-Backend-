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
public class Transactions 
{
    
    private ArrayList<Transaction> Transactions ;
    private int current;
    
    public Transactions()
    {
        Transactions = new ArrayList<>();
        current = 0;
    }
    
    public void add(Transaction tran)
    {
        Transactions.add(tran);
    }
    
    public void reset()
    {
        current = 0;
    }
    
    public boolean hasNext()
    {
        if(current < Transactions.size())
        {
           return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public Transaction getNext()
    {
        current++;
        return Transactions.get(current -1); 
    }
    
    public void Traverse()
    {
        current++;
    }

    
    
}
