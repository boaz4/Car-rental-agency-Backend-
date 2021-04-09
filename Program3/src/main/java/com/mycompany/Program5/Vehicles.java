/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Program5;

/**
 *
 */
import java.util.*;
public class Vehicles
{
    private ArrayList<Vehicle> agency_vehicles;
    private int current;
    
    //private VehicleNode head;
    
    public Vehicles()
    {
        agency_vehicles = new ArrayList<Vehicle>();
        current = 0;
        //head = null;
    }
    
    public void add(Vehicle v)
    {
        agency_vehicles.add(v);
    }
    
    public void remove(String VIN) throws VINNotFoundException
    {
        boolean found;
        int i;
        i = 0;
        found = false;
        
        while(i < agency_vehicles.size())
        {
            Vehicle v;
            v = agency_vehicles.get(i);
            
            if(v.getVIN().equals(VIN))
            {
                found = true;
                break;
            }
            i++;
        }
        
        if(found == true)
            {
                System.out.println(agency_vehicles.get(i) + " was removed.");
                agency_vehicles.remove(i);
                
            }
            else
            {
                throw new VINNotFoundException(VIN);
            }
    }
    
    public Vehicle getVehicle(String VIN) throws VINNotFoundException
    {
        Vehicle v = null; 
        boolean flag = false;
        
        for (int i = 0; i < agency_vehicles.size(); i++)
        {
            v = agency_vehicles.get(i);

            if (v.getVIN().equals(VIN))
            {
                flag = true;
                break;
            }
        }
        
        if (flag == true)
            {
                return v;
            }
            else 
            {
                throw new VINNotFoundException(VIN);
            }
        
    }
    
    
    public void reset()
    {
        current = 0;
    }
    
    public boolean hasNext()
    {
        if(current < agency_vehicles.size())
        {
           return true;
        }
        else 
        {
            return false;
        }
    }
    
    public Vehicle getNext()
    {
        current++;
        return agency_vehicles.get(current - 1); 
        
    }
    
    public void Traverse()
    {
        current++;
    }
    
    
    
    /*linked list stuff
    public void append(Vehicle v)
    {
        VehicleNode temp = head;
        
        if (head == null)
        {
            head = new VehicleNode(v, null);
        }
        else 
        {
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(new VehicleNode(v, null));
        }
    }
    
    public boolean isEmpty()
    {
        if (head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void print()
    {
        VehicleNode temp = head;
        
        /*while(temp.getNext() != null)
        {
            temp = temp.getNext();
        }
        
        while(temp != null)
        {
            System.out.println(temp.getV());
            temp = temp.getNext();
        
        }
    }
    
    public int size()
    {
        VehicleNode temp;
        int count;
        count = 0;
        temp = head;
            
        while(temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
    
    public void delete(String VIN)
    {
        
        
        if (head.getV().getVIN().equals(VIN)) // first node contains value to delete?
        {
            System.out.println(head.getV() + " was removed.");
            head = head.getNext();
        }
        else // deleting node other than first
        {
            VehicleNode lead_node = head.getNext();
            VehicleNode trailing_node = head;
            while (!trailing_node.getV().getVIN().equals(VIN))
            {
                trailing_node = lead_node;
                lead_node = lead_node.getNext();
            }
            trailing_node.setNext(lead_node.getNext()); // works even if deleting last node
            System.out.println(head.getV() + " was removed.");
        }
    }*/
    
}
