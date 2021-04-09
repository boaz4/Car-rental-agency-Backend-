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
public class Test_Driver 
{
    public static void main(String[] args) throws VINNotFoundException, ReservedVehicleException, UnreservedVehicleException
    {
        int MenuChoice;
        Scanner cin = new Scanner(System.in);
        
        Car car1 = new Car("Chevrolet Camaro - 2018", 30, "HK4GM4565GD", null, 2, null);
        Car car2 = new Car("Ford Fusion - 2019", 34, "AB4FG5689GM", null, 4, null);
        Car car3 = new Car("Ford Fusion Hybrid - 2017", 32, "KU4EG3245RW", null, 4, null);
        Car car4 = new Car("Chevrolet Impala - 2019", 30, "RK3BM4256YH", null, 4, null);
    
    
        SUV suv1 = new SUV("Honda Odyssey - 2020", 28, "VM9RF2635TD", null, 7, 6, null);
        SUV suv2 = new SUV("Dodge Caravan - 2019", 25, "QK3FL4273ME", null, 5, 4, null);
        SUV suv3 = new SUV("Ford Expedition - 2018", 20, "JK2RT9364HY", null, 5, 3, null);
    
    
        Truck Truck1 = new Truck("Ten-Foot", 12, "EJ5KU2435BC", null, 2810, null);
        Truck Truck2 = new Truck("Seventeen-Foot", 10, "KG4DM5472RK", null, 5930, null);
        Truck Truck3 = new Truck("Twenty-Four-Foot", 8, "EB2WR3082QB", null, 6500, null);
        Truck Truck4 = new Truck("Twenty-Four-Foot", 8, "TW3GH4290EK", null, 6500, null);
    
        Vehicles v = new Vehicles();
        v.add(car1);
        v.add(car2);
        v.add(car3);
        v.add(car4);
        v.add(suv1);
        v.add(suv2);
        v.add(suv3);
        v.add(Truck1);
        v.add(Truck2);
        v.add(Truck3);
        v.add(Truck4);
        
       /*Vehicles linkedlist = new Vehicles();
       linkedlist.append(car1);
       linkedlist.append(car2);
       linkedlist.append(car3);
       linkedlist.append(car4);
       linkedlist.append(suv1);
       linkedlist.append(suv2);
       linkedlist.append(suv3);
       linkedlist.append(Truck1);
       linkedlist.append(Truck2);
       linkedlist.append(Truck3);
       linkedlist.append(Truck4);*/
        
        
        do
        {
            System.out.println();
            System.out.println("1 - Display all vehicles");
            System.out.println("2 - Display available vehicles ");
            System.out.println("3 - Reserve a vehicle");
            System.out.println("4 - Display a reservation ");
            System.out.println("5 - Cancel a reservation ");
            System.out.println("6 - Add a vehicle");
            System.out.println("7 - Remove a vehicle ");
            System.out.println("8 - Quit");

            MenuChoice = cin.nextInt();

            switch(MenuChoice)
            {
                case 1:
                     //Print vehicles
                    v.reset();
                    while(v.hasNext())
                    {

                        System.out.println(v.getNext());
                        v.Traverse();

                    }
                    v.reset();

                    //linkedlist.print();
                    break;
                    //display all
                case 2:
                    Vehicle currentV;

                    v.reset();
                    while(v.hasNext() == true)
                    {
                       currentV =  v.getNext();
                       if (currentV.isReserved() == false)
                       {
                           System.out.println(currentV);

                       }
                       v.Traverse();
                    }
                    break;
                    //reserve a vehicle
                case 3:
                    int card;
                    String rp;
                    boolean insurance;
                    String VIN;

                    Vehicle reserveV;

                    System.out.print("Enter credit card#: ");
                    card = cin.nextInt();

                    System.out.print("Enter Rental period('D4' (four days), 'W2' (two weeks), 'M1' (one month)): ");
                    rp = cin.next();

                    System.out.print("Would you like daily insurance? (Enter 'true' for YES or 'false' for NO): ");
                    insurance = cin.nextBoolean();

                    

                    System.out.print("Enter VIN# of vehicle you would like to reserve: ");
                    VIN = cin.next();
                    reserveV = v.getVehicle(VIN);
                    Reservation resv = new Reservation(card, rp, reserveV.getDescript() ,insurance);
                    reserveV.reserve(resv);



                    System.out.println("Vehivle: " + reserveV + " has been resereved");
                    break;

                    //Display a reservation
                case 4:
                    Vehicle display;
                    //String VINnum;

                    System.out.print("Enter VIN# of reserved car: ");
                    VIN = cin.next();

                    display = v.getVehicle(VIN);

                    if (display.isReserved() == true)
                    {
                        System.out.println("Reservation: " + display.getReservation());
                    }
                    else 
                    {
                        System.out.println("Vehicle was not reserved");
                    }

                    break;


                case 5:
                    Vehicle cancel;


                    System.out.print("Enter VIN# of reserved car: ");
                    VIN = cin.next();

                    cancel = v.getVehicle(VIN);

                    if (cancel.isReserved() == true)
                    {
                        System.out.println("Reservation: " + cancel.getReservation() + " is now cancelled");
                        cancel.cancelReservation();
                    }
                    else 
                    {
                        System.out.println("Vehicle was never reserved");
                    }

                    break;
                case 6: //add vehicle
                    String addVehicle;
                    String make;
                    int milage;
                    int seat;
                    String vin;

                    System.out.println("Which type of vehicle would you like to add?");
                    System.out.println("a. Car");
                    System.out.println("b. Truck");
                    System.out.println("c. SUV");
                    addVehicle = cin.next();
                    addVehicle = addVehicle.toUpperCase();

                    while(!addVehicle.equals("A") && !addVehicle.equals("B") && !addVehicle.equals("C"))
                    {
                        System.out.println("Invalid input");
                        addVehicle = cin.next();
                        addVehicle = addVehicle.toUpperCase();
                    }
                    //car
                    if(addVehicle.equals("A"))
                    {
                        System.out.print("Enter Make and Model: ");
                        make = cin.next();

                        System.out.print("Enter MPG: ");
                        milage = cin.nextInt();

                        System.out.print("Enter # of Seats: ");
                        seat = cin.nextInt();

                        System.out.print("Enter VIN: ");
                        vin = cin.next();

                        Car car5 = new Car(make, milage, vin, null, seat, null);

                        v.add(car5);
                        System.out.print(car5);
                    }
                    //suv
                    else if(addVehicle.equals("B"))
                    {
                        int cargoCap;
                        System.out.print("Enter Make and Model: ");
                        make = cin.next();

                        System.out.print("Enter MPG: ");
                        milage = cin.nextInt();

                        System.out.print("Enter # of Seats: ");
                        seat = cin.nextInt();

                         System.out.print("Enter Cargo Capacity: ");
                        cargoCap = cin.nextInt();

                        System.out.print("Enter VIN: ");
                        vin = cin.next();

                        SUV suv4 = new SUV(make, milage, vin, null, seat, cargoCap, null);

                        v.add(suv4);
                        System.out.print(suv4);
                    }

                    //Truck
                    else if(addVehicle.equals("C"))
                    {
                        int cargoCap;
                        System.out.print("Enter Make and Model: ");
                        make = cin.next();

                        System.out.print("Enter MPG: ");
                        milage = cin.nextInt();

                         System.out.print("Enter Load Capacity: ");
                        cargoCap = cin.nextInt();

                        System.out.print("Enter VIN: ");
                        vin = cin.next();

                        Truck Truck5 = new Truck(make, milage, vin, null, cargoCap, null);

                        v.add(Truck5);

                        System.out.print(Truck5);
                    }

                    break;

                    //Delete
                case 7:
    //                  

                        String removeVIN;
                        System.out.print("Enter vehicle VIN to remove: ");
                        removeVIN = cin.next();
                        
                        v.remove(removeVIN);



                    break;
                case 8:
                    System.out.println("GoodBye.");
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        } while(MenuChoice >= 0 && MenuChoice < 8);
        
        
        
        
       
       
       
        
        
        
    }
}
