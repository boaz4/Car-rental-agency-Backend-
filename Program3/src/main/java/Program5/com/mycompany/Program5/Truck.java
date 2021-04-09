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
public class Truck extends Vehicle
{
  
    private int load;

    public Truck(String description, int mpg, String vin, Reservation resv, int load, Cost rates)
    {
        super(description, mpg, vin);
        this.load = load;
    }
    
    public int getLoad()
    {
        return load;
    }
    
    public String toString()
    {
        return getDescript() + "(Truck)| MPG:" + getMPG() +  "| Load Capacity: " + getLoad() + " llbs|  VIN: " + getVIN();
    }
    
}


