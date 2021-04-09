/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.mycompany.Program5.*;
import Rates.*;
import java.util.*;
/**
 *
 */

public class Stage2_testdriver 
{
    public static void main(String[] args) throws UnreservedVehicleException, VINNotFoundException, ReservedVehicleException, AccountNumberNotFoundException, InvalidAcctNumException
    {
        //add vehicles
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
        
        //add rates
        CarRates cRate = new CarRates(24.95, 149.95, 514.95, 0.15, 14.95); 
        SUVRates sRate = new SUVRates(29.95, 189.95, 679.95, 0.15, 14.95); 
        TruckRates tRate = new TruckRates(34.95, 224.95, 797.95, 0.26, 22.95);
        VehicleRates[] vr = {cRate, sRate,tRate};
        Rates r = new Rates((CarRates) cRate,(SUVRates) sRate,(TruckRates) tRate);
        
        //add acounts
        Accounts accounts = new Accounts();
        
        Account a1 = new Account("00001", "Google", true);
        Account a2 = new Account("12345", "Yahoo", false);
        Account a3 = new Account("50005", "Gideons Catering", true);
        Account a4 = new Account("1", "Washington Post", true);
        Account a5 = new Account("1738", "Fortran", false);
        
        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);
        accounts.add(a4);
        accounts.add(a5);
        
        //add transactions
        Transaction t1 = new Transaction("00001", "Google", "Truck", "3d", "$100.00");
        Transaction t2 = new Transaction("12345", "Yahoo", "Car", "1m", "$600.00");
        Transaction t3 = new Transaction("50005", "Gideons Catering", "SUV", "1w", "$350.00");
        Transaction t4 = new Transaction("1", "Washington Post", "Car", "2M", "$600.00");
        Transaction t5 = new Transaction("1738", "Fortran", "SUV", "3M", "$1,000.00");
        
        Transactions t = new Transactions();
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);
        t.add(t5);
        
        
        //Constructor
        SystemInterface.initSystem(r,v,accounts,t);
        
        //Get carRates
        //String[] a;
        Arrays.toString(SystemInterface.getCarRates());
        
        print(SystemInterface.getCarRates());
        print(SystemInterface.getSUVRates());
        print(SystemInterface.getTruckRates());
        
        System.out.println();
        
        VehicleRates updatecRate = new CarRates(25.00, 150.00, 520.00, 0.3, 20.00);
        VehicleRates updateSUVRate = new SUVRates(30.00, 200.00, 700.00, 0.3, 20.00); 
        VehicleRates updateTruckRate = new TruckRates(34.95, 224.95, 797.95, 0.26, 22.95);
        print(SystemInterface.updateCarRates(updatecRate));
        print(SystemInterface.updateSUVRates(updateSUVRate));
        print(SystemInterface.updateTruckRates(updateTruckRate));
        
                System.out.println();

        
        RentalDetails d = new RentalDetails(1, "D4", 153, true, true);
        print(SystemInterface.estimatedRentalCost(d));
        
                System.out.println();

        
        print(SystemInterface.getAvailCars());
                System.out.println();

        
        print(SystemInterface.getAvailSUVs());
                System.out.println();

        print(SystemInterface.getAvailTrucks());
                System.out.println();

        print(SystemInterface.getAllVehicles());
        System.out.println();

        
        ReservationDetails r1 = new ReservationDetails("AB4FG5689GM",00001, "d3", true, 1);
        ReservationDetails r2 = new ReservationDetails("QK3FL4273ME",12345, "w9", false, 2);
        ReservationDetails r3 = new ReservationDetails("KG4DM5472RK",50005, "m1", true, 3);
        ReservationDetails r4 = new ReservationDetails("RK3BM4256YH",31, "d4", false, 1);

        print(SystemInterface.makeReservation(r1));
        print(SystemInterface.makeReservation(r2));
        print(SystemInterface.makeReservation(r3));
        print(SystemInterface.makeReservation(r4));
        
        System.out.println();
        
        
        print(SystemInterface.getAllTransactions());
        System.out.println();
        
        print(SystemInterface.getAllReservations());
        System.out.println();
        
        
        
        print(SystemInterface.cancelReservation("QK3FL4273ME"));
        print(SystemInterface.getAccount(("50005")));
        
        print(SystemInterface.addTransaction("42123", "Josh's dog treats", "Truck", "m1", "806.95"));
        System.out.println();
        
        print(SystemInterface.getAllAccounts());
        System.out.println();
        
        //process
        print(SystemInterface.processReturnedVehicle("AB4FG5689GM", 4, 100, true, true));
        
        
        
        

        
        
        
    }
    
    public static void print(String[] s)
    {
        for (String string: s)
        {
            System.out.println(string);
        }
        
    }
}
