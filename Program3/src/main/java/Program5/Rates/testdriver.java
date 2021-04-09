/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rates;

/**
 *
 */
import java.util.*;
public class testdriver 
{
    public static void main(String[] args)
    {
        int ans;
        String Erp;
        int ENumofMiles;
        boolean dailyInsur;
        boolean prime;
        double total;
        
        Scanner cin = new Scanner(System.in);
        
        CarRates cRate = new CarRates(24.95, 149.95, 514.95, 0.15, 14.95); 
        SUVRates sRate = new SUVRates(29.95, 189.95, 679.95, 0.15, 14.95); 
        TruckRates tRate = new TruckRates(34.95, 224.95, 797.95, 0.26, 22.95);
        VehicleRates[] vr = {cRate, sRate,tRate};
        Rates r = new Rates(cRate, sRate, tRate);
        
        Cost Carcost = new Cost(cRate.getDailyRate(),cRate.getWeeklyRate(), cRate.getMonthlyRate(), cRate.getMileageChrg(), cRate.getDailyInsurRate());
        Cost SUVcost = new Cost(sRate.getDailyRate(),sRate.getWeeklyRate(), sRate.getMonthlyRate(), sRate.getMileageChrg(), sRate.getDailyInsurRate());
        Cost Truckcost = new Cost(tRate.getDailyRate(),tRate.getWeeklyRate(), tRate.getMonthlyRate(), tRate.getMileageChrg(), tRate.getDailyInsurRate());
        
        System.out.println("1- Car");
        System.out.println("2- SUV");
        System.out.println("3- Truck");
        System.out.print("Enter type of vehicle you would like to reserve: ");
        ans = cin.nextInt();
        
        //Estimated
        switch(ans)
        {
            
            case 1:
                
                System.out.print("Enter estimated Rental period('D4' (four days), 'W2' (two weeks), 'M1' (one month)): ");
                Erp = cin.next();
                System.out.print("Enter in estimated number of miles you will drive: ");
                ENumofMiles = cin.nextInt();
                System.out.print("Would you like your vehicle to be insured daily? (Enter true or false): ");
                dailyInsur = cin.nextBoolean();
                System.out.print("Are you a prime customer?(Enter true or false): ");
                prime = cin.nextBoolean();
                
                total = r.calcEstimatedCost(ans,Erp,ENumofMiles, dailyInsur, prime);
                System.out.println("Total Estimated Cost: $" + total);
                
                break;
            case 2:
                System.out.print("Enter estimated Rental period('D4' (four days), 'W2' (two weeks), 'M1' (one month)): ");
                Erp = cin.next();
                System.out.print("Enter in estimated number of miles you will drive: ");
                ENumofMiles = cin.nextInt();
                System.out.print("Would you like your vehicle to be insured daily? (Enter true or false): ");
                dailyInsur = cin.nextBoolean();
                System.out.print("Are you a prime customer?(Enter true or false): ");
                prime = cin.nextBoolean();
                
                total = r.calcEstimatedCost(ans,Erp,ENumofMiles, dailyInsur, prime);
                System.out.println("Total Estimated Cost: $" + total);
                
                break;
            case 3:
                System.out.print("Enter estimated Rental period('D4' (four days), 'W2' (two weeks), 'M1' (one month)): ");
                Erp = cin.next();
                System.out.print("Enter in estimated number of miles you will drive: ");
                ENumofMiles = cin.nextInt();
                System.out.print("Would you like your vehicle to be insured daily? (Enter true or false): ");
                dailyInsur = cin.nextBoolean();
                System.out.print("Are you a prime customer?(Enter true or false): ");
                prime = cin.nextBoolean();
                
                total = r.calcEstimatedCost(ans,Erp,ENumofMiles, dailyInsur, prime);
                System.out.println("Total Estimated Cost: $" + total);
                break;
            default:
                System.out.print("ERROR: INVALID INPUT");
                break;
        }
        
        
        //Calculate actual
        System.out.println(r.calcActualCost(Carcost, 6, 32, true, false));
        System.out.println(r.calcActualCost(SUVcost, 6, 132, false, false));
        System.out.println(r.calcActualCost(Truckcost, 6, 32, false, true));
        
        
    }
}
