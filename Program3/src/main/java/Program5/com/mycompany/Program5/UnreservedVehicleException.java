/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
public class UnreservedVehicleException extends Exception
{
    public UnreservedVehicleException(String description)
    {
        System.out.println("This vehicle reservation " + description + " does not exist");
    }

}
