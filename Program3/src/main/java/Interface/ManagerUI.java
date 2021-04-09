/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 */
import com.mycompany.Program5.*;

import java.util.*;
import Rates.*;
public class ManagerUI implements UserInterface 
{
	
	// no constructor needed, calls static methods of the SystemInterface
	// starts a “command loop” that repeatedly: (a) displays a menu of options, (b) gets the selected
      // option from the user, and (c) executes the corresponding command.

 	public void start() {

	int selection;
Scanner input = new Scanner(System.in);
	boolean quit = false;

	// command loop
	while(quit == false) 
        {
		displayMenu();
		selection = getSelection(input);
                 if (selection == 7)
                {
                    quit = true;
                }
		execute(selection, input, quit);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
      }
	
    private void execute(int selection, Scanner input, boolean quit) 
    {

        int veh_type;
	String vin, acct_num;  String[] display_lines; String[] error = {"ERROR: INVALID INPUT"};
	RentalDetails rental_details;
        ReservationDetails reserv_details;

	switch(selection) 
        {
            //Update rates
		case 1: 
                    veh_type = getVehicleType(input);
                    VehicleRates vr;
                    String[] nun = {" "};
				switch(veh_type)
                                {
				    case 1: 
                                        display_lines = SystemInterface.getCarRates(); 
                                        displayResults(display_lines);
                                        vr = UpdateRates(input, veh_type);
                                        if(vr != null)
                                        {
                                         display_lines =  SystemInterface.updateCarRates(vr);
                                        }
                                        else
                                        {
                                            display_lines = nun;
                                        }
                                        break;
				    case 2: 
                                        display_lines = SystemInterface.getSUVRates();
                                        displayResults(display_lines);
                                        vr = UpdateRates(input, veh_type);
                                        if(vr != null)
                                        {
                                         display_lines =  SystemInterface.updateSUVRates(vr);
                                        }
                                        else
                                        {
                                            display_lines = nun;
                                        }
                                        break;
			      	    case 3: 
                                        display_lines = SystemInterface.getTruckRates();
                                        displayResults(display_lines);
                                        vr = UpdateRates(input, veh_type);
                                        if(vr != null)
                                        {
                                         display_lines =  SystemInterface.updateTruckRates(vr);
                                        }
                                        else
                                        {
                                            display_lines = nun;
                                        }
                                        
                                    default:
                                        display_lines = error;

                                        break;
                                     
				}
                                displayResults(display_lines);
				break;

                                
		// display available vehicles
		case 2:
                    display_lines = SystemInterface.getAllVehicles();
                    displayResults(display_lines);
                    break;

		// Add account
		case 3:	
                    String acct_n;
                    String companyName;
                    String ans;
                    boolean choice;
                    
                    System.out.print("Enter name of Company: ");
                    companyName = input.next();
                    acct_n = generateAcctNumber();
                    
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
                    
                    
                    display_lines = SystemInterface.addAccount(acct_n, companyName, primeCust);
                    displayResults(display_lines);
                    break;
  		// view all reservations
		case 4:	
                    display_lines = SystemInterface.getAllReservations();
                    displayResults(display_lines);
                    break;
		
		// View all accounts
		case 5:	
			display_lines = SystemInterface.getAllAccounts();
			displayResults(display_lines);
			break;

		// view all transactions
		case 6:	
			display_lines = SystemInterface.getAllTransactions();
			displayResults(display_lines);
			break;

		// process returned vehicle
		case 7:	
                   quit = true;
                   System.out.println("Goodbye");
                   break;
	}
    }

	// ------- private methods

	private void displayMenu() 
        {
            System.out.println("1 – View/Update Rates	... 	allows updating of rental and insurance rates\n");
            System.out.println("2 – View All Vehicles	... 	displays all vehicles of the agency");
            System.out.println("3 – Add Account	... 	allows entry of a new customer account");
            System.out.println("4 – View All Reservations	...	displays all current reservations\n");
            System.out.println("5 – View All Accounts	...	displays all customer accounts");
            System.out.println("6 – View Transactions	... 	displays all transactions");
            System.out.println("7 - Quit");
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

	private String generateAcctNumber()
        {
            int n = 10000 + new Random().nextInt(90000);
            //10000 ≤ n ≤ 99999
            return "Account Number: " + n;
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
            int type = getVehicleType(input);
            System.out.println("Enter the estimated number of miles driven: ");
            int miles = input.nextInt();
            
            System.out.println("Enter the rental period in terms of days, weeks or months (e.g. D4 = 4 days):");
            String rp = input.next();
        
            //Decipher string
            char Letter1 = rp.charAt(0); 
            char Letter2 = rp.charAt(1); 
            int Value = Character.getNumericValue(Letter2); 

            while (Letter1 != 'W' || Letter1 != 'D'|| Letter1 != 'M'|| (Value <= 0))
            {
                System.out.print("Invalid value entered. Please enter rental period in the correct form (e.g. D4 = 4 days): ");
                rp = input.next();    
            }
        
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
        
        
            //get prime customer 
            boolean primeCust;
            System.out.println("Enter 1 if customer is prime customer, 0 if not: ");
            int prime = input.nextInt();
            while(prime != 0 && prime != 1)
            {
            System.out.println("Invalid value entered. Enter 1 if customer is prime customer, 0 if not: ");
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
            
            String rp;
            boolean daily_insur;
            System.out.println("Enter the VIN Number of Vehicle being rented: ");
            vin = input.nextLine();
            
            generateAcctNumber();
            
            System.out.println("Enter the rental period in terms of days, weeks or months (e.g. D4 = 4 days):");
            rp = input.next();
        
            //Decipher string
            char Letter1 = rp.charAt(0); 
            char Letter2 = rp.charAt(1); 
            int Value = Character.getNumericValue(Letter2); 

            while (Letter1 != 'W' || Letter1 != 'D'|| Letter1 != 'M'|| (Value <= 0))
            {
                System.out.print("Invalid value entered. Please enter rental period in the correct form (e.g. D4 = 4 days): ");
                rp = input.next();    
            }
            
            
            
            
            
            
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
            
            
            ReservationDetails r = new ReservationDetails(vin, Integer.parseInt(generateAcctNumber()), rp, insur, getSelection(input));
            return r;
        }
	// prompts user to enter required information for making a reservation (VIN of vehicle to reserve, 
 	// acct number, rental period, and insurance option), returning the result packaged as a 
 	// ReservationDetails object (to be passed in method calls to the SystemInterface)  {    }

	
	// prompts user to enter required information for making a reservation (VIN of vehicle to reserve, 
 	// acct number, rental period, and insurance option), returning the result packaged as a 
 	// ReservationDetails object (to be passed in method calls to the SystemInterface)  {    }
        
        private VehicleRates UpdateRates(Scanner input,int veh_type)
        {
            int choice;
            boolean update;
            double daily_rate;
            double weekly_rate;
            double monthly_rate;
            double mileage_charge;
            double daily_insur_rate;
            VehicleRates vr = null;
            
            System.out.println(" is the current rate.");
            System.out.print("Enter 1 if you want to update rate, 0 if not");
            choice = input.nextInt();
            
            while(choice != 0 && choice != 1)
            {
                System.out.print("Invalid value entered. Enter 1 if you want to update rate, 0 if not: ");
                choice = input.nextInt();
            }
           if (choice == 1)
            {
                update = true;
            }
            else
            {
                update = false;
            }
            
            if(update == true)
            {
                System.out.println("Enter the updated daily rate:");
                daily_rate = input.nextDouble();
                System.out.println("Enter the update weekly rate:");
                weekly_rate = input.nextDouble();
                System.out.println("Enter the updated monthly rate:");
                monthly_rate = input.nextDouble();
                System.out.println("Enter the updated mileage charge:");
                mileage_charge = input.nextDouble();
                System.out.println("Enter the updated daily insurance rate:");
                daily_insur_rate = input.nextDouble();
                if(veh_type == 1)
                {
                    vr = new CarRates(daily_rate, weekly_rate, monthly_rate, mileage_charge, daily_insur_rate);
                }
                else if(veh_type == 2)
                {
                    vr = new SUVRates(daily_rate, weekly_rate, monthly_rate, mileage_charge, daily_insur_rate);
                }
                else if(veh_type == 2)
                {
                    vr = new TruckRates(daily_rate, weekly_rate, monthly_rate, mileage_charge, daily_insur_rate);
                }
                
            }
            return vr;
            
            
        }
        

	private void displayResults(String[] lines)
        {
            for (String string: lines)
            {
                System.out.println(string);
            }
        }

    
}
