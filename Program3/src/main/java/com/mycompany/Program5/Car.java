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
public class Car extends Vehicle
{
    private int seats;

    public Car(String description, int mpg, String vin, Reservation resv, int seats, Cost rates)
    {
        super(description, mpg, vin);
        this.seats = seats;
    }
    
    public int getSeats()
    {
        return seats;
    }
    
    public String toString()
    {
        return getDescript() + "(Car)| MPG:" + getMPG() +  "| Seating: " + getSeats() + "| VIN: " + getVIN();
    }
    
}
