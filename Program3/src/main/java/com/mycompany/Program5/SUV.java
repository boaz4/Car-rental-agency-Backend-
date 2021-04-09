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
public class SUV extends Vehicle
{
    private int seats;
    private int cargo;

    public SUV(String description, int mpg, String vin, Reservation resv, int seats, int cargo, Cost rates)
    {
        super(description, mpg, vin);
        this.seats = seats;
        this.cargo = cargo;
    }
    
    public int getSeats()
    {
        return seats;
    }
    
    public int getCargo()
    {
        return cargo;
    }
    
    public String toString()
    {
        return getDescript() + "(SUV)| MPG: " + getMPG() +  "| Seating: " + getSeats() + "| Storage:" + getCargo() + " cu. ft.| VIN: " + getVIN();
    }
    
}


