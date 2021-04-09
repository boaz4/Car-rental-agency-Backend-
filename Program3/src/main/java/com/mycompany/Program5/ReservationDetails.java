/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class ReservationDetails 
{
    private String VIN; 
    private int acct_num;
    private String rental_period;
    private boolean daily_insurance_option;
    private int vType;
    
    public ReservationDetails(String VIN, int acct_num, String rental_period, boolean daily_insurance_option, int vType)
    {
        this.VIN = VIN;
        this.acct_num = acct_num;
        this.daily_insurance_option = daily_insurance_option;
        this.rental_period = rental_period;
        this.vType = vType;
    }
    
     public String getVIN()
    {
        return VIN;
    }
    
    public int getacct_num()
    {
        return acct_num;
    }
    
    public boolean getdaily_insurance_option()
    {
        return daily_insurance_option;
    }
    
    public String getrental_period()
    {
        return rental_period;
    }
    
    public int getvType()
    {
        return vType;
    }
}
