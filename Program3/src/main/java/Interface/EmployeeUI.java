/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import com.mycompany.Program5.*;
import java.util.*;

public class EmployeeUI implements UserInterface  
{
	
	// no constructor needed, calls static methods of the SystemInterface
	// starts a “command loop” that repeatedly: (a) displays a menu of options, (b) gets the selected
      // option from the user, and (c) executes the corresponding command.

 	public void start()
        {
            int selection; 
            Scanner input = new Scanner(System.in);
            boolean quit = false;

            //command loop
            while(!quit)
            {
            try {
                displayMenu();
                selection = getSelection(input);
                if (selection == 8)
                {
                    quit = true;
                }
                execute(selection, input, quit);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
               }
            catch (AccountNumberNotFoundException e)
            {
                System.out.println("ACCOUNT NUMBER NOT FOUND");
            }
            catch (InvalidAcctNumException e)
            {
                System.out.println("ERROR : INVALID ACCOUNTT NUMBER");
            }
            catch (ReservedVehicleException e)
            {
                System.out.println("ERROR: VEHICLE HAS BEEN RESERVED");
            }
            catch (UnreservedVehicleException e)
            {
                System.out.println("ERROR: VEHICLE IS NOT RESERVED");
            }
            catch (VINNotFoundException e)
            {
                System.out.println("ERROR: VIN IS NOT FOUND");
            }
            }
    }
 
	
    private void execute(int selection, Scanner input, boolean quit) throws UnreservedVehicleException, VINNotFoundException, AccountNumberNotFoundException, InvalidAcctNumException, ReservedVehicleException
    {

        int veh_type;
	String vin, acct_num;
        String[] display_lines = null;
	RentalDetails rental_details;
        ReservationDetails reserv_details;

	switch(selection) 
        {

		// display rental rates
		case 1: veh_type = getVehicleType(input);
				switch(veh_type)
                                {
				    case 1: 
                                        display_lines = SystemInterface.getCarRates();
                                     break;
				    case 2:
                                        display_lines = SystemInterface.getSUVRates();
                                    break;
			      	    case 3:
                                        display_lines = SystemInterface.getTruckRates(); 
                                    break;
				}
				displayResults(display_lines);
				break;

		// display available vehicles
		case 2:	veh_type = getVehicleType(input);
				switch(veh_type)
                                {
				    case 1: display_lines = SystemInterface.getAvailCars(); break;
				    case 2: display_lines = SystemInterface.getAvailSUVs(); break;
			      	    case 3: display_lines = SystemInterface.getAvailTrucks(); break;
				}
				displayResults(display_lines);
				break;

		// display estimated rental cost
		case 3:	
                    rental_details = getRentalDetails(input);
                    display_lines = SystemInterface.estimatedRentalCost(rental_details);
                    displayResults(display_lines);
                    break;
  		// make a reservation
		case 4:	reserv_details = getReservationDetails(input);
				display_lines = SystemInterface.makeReservation(reserv_details);
				displayResults(display_lines);
				break;
		
		// cancel a reservation
		case 5:	vin = getVIN(input);
				display_lines = SystemInterface.cancelReservation(vin);
				displayResults(display_lines);
				break;

		// view corporate account (and company reservations)
		case 6:	acct_num = getAcctNumber(input);
				display_lines = SystemInterface.getAccount(acct_num);
				displayResults(display_lines);
				break;

		// process returned vehicle
		case 7:	
                    boolean insur;
                    int num_day_used;
                    int num_miles_driven;
                    boolean prime;
                    
                    vin = getVIN(input);
                    System.out.print("Enter number of days used: ");
                    num_day_used = input.nextInt();
                    System.out.print("Enter number of miles driven: ");
                    num_miles_driven = input.nextInt();
                    
                    insur = getinsur(input);                                
                    prime = getPrimeCustomer(input);
                    
                    display_lines = SystemInterface.processReturnedVehicle(vin,num_day_used,num_miles_driven, insur, prime);
                    displayResults(display_lines);
		break;

		// quit program
		case 8: 
                    quit = true;
                    System.out.println("Goodbye");
                break;
        }
    }
    
    
    private void displayMenu()    
        {
            System.out.println("1 – View Current Rates	...	displays rental (and insurance rates) for one of cars, SUVs, or trucks");
            System.out.println("2 – View Available Vehicles	... 	displays available vehicles (cars, SUVs, or trucks)");
            System.out.println("3 – Calc Estimated Rental Cost	... 	displays estimated rental cost for given vehicle type, rental period, expected miles driven,optional daily insurance, and if Prime Customer"); 
            System.out.println("4 – Make a Reservation	...	creates a reservation for VIN, account number,rental period, and insur option");
            System.out.println("5 - Cancel Reservation	...  cancels a reservation by VIN");
            System.out.println("6 – View Corporate Account	... 	displays account information for a given accountnumber, including all current reservations");
            System.out.println("7 – Process Returned Vehicle	...  requests VIN and actual number of miles drivenand processes returned vehicle and displays total charge");
            System.out.println("8 - Quit");
        }
 	// displays the menu of options

