/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class Reservation 
{
    private int acctNum;   		// account number of company account
 	private int vehicleType;	                          // 1-car, 2-SUV, 3-Truck
	private String description;                      // e.g., Honda Odyssey
	private String rentalPeriod; 		// e.g., “D4” (four days), “W2” (two weeks), “M1” (one month)
	private	boolean insuranceSelected;	// set to true if optional daily insurance wanted

    
    public Reservation(int acctNum, String description, String rentalPeriod, boolean insuranceSelected)
    {
        this.acctNum = acctNum;
        this.description = description;
        this.rentalPeriod = rentalPeriod;
        this.insuranceSelected = insuranceSelected;
    }
    
    public int getacctNum()
    {
        return acctNum;
    }
    
    public String getdescription()
    {
        return description;
    }
    
    public String getrentalPeriod()
    {
        return rentalPeriod;
    }
    
    
    public boolean getInsuranceSelected()
    {
        return insuranceSelected;
    }
    
    public String toString()
    {
        return "Account Number: " +  getacctNum()  + " Description: " + getdescription() + " Rental period: " + getrentalPeriod() +  " Insurance Selected: "  + getInsuranceSelected();
    }
    
}
