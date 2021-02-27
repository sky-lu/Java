// -----------------------------------------------------
// Assignment (2)
// © Honglin Lu
// Written by: (Honglin Lu 1930758)
// -----------------------------------------------------

package testClasses;

import java.util.Scanner;

import baseClasses.Computer;

public class track {
	
	public static void displayMainMenu() {
		System.out.println("What do you want to do?");
		System.out.println("  1. Enter new computers (password required)");
		System.out.println("  2. Change information of a computer (password required)");
		System.out.println("  3. Display all computers by a specific brand");
		System.out.println("  4. Display all computers under a certain price");
		System.out.println("  5. Quit");
		System.out.print("Please enter your choice > ");
		
	}
	
	public static void displayUpdateMenu() {
		System.out.println("What information would you like to change?");
		System.out.println("  1. brand");
		System.out.println("  2. model");
		System.out.println("  3. SN");
		System.out.println("  4. price");
		System.out.println("  5. Quit");
		System.out.print("Enter your choice > ");
	}
	
	public static void findComputersBy(String brand, Computer[] inventory) {
		boolean flag = false;
		for(int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
			if(inventory[i].getBrand().toLowerCase().equals(brand.toLowerCase())) {
				flag = true;
				System.out.println(inventory[i]);
			}
		}
		if(flag == false) {
			System.out.println("There is no computer of this brand now!");
		}
	}
	
	public static void findCheaperThan(double p, Computer[] inventory) {
		boolean flag = false;
		for(int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
			if(inventory[i].getPrice() < p) {//this condition has some problem
				flag = true;
				System.out.println(inventory[i]);
			}
		}
		if(flag == false) {
			System.out.println("There is no computer cheaper than this price now!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String password = "password";
		
		//(step a )Display a welcome message
		System.out.println("Welcome to your computer store!");
		
		//(step b) prompt for the maxComputers
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the maximum number of computers your store can contain: ");
		int maxComputers = scanner.nextInt();
		Computer[] inventory = new Computer[maxComputers];
		
		// (step c) Display main menu
		int choice;
		do{
			displayMainMenu();
			choice = scanner.nextInt();
		}
		while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
		
		
		while(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
			// (step d) Conduct option 1:enter new computers
			if(choice == 1) {
				int i = 0;
				while(i<3) {
					System.out.print("Please enter the password: ");
					String pw = scanner.next();
					if(pw.equals(password)) {
						break;
					}else {
						i++;
					}
				}
				if(i == 3) {
					displayMainMenu();
					choice = scanner.nextInt();
					continue;
					
				}else {
					System.out.print("How many computers you want to enter: ");
					int num = scanner.nextInt();
					int numRemain = inventory.length - Computer.findNumberOfCreatedComputers();
					if(num > numRemain) {
						System.out.println("Now you can only add "+ numRemain + " computers");
						num = numRemain;
					}
					for(int j = 0 ; j < num; j++) {
						System.out.print("Enter computer's brand: ");
						String cBrand = scanner.next();
						System.out.print("Enter computer's model: ");
						String cModel = scanner.next();
						System.out.print("Enter computer's SN: ");
						long cSN = scanner.nextLong();
						System.out.print("Enter computer's price: ");
						double cPrice = scanner.nextDouble();
						inventory[Computer.findNumberOfCreatedComputers()] = new Computer(cBrand, cModel, cSN, cPrice);	
					}
					System.out.println("New computers have been added successfully !");
					displayMainMenu();
					choice = scanner.nextInt();
					continue;
				}
			}
			
			//(Step e) Conduct option 2: change information of a computer
			if(choice == 2) {
				int i = 0;
				while(i<3) {
					System.out.print("Please enter the password: ");
					String pw = scanner.next();
					if(pw.equals(password)) {
						break;
					}else {
						i++;
					}
				}
				if(i == 3) {
					displayMainMenu();
					choice = scanner.nextInt();
					continue;
				}else {
					int m = 0;
					do {
						System.out.print("Which computer you want to update, please enter the number smaller than " + maxComputers + ":");
						int n = scanner.nextInt();
						if(inventory[n] == null) {
							//This part hasn't finished.
							System.out.print("There is no specific computer at this location, do you want to try again? 1 for yes, 2 for no: ");
							m = scanner.nextInt();
							if(m == 2) {
								break;
							}
						}else {
							System.out.println("Computer # " + (n + 1));
							System.out.println("Brand: " + inventory[n].getBrand());
							System.out.println("Model: " + inventory[n].getModel());
							System.out.println("SN: " + inventory[n].getSN());
							System.out.println("Price: $" + inventory[n].getPrice());
							
							int updateChoice = 0;
							do {
								displayUpdateMenu();
								updateChoice = scanner.nextInt();
								
								while(updateChoice != 5 && updateChoice != 4 && updateChoice != 3 && updateChoice != 2 && updateChoice != 1) {
									displayUpdateMenu();
									updateChoice = scanner.nextInt();
								}
							
								switch (updateChoice) {
								case 1:
									System.out.print("Please enter the new brand: ");
									inventory[n].setBrand(scanner.next());
									break;
								case 2:
									System.out.print("Please enter the new model: ");
									inventory[n].setModel(scanner.next());
									break;
								case 3:
									System.out.print("Please enter the new SN: ");
									inventory[n].setSN(scanner.nextLong());
									break;
								case 4:
									System.out.print("Please enter the new price: ");
									inventory[n].setPrice(scanner.nextDouble());
									break;
								}
								System.out.println("==========================Updated computer===========================");
								System.out.println("Computer # " + (n + 1));
								System.out.println("Brand: " + inventory[n].getBrand());
								System.out.println("Model: " + inventory[n].getModel());
								System.out.println("SN: " + inventory[n].getSN());
								System.out.println("Price: $" + inventory[n].getPrice());
								System.out.println("================================================================");
							}
							while(updateChoice == 1 || updateChoice == 2 || updateChoice == 3 || updateChoice == 4);
							
						}
									
					}while(m == 1);	
					
					displayMainMenu();
					choice = scanner.nextInt();
					continue;
			}
			
			}
			
			
			//(Step f) Conduct option 3:display all computers by a specific brand
			if(choice == 3) {
				System.out.print("Enter a brand name: ");
				String cBrand = scanner.next();
				findComputersBy(cBrand, inventory);
				displayMainMenu();
				choice = scanner.nextInt();
				continue;
				
			}
			
			//(Step g) Conduct option 4: display all computers under a certain price
			if(choice == 4) {
				System.out.print("Enter a price: ");
				double price = scanner.nextDouble();
				findCheaperThan(price, inventory);
				displayMainMenu();
				choice = scanner.nextInt();
				continue;
			}
			
			// (Step h) quit the application
			if(choice == 5) {
				System.out.println("The application is closing...");
				System.exit(0);
				//System.out.println("Hello");
			}
		
		scanner.close();


	}
	}
	
}