	private int getSelection(Scanner input) 
        {
            int selc;
            selc = input.nextInt();
            while(selc > 8 || selc < 1)
            {
                System.out.println("ERROR: INVALID INPUT");
                selc = input.nextInt();
            }
            
            return selc;
        }
        
 	// prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)

	private String getAcctNumber(Scanner input)
        {
            String acct_num;
            System.out.print("Enter in 5 digit account number: ");
            acct_num = input.next();
            while(acct_num.length() > 5 && !(acct_num.matches(".*\\d.*"))) // check if it is 5 digits and contains integers 
            {
                System.out.print("Error invalid input");
               acct_num = input.next(); 
            }
            return acct_num;
        }
	// generates and returns 5 digit account number (continues to prompt user if invalid input given) {    }

	private String getVIN(Scanner input)
        {
            String vin;
            System.out.print("Enter in VIN number: ");
            vin = input.next();
            return vin;
        }
	// prompts user to enter VIN for a given vehicle (does not do any error checking on the input) {    }

	private int getVehicleType(Scanner input)
        {
            System.out.println("Enter in Vehicle type. 1- Car |2- SUV| 3-Truck"); 
            int selc;
            selc = input.nextInt();
            while(selc > 3 || selc < 1)
            {
                System.out.println("ERROR: INVALID INPUT");
                selc = input.nextInt();
            }
            
            return selc;
        }
	// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given) {    }

	private RentalDetails getRentalDetails(Scanner input)
        {
            int type;
            String rp;
            int miles;
            boolean insur;
            boolean primeCust;
            
            type = getVehicleType(input);
            rp = getRp(input);
            insur = getinsur(input);
            primeCust = getPrimeCustomer(input);
            
            System.out.print("Enter number of estimated # of miles: ");
            miles = input.nextInt();
            
            
            
            RentalDetails r = new RentalDetails(type, rp, miles, insur, primeCust);
            return r;
        }
	// prompts user to enter required information for an estimated rental cost (vehicle type, estimated  
 	// number of miles expected to be driven, rental period (number of days, weeks or months), and
 	// insurance option, returning the result packaged as a RentalDetails object (to be passed in method
 	// calls to the SystemInterface) {    }

	private ReservationDetails getReservationDetails(Scanner input)
        {
            String vin;
            String acct_num;
            String rp;
            boolean insur;
            int vtype;
            
            vin = getVIN(input);
            
            acct_num = getAcctNumber(input);
            rp = getRp(input);
            insur = getinsur(input);
            vtype = getVehicleType(input);
            
            
            ReservationDetails r = new ReservationDetails(vin, Integer.parseInt(acct_num), rp, insur, vtype);
            return r;
        }
	// prompts user to enter required information for making a reservation (VIN of vehicle to reserve, 
 	// acct number, rental period, and insurance option), returning the result packaged as a 
 	// ReservationDetails object (to be passed in method calls to the SystemInterface)  {    }
        
        
        private boolean getPrimeCustomer(Scanner input)
        {
            //get prime customer 
            boolean primeCust;
            int prime;
            
            System.out.print("Enter 1 if customer is prime customer, 0 if not: ");
            prime = input.nextInt();
            
            while(prime != 0 && prime != 1)
            {
                System.out.print("Invalid value entered. Enter 1 if customer is prime customer, 0 if not: ");
                prime = input.nextInt();
            }
            if (prime == 1)
            {
                primeCust = true;
            }
            else
            {
                primeCust = false;
            }
            return primeCust;
        }
        
        private boolean getinsur(Scanner input)
        {
            //get insurance
            int choice;
            boolean insur;
            
            System.out.print("Would you like insurance? (1 for yes & 0 for no): ");
            choice = input.nextInt();
            while(choice != 0 && choice != 1)
            {
                System.out.println("Invalid value entered. Enter 1 if customer is prime customer, 0 if not: ");
                choice = input.nextInt();
            }
            if (choice == 1)
            {
                insur = true;
            }
            else
            {
                insur = false;
            }
            
            return insur;
        }
        
        public String getRp(Scanner input)
        {
            String rp;
            char Letter1;
            char Letter2;
            int Value;
            
            System.out.println("Enter the rental period in terms of days, weeks or months (e.g. D4 = 4 days or W1 = 1 week):");
            rp = input.next();
        
            //Decipher string
            Letter1 = rp.charAt(0); 
            Letter1 = Character.toUpperCase(Letter1);
            Letter2 = rp.charAt(1); 
            Value = Character.getNumericValue(Letter2); 

            while (Letter1 != 'W' && Letter1 != 'D' && Letter1 != 'M' && Value <= 0 && Character.isDigit(Letter2) == false)
            {
                System.out.print("Invalid value entered. Please enter rental period in the correct form (e.g. D4 = 4 days or W1 = 1 week): ");
                rp = input.next();
                
                Letter1 = rp.charAt(0); 
                Letter1 = Character.toUpperCase(Letter1);
                Letter2 = rp.charAt(1); 
                Value = Character.getNumericValue(Letter2);
            }
            
            rp = String.valueOf(Letter1) + String.valueOf(Letter2);
            
            return rp;
        }

	private void displayResults(String[] lines)
        {
          for (String string: lines)
            {
                System.out.println(string);
            }
        }
	// displays the array of strings passed, one string per screen line {    }
}
