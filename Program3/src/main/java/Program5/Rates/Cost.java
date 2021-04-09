/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rates;

/**
 *
 */
public class Cost implements CostType
{
    double daily_rate;
    double weekly_rate;
    double monthly_rate;
    double mileage_chrg;
    double daily_insur_rate;
    public Cost(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg,
	                   double daily_insur_rate)
    {
        
        this.daily_rate = daily_rate;
        this.weekly_rate = weekly_rate;
        this.monthly_rate = monthly_rate;
        this.mileage_chrg = mileage_chrg;
        this.daily_insur_rate = daily_insur_rate;
    }

    public double getDailyRate()
    {
        return daily_rate;
    }		// cost per day	  	
    public double getWeeklyRate()       	// cost per week   
    {
        return weekly_rate;
    }
    public double getMonthlyRate()       	// cost per month
    {
        return monthly_rate;
    }
    public double getMileageChrg() 	// cost per mile, based on vehicle type 
    {
        return mileage_chrg;
    }
    public double getDailyInsurRate()   	// insurance cost (per day)
    {
       return daily_insur_rate;
    }
}
