/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 */
import Rates.*;
import com.mycompany.Program5.*;
import java.util.*;

public class FINALTestDriver 
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        int choice;
        UserInterface ui = null;
        
        //CONSTRUCTORS
        
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
        
        CarRates cRate = new CarRates(24.95, 149.95, 514.95, 0.15, 14.95); 
        SUVRates sRate = new SUVRates(29.95, 189.95, 679.95, 0.15, 14.95); 
        TruckRates tRate = new TruckRates(34.95, 224.95, 797.95, 0.26, 22.95);
        
        Rates r = new Rates((CarRates) cRate,(SUVRates) sRate,(TruckRates) tRate);
        
        Account a1 = new Account("00001", "Google", true);
        Account a2 = new Account("12345", "Yahoo", false);
        Account a3 = new Account("50005", "Gideons Catering", true);
        Account a4 = new Account("1", "Washington Post", true);
        Account a5 = new Account("1738", "Fortran", false);
        
        Accounts accounts = new Accounts();

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
        
        
        SystemInterface.initSystem(r, v, accounts, t);
        System.out.println("1- Employee");
        System.out.println("2- Manager");
        System.out.println("3- Quit");
        
        choice = cin.nextInt();
        switch(choice)
        {
            case 1:
                ui = new EmployeeUI();
                break;
            case 2:
                ui = new ManagerUI();
                break;
            case 3:
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("ERROR: Invalid input");
        }
        if(ui != null)
        {
            ui.start();
        }
    }
}
