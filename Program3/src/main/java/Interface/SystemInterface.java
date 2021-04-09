/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.mycompany.Program5.*;
import Rates.*;
import java.text.*;
/**
 *
 */
public class SystemInterface 
{
    private static Rates agency_rates;
    private static Vehicles agency_vehicles;
    private static Accounts accounts;
    private static Transactions transactions_history;

	// used to init static variables (in place of a constructor)
    public static void initSystem(Rates r, Vehicles v,  Accounts a, Transactions t) 
    {
        agency_rates = r;
	agency_vehicles = v;
	accounts = a;
	transactions_history = t;
    }
	
    
// Note that methods makeReserv, cancelReservation, and addAccount return information
// that confirms the successful completion of the requested action.
	// vehicle rates-related methods
    public static String[] getCarRates() 
    {
        String[] CarRates = new String[1];
        CarRates[0] = agency_rates.getCarRates().toString(); 
        return CarRates;
    }
    public static String[] getSUVRates() 
    {
        String[] getSUVRates = new String[1];
        getSUVRates[0] = agency_rates.getSUVRates().toString();
        return getSUVRates;
    }
    public static String[] getTruckRates() 
    {
        String[] getTruckRates = new String[1];
        getTruckRates[0] = agency_rates.getTruckRates().toString();
        return getTruckRates;
    }
    
    public static String[] updateCarRates(VehicleRates r) 
    {
        String[] updateCarRates = new String[1];
        agency_rates.setCarRates(r);
        updateCarRates[0] = "Your Car Rate has been updated";
        return updateCarRates;
    }
    
    public static String[] updateSUVRates(VehicleRates r) 
    {
        String[] updateSUVRates = new String[1];
        agency_rates.setSUVRates((SUVRates) r);
        updateSUVRates[0] = "Your SUV Rate has been updated";
        return updateSUVRates;
    }
    public static String[] updateTruckRates(VehicleRates r) 
    {
        String[] updateTruckRates = new String[1];
        agency_rates.setTruckRates((TruckRates) r);
        updateTruckRates[0] = "Your Truck Rate has been updated";
        return updateTruckRates;
    }

    public static String[] estimatedRentalCost(RentalDetails details) 
    {
        int vt;
        int miles;
        String rp;
        boolean insur;
        boolean prime;
        Rates r = null;
        
        DecimalFormat df = new DecimalFormat("0.00");
        String[] estimatedRentalCost = new String[1];
        
        rp = details.getRental_period();
        vt = details.getVehicleType();
        miles = details.getest_NumMiles();
        insur = details.getinsur();
        prime = details.getprimeCust();
        double cost;
        cost = agency_rates.calcEstimatedCost(details.getVehicleType(), details.getRental_period(), details.getest_NumMiles(), details.getinsur(), details.getprimeCust());
        
       estimatedRentalCost[0] = "Cost: $" + df.format(cost);
       return estimatedRentalCost;
        
        
        
    }
    public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven, boolean insur,boolean prime) throws UnreservedVehicleException, VINNotFoundException
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String[] processReturnedVehicle = new String[1];
        agency_vehicles.reset();
        
        
        double totalCost = agency_rates.calcActualCost(agency_vehicles.getVehicle(vin).getCost(), num_days_used, num_miles_driven, insur, prime);
        processReturnedVehicle[0] = "Total amount due: $" + df.format(totalCost) + "\n" + "Reservation: " + agency_vehicles.getVehicle(vin).getReservation() + "|  has been removed "; 
        agency_vehicles.getVehicle(vin).cancelReservation();
        
       // transactions_history.add();
        
        return processReturnedVehicle;
    }

	// vehicle-related methods
    public static String[ ] getAvailCars() 
    {
        
	// count the number of available cars
        int num_cars = 0;
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) 
        {
            if(agency_vehicles.getNext() instanceof Car)
            {
                num_cars = num_cars + 1;
            }
	}

	// create appropriate size array
	String[ ]  avail_cars = new String[num_cars];
	// populate the array with available cars
	int i = 0;
	Vehicle v;
	agency_vehicles.reset();
        
	while(agency_vehicles.hasNext()) 
        {
            v = agency_vehicles.getNext();
		if(v instanceof Car && v.isReserved() == false)
                {
                    avail_cars[i]  = v.getDescript();
                    i++;
                    
                }
                
	}
	return avail_cars;

    }

        
        
    
    public static String[ ] getAvailSUVs() 
{
     
	// count the number of available cars
        int num_cars = 0;
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) 
        {
            if(agency_vehicles.getNext() instanceof SUV)
            {
                num_cars = num_cars + 1;
            }
	}

	// create appropriate size array
	String[ ]  getAvailSUVs = new String[num_cars];
	// populate the array with available cars
	int i = 0;
	Vehicle v;
	agency_vehicles.reset();
        
	while(agency_vehicles.hasNext()) 
        {
            v = agency_vehicles.getNext();
		if(v instanceof SUV && v.isReserved() == false)
                {
                    getAvailSUVs[i]  = v.getDescript();
                    i++;
                }
                
                
	}
	return getAvailSUVs;

}
    public static String[ ] getAvailTrucks() 
    {
        // count the number of available cars
        int num_cars = 0;
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) 
        {
            if(agency_vehicles.getNext() instanceof Truck)
            {
                num_cars = num_cars + 1;
            }
	}

	// create appropriate size array
	String[ ]  getAvailTrucks = new String[num_cars];
	// populate the array with available cars
	int i = 0;
	Vehicle v;
	agency_vehicles.reset();
        
	while(agency_vehicles.hasNext()) 
        {
            v = agency_vehicles.getNext();
		if(v instanceof Truck && v.isReserved() == false)
                {
                    getAvailTrucks[i]  = v.getDescript();
                    i++;
                }
                
                
	}
	return getAvailTrucks;
    }
    
    
    public static String[ ] getAllVehicles() 
    {   
	int total_size = 0;
        agency_vehicles.reset();
        
        while(agency_vehicles.hasNext())
        {
            agency_vehicles.getNext();
            total_size++;
        }
        
        
        String[] all_vehicles = new String[total_size];
        int i = 0; 
        agency_vehicles.reset();
        Vehicle v;
        while(agency_vehicles.hasNext())
        {
            v = agency_vehicles.getNext();
            all_vehicles[i] = v.toString();
            i++;
        }
        
        
        return all_vehicles;
    }

    public static String[ ] makeReservation(ReservationDetails details) throws UnreservedVehicleException, VINNotFoundException, ReservedVehicleException
    {
        String[] makeReservation = new String[1];
        Vehicle v;
        v = agency_vehicles.getVehicle(details.getVIN());
        switch (details.getvType())
        {
            case 1:
                v.setCost(agency_rates.getCarRates().cloneAsCostType());
                break;
            case 2:
                v.setCost(agency_rates.getSUVRates().cloneAsCostType());
                break;
            case 3:
                v.setCost(agency_rates.getTruckRates().cloneAsCostType());
                break;
        }
        
        v.reserve(new Reservation (details.getacct_num(), v.getDescript(), details.getrental_period(), details.getdaily_insurance_option()));
        makeReservation[0] = "Your reservation was created.";
        return makeReservation;
    }
    
    public static String[] cancelReservation(String vin) throws UnreservedVehicleException, VINNotFoundException
    {
        String[] cancelReservation = new String[1];
        if (agency_vehicles.getVehicle(vin).isReserved() == true)
        {
            agency_vehicles.getVehicle(vin).cancelReservation();           
            cancelReservation[0] = "Reservation has been cancelled.";
        }
        else 
        {
            cancelReservation[0] = "Reservation did not exist.";
            throw new UnreservedVehicleException(vin);
        }
        
        return cancelReservation;
    }
    
    public static String[] getReservation(String vin) throws VINNotFoundException
    {
        String[] getReservation = new String[1];
        if(agency_vehicles.getVehicle(vin).getReservation() == null)
        {
            throw new VINNotFoundException(vin);
        }
        else
        {
            getReservation[0] = "Reservation: " + agency_vehicles.getVehicle(vin).getReservation();
        }
        return getReservation;
    }
    
   public static String[] getAllReservations() 
   {
       // count the number of available Reservations
       
        int num_res = 0;
	agency_vehicles.reset();

	while(agency_vehicles.hasNext()) 
        {
            if(agency_vehicles.getNext().getReservation() instanceof Reservation)
            {
                num_res++;
            }
	}

	// create appropriate size array
	String[]  getAllReservations = new String[num_res];
	
	// populate the array with available cars
	int i = 0;
	Reservation r;
	agency_vehicles.reset();
	
	while(agency_vehicles.hasNext()) {
		r = agency_vehicles.getNext().getReservation();
		if(r instanceof Reservation)
                {
                    getAllReservations[i]  = r.toString();
                    i++;
                }
	}
        
	return getAllReservations;
   }

