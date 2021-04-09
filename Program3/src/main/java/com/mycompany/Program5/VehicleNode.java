/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class VehicleNode 
{
    private Vehicle v;
    private VehicleNode next;
    
    public VehicleNode(Vehicle v, VehicleNode next)
    {
        this.v = v;
        this.next = next;
    }
    
    //getter
    public Vehicle getV()
    {
        return v;
    }
    
    public VehicleNode getNext()
    {
        return next;
    }
    
    public void setInfo(Vehicle v) 
    {
        this.v = v;
    }
    
    public void setNext(VehicleNode next)
    {
        this.next = next;
    }
    
    
}
