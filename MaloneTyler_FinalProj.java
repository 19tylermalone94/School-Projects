import java.util.Scanner;
import java.util.InputMismatchException;

public class MaloneTyler_FinalProj {
	
	//-----------intitialize MAX_CUSTOMERS--------------//
	static int MAX_CUSTOMERS = 100;
	
	//--------------initialize arrays to store customer data------------//
	static String[] customerNames = new String[MAX_CUSTOMERS];
	static int[] customerIDs = new int[MAX_CUSTOMERS];
	static double[] customerSales = new double[MAX_CUSTOMERS];
	
	//--------method to add single customer-----------//
	static void new_customer() {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter customer name: ");
				String customerName = scan.nextLine();
				System.out.println("Enter customer ID (5-digits): ");
				int customerID = scan.nextInt();
				scan.nextLine();
				if (customerID < 10000 || customerID > 99999) {
					System.out.println("Invalid ID. Must be 5 digits.");
					continue;
				}
				System.out.println("Enter customer sales: ");
				double customerSale = scan.nextDouble();
				scan.nextLine();
				
				for (int i = 0; i < MAX_CUSTOMERS; i++) {
					if (customerNames[i] == null) {
						customerNames[i] = customerName;
						customerIDs[i] = customerID;
						customerSales[i] = customerSale;
						break;
					}
				}
				break;
				
			} catch (InputMismatchException e) {
				System.out.println("Please us numerical values.");
				System.out.println();
			}
		}
	}
	
	//---------------------method to add multiple customers--------------------//
	static void multiple_customers(int numCustomers) {
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				int customerCount = 1;
				while (numCustomers != 0) {
					System.out.println("Enter customer " + customerCount + " name: ");
					String customerName = scan.nextLine();
					System.out.println("Enter customer ID (5-digits): ");
					int customerID = scan.nextInt();
					scan.nextLine();
					if (customerID < 10000 || customerID > 99999) {
						System.out.println("Invalid ID. Must be 5 digits.");
						continue;
					}
					System.out.println("Enter customer sales: ");
					double customerSale = scan.nextDouble();
					scan.nextLine();
					for (int i = 0; i < MAX_CUSTOMERS; i++) {
						if (customerNames[i] == null) {
							customerNames[i] = customerName;
							customerIDs[i] = customerID;
							customerSales[i] = customerSale;
							break;
						}
					}
					customerCount++;
					numCustomers--;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please use numerical values.");
				System.out.println();
			}
		}
	}
	
	//------------------method to display specific customer----------------------//
	static void display_customer(int ID) {
		for (int i = 0; i < MAX_CUSTOMERS; i++) {
			if (customerIDs[i] == ID) {
				System.out.println("Customer Name == " + customerNames[i]);
				System.out.println("Customer sales == " + customerSales[i]);
				System.out.println();
				break;
			} else if (customerIDs[i] == 0) {
				System.out.println("Customer does not exist");
				break;
			}
		}
	}
	
	//---------------------method that displays all customers------------------------//
	static void display_all_customers() {
		if (customerNames[0] == null) {
			System.out.println("No customers to display.");
		} else {
			for (int i = 0; i < MAX_CUSTOMERS; i++) {
				if (customerNames[i] != null) {
					System.out.println("Customer name == " + customerNames[i]);
					System.out.println("Customer ID == " + customerIDs[i]);
					System.out.println("Customer sales == " + customerSales[i]);
					System.out.println();
				} else {
					break;
				}
			}
		}
	}
	
	//-------------------method to display customers in specific sales range---------------//
	static void display_customers_in_range(double min, double max) {
		for (int i = 0; i < MAX_CUSTOMERS; i++) {
			if (customerNames[i] != null) {
				if (customerSales[i] >= min && customerSales[i] <= max) {
					System.out.println("Customer name == " + customerNames[i]);
					System.out.println("Customer ID == " + customerIDs[i]);
					System.out.println("Customer sales == " + customerSales[i]);
					System.out.println();
				}
			} else {
				break;
			}
		}
	}
	
	//--------------method which prints main menu-------------------//
	static void menu() {
		System.out.println("MAIN MENU");
		System.out.println("\t1 == ENTER A NEW CUSTOMER");
		System.out.println("\t2 == ENTER MULTIPLE CUSTOMERS");
		System.out.println("\t3 == DISPLAY SPECIFIC CUSTOMER");
		System.out.println("\t4 == DISPLAY ALL CUSTOMERS");
		System.out.println("\t5 == DISPLAY CUSTOMERS BASED ON RANGE OF SALES");
		System.out.println("\t6 == EXIT");

	}
	public static void main(String[] args) {
		while (true) {
			try {
				menu();
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if (choice == 1) {
					new_customer();
				} else if (choice == 2) {
					System.out.println("How many customers would you like to add?: ");
					int numCustomers = scan.nextInt();
					scan.nextLine();
					multiple_customers(numCustomers);
				} else if (choice == 3) {
					System.out.println("Enter customer ID");
					int customerID = scan.nextInt();
					scan.nextLine();
					display_customer(customerID);
				} else if (choice == 4) {
					display_all_customers();
				} else if (choice == 5) {
					System.out.println("Enter minimum sales: ");
					double minSales = scan.nextInt();
					System.out.println("Enter maximum sale: ");
					double maxSales = scan.nextInt();
					display_customers_in_range(minSales, maxSales);
				} else if (choice == 6) {
					break;
				} else {
					System.out.println("Invalid menu option");
					System.out.println();
				}
			} catch (InputMismatchException e) {
				System.out.println("Please use numerical values");
				System.out.println();
			}
		}
		
		System.out.println("Thank you for using this program.");
		System.out.println("Goodbye");
	}

}