// customer accounts-related methods
    public static String[] addAccount(String acct_num, String company_name, boolean prime_cust) 
    {
        String[] addAccount = new String[1];
        Account a = new Account(acct_num, company_name, prime_cust);
        accounts.add(a);
        addAccount[0] = "Account: "+ a +"| has been added";
        return addAccount;
    }
    public static String[] getAccount(String acct_num) throws AccountNumberNotFoundException, InvalidAcctNumException
    {
        String[] getAccount = new String[1];
        if(accounts.getAccount(acct_num) == null)
        {
            throw new AccountNumberNotFoundException(acct_num);
        }
        else
        {
           getAccount[0] = "Account: "  + accounts.getAccount(acct_num);
        }
        return getAccount;
    }
    public static String[] getAllAccounts() 
    {
        int count = 0;
	accounts.reset();

	while(accounts.hasNext()) 
        {
            if(accounts.getNext() instanceof Account)
            {
                count++;
            }
	}

	// create appropriate size array
	String[]  getAllAccounts = new String[count];
	
	// populate the array with available cars
	int i = 0;
	Account a;
	accounts.reset();
	while(accounts.hasNext()) {
		a = accounts.getNext();
		if(a instanceof Account)
                {
                    getAllAccounts[i]  = a.toString();
                    i++;
                }
	}
        
	return getAllAccounts;
        
        
    }

// transactions-related methods
    public static String[ ] addTransaction(String acct_num, String company_name, String vehicle_type, String rental_period, String rental_cost) 
    {
        String[] addTransaction = new String[1];
        Transaction t =  new Transaction(acct_num, company_name, vehicle_type, rental_period, rental_cost);
        transactions_history.add(t);
        addTransaction[0] = "Transaction: " + t + " has been added.";
        return addTransaction;
     
    }

    
    public static String[ ] getAllTransactions() 
    {
        // count the number of available cars
       
        int count = 0;
	transactions_history.reset();

	while(transactions_history.hasNext()) 
        {
            if(transactions_history.getNext() instanceof Transaction)
            {
                count++;
            }
	}

	// create appropriate size array
	String[]  getAllTransactions = new String[count];
	
	// populate the array with available cars
	int i = 0;
	Transaction t;
	transactions_history.reset();
	while(transactions_history.hasNext()) {
		t = transactions_history.getNext();
		if(t instanceof Transaction)
                {
                    getAllTransactions[i]  = t.toString();
                    i++;
                }
	}
        
	return getAllTransactions;
    }

}
