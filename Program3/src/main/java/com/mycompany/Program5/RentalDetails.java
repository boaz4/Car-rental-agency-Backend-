/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class RentalDetails 
{
    private int VehicleType;
    private String rental_period;
    private int est_NumMiles;
    private boolean insur;
    private boolean primeCust;
    
    public RentalDetails(int VehicleType,String rental_period, int est_NumMiles, boolean insur, boolean primeCust)
    {
        this.VehicleType = VehicleType;
        this.rental_period = rental_period;
        this.est_NumMiles = est_NumMiles;
        this.insur = insur;
        this.primeCust = primeCust;
    }
    
    public int getVehicleType()
    {
        return VehicleType;
    }
    
    public String getRental_period()
    {
        return rental_period;
    }
    
    public int getest_NumMiles()
    {
        return est_NumMiles;
    }
    
    public boolean getinsur()
    {
        return insur;
    }
    
    public boolean getprimeCust()
    {
        return primeCust;
    }
    
}
