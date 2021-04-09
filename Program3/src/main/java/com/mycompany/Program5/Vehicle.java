/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

import Rates.Cost;

/**
 *
 */
public abstract class Vehicle 
{
    private String description;
    private int mpg;
    private String vin;
    private Reservation resv = null;
    private Cost rates;
    
    public Vehicle(String description, int mpg, String vin)
    {
        this.description = description;
        this.mpg = mpg;
        this.vin = vin;
        resv = null;
        rates = null;
    }
    
    public String getDescript()
    {
        return description;
    }
    
    public int getMPG()
    {
        return mpg;
    }
    
    public String getVIN()
    {
        return vin;
    }
    
    public Reservation getReservation()
    {
        return resv;
    }
    
    public Cost getCost()
    {
        return rates;
    }
    
    public void setCost(Cost c)
    {
        rates = c;
    }
    
    
    public abstract String toString();
    
    public boolean isReserved()
    {
        if (resv == null)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }
    
    public void reserve(Reservation r) throws ReservedVehicleException
    {
        if (resv == null)
        {
            resv = r;
        }
        else
        {
            throw new ReservedVehicleException(description);
        }
    }
    
    public void cancelReservation() throws UnreservedVehicleException
    {
        if(resv != null)
        {
            resv = null;
        }
        else
        {
            throw new UnreservedVehicleException(description);
        }
    }
    
    
    
}
