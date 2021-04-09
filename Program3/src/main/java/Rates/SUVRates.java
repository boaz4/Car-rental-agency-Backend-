/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rates;



/**
 *
 */
public class SUVRates extends VehicleRates
{
     public SUVRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
			         double daily_insur_rate)
    {
        super(daily_rate, weekly_rate, monthly_rate, mileage_chrg, daily_insur_rate);
    }
     
      public String toString()
    {
        return  "Daily: $" + super.getDailyRate() + "     Weekly: $" + super.getWeeklyRate() + "    Monthly: $" + super.getMonthlyRate() + "    Per Mile: $" + super.getMileageChrg() + "    Daily Insur: $" + super.getDailyInsurRate();
    }
}
