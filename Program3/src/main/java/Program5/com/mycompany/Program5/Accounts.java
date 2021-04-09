/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

public class Accounts 
{
    private AccountNode accounts;
    private AccountNode current;
    
    public Accounts()
    {
      accounts = null;
      current = null;   
    }
    public void add(Account add)
    {
        AccountNode temp;
        temp = accounts;
        
        if(accounts == null)//Is linked list empty?
        {
            accounts = new AccountNode(add, null);
        }
        else
        {
            while(temp.getNext() != null)
            {
                temp = temp.getNext(); // get next node until reach end
            }
            
            temp.setNext(new AccountNode(add,null)); //set new Account
        }
       
        
    }
    
    public void reset()
    {
        current = accounts;
    }
    
    public Account getAccount(String acct_num) throws AccountNumberNotFoundException, InvalidAcctNumException 
    {
        AccountNode temp;
        temp = accounts;
        Account Acc;
        Acc = null;
        
        boolean valid;
        boolean found;
        found = false;
        
        valid = isValidAccountNumber(acct_num);
        
        if(valid == true)//if its valid proceed
        {
        
            while(temp.getNext()!= null)
            {
                temp = temp.getNext(); // get next node until reach end
                if (temp.gethead().getAcctNum().equals(acct_num))
                {
                    found = true;
                    Acc = temp.gethead();
                    
                }
            }
        }
        else
        {
            throw new InvalidAcctNumException(acct_num);
        }
        
        if(found == false)
        {
            throw new AccountNumberNotFoundException(acct_num);
        }
            return Acc;
    }
    
    private boolean isValidAccountNumber(String acct_num) throws InvalidAcctNumException
    {
        boolean valid;
        valid = false;
        
        if(acct_num.length() <= 5)
        {
            for(int i = 0; i < acct_num.length(); i++)
            {
                char c;
                c = acct_num.charAt(i);
                
                if(Character.isDigit(c) == true)
                {
                    valid = true;
                }
            }
        }
        
        else
        {
            valid = false;
            
        }
        
        return valid;
    
        
    }
    public boolean hasNext()
    {
        return current.getNext() != null;
    }
    public Account getNext()
    {
        current =  current.getNext();
        return current.gethead();
    }
}
