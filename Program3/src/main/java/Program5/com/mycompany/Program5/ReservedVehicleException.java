/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class ReservedVehicleException extends Exception
{
    public ReservedVehicleException(String description)
    {
        System.out.println("The vehicle " + description + " has already been reserved");
    }
}
