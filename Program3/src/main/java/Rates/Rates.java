/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rates;


/**
 *
 */
public class Rates 
{
    private VehicleRates[ ]  rates = new VehicleRates[3];    // array of size 3 to store rates for three types of vehicles
    
    public Rates(CarRates CarRates, SUVRates SUVRates, TruckRates TruckRates)
    {
        rates[0] = CarRates;
        rates[1] = SUVRates;
        rates[2] = TruckRates;

    }
    	public VehicleRates  getCarRates() 
        {
            return rates[0];
        }
 	public VehicleRates  getSUVRates() 
        {
            return rates[1];
        }
 	public VehicleRates  getTruckRates() 
        {
            return rates[2];
        }
        public void setCarRates(VehicleRates Car_Rates)
        {
            rates[0] =  Car_Rates;
        }
        
        public void setSUVRates(VehicleRates SUV_Rates)
        {
            rates[1] = SUV_Rates;
        }
        
        public void setTruckRates(VehicleRates Truck_Rates)
        {
            rates[2] = Truck_Rates;
        }
        
        	public double calcEstimatedCost(int vehicleType, String estimatedRentalPeriod, int estimatedNumMiles,
				                boolean dailyInsur, boolean primeCustomer)
        {
            char typeOflength;
            double MileageCharge;
            double total;
            total = 0;
            double daily_rate;
            double insur = 0.00;
            
            typeOflength = estimatedRentalPeriod.charAt(0);
            typeOflength = Character.toUpperCase(typeOflength);
            if(Character.isDigit(typeOflength) == false)
            {
                switch(typeOflength)
                {
                    case 'D':
                        switch(vehicleType)
                        {
                            case 1: // car
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.15 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.15 * (double) estimatedNumMiles;
                                }
                               
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                               
                                daily_rate = Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                daily_rate = 24.95 * (double) daily_rate;
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 2: //suv
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 29.95 * ((double)Character.getNumericValue(estimatedRentalPeriod.charAt(1)));
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 3: // Truck
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 34.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 22.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                
                                total = daily_rate + MileageCharge + insur;
                                break;
                             default:
                                System.out.println("Invalid input");
                                total = -999;
                                break;
                            }
                        break;
                    case 'W':
                        switch(vehicleType)
                        {
                            case 1: // car
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 149.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 2: //suv
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 189.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 3: // Truck
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 224.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 22.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                             default:
                                System.out.println("Invalid input");
                                total = -999;
                                break;
                        }
                        break;
                    case'M':
                        switch(vehicleType)
                        {
                            case 1: // car
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                
                                daily_rate = 514.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 2: //suv
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                daily_rate = 679.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 14.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            case 3: // Truck
                                if(primeCustomer == true)
                                {
                                    if(estimatedNumMiles <= 100)
                                    {
                                      MileageCharge = 0.0;  
                                    }
                                    else
                                    {
                                        estimatedNumMiles = estimatedNumMiles - 100;
                                        MileageCharge = 0.26 * (double) estimatedNumMiles;
                                    }
                                }
                                else
                                {
                                    MileageCharge = 0.26 * (double) estimatedNumMiles;
                                }
                                daily_rate = 797.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                if(dailyInsur == true)
                                {
                                    insur = 22.95 * (double)Character.getNumericValue(estimatedRentalPeriod.charAt(1));
                                }
                                else
                                {
                                    insur = 0.00;
                                }
                                total = daily_rate + MileageCharge + insur;
                                break;
                            default:
                                System.out.println("Invalid input");
                                total = -999;
                                break;
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                        total = -999;
                        break;
                }
            }
            return total;
        }
                
        public double calcActualCost(CostType rates, int numDaysUsed, int NumMilesDriven,
				          boolean dailyInsur, boolean primeCustomer)
        {
            double total = 0.00;
            
            if(primeCustomer == true)
            {
                if(NumMilesDriven > 100)
                {
                    total = rates.getMileageChrg() * (NumMilesDriven - 100);
                }
                
                if(numDaysUsed < 7) //daily charge
                {
                    total = total + (rates.getDailyRate() * numDaysUsed);
                }
                
                else if(numDaysUsed >= 7 && numDaysUsed <= 30)
                {
                    total = total + (rates.getWeeklyRate() * ((double) numDaysUsed / 7.0));
                }
                else
                {
                    total = total + (rates.getMonthlyRate() *((double) numDaysUsed / 30.0));
                }
            }
            else
            {
                total = total + (rates.getMileageChrg() * NumMilesDriven); // mileage charge
                
                if(numDaysUsed < 7) //daily charge
                {
                    
                    total = total + (rates.getDailyRate() * (double) numDaysUsed);
                    
                }
                
                else if(numDaysUsed >= 7 && numDaysUsed <= 30)
                {
                    total = total + (rates.getWeeklyRate() * ((double) numDaysUsed / 7.0));
                }
                else
                {
                    total = total + (rates.getMonthlyRate() * ((double) numDaysUsed / 30.0));
                }
            }
            
            if(dailyInsur == true)
                {
                    total = total + (rates.getDailyInsurRate()* numDaysUsed) ;
                }
            Math.round(total);
            return total;
        }


}
