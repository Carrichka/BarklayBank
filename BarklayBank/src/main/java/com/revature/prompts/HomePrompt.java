package com.revature.prompts;

import java.util.Scanner;

/**
 * Home landing page that provides access to the application's functions.
 * 
 * @author carri
 *
 */
public class HomePrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);

	/**
	 * Method to handle function requests
	 * 
	 */
	@Override
	public Prompt run() {
		String input;

		System.out.println("\n Welcome to BARKlay Bank! The best choice for all your cuteness points banking needs! \n");
		
		while (true) {
			
			System.out.println("Enter 1 to view open accounts.");
			System.out.println("Enter 2 to open a new account.");
			System.out.println("Enter 3 to withdraw cuteness points from an account.");
			System.out.println("Enter 4 to deposit cutenes points to an account.");
			System.out.println("Enter 5 to remove an account.");
			System.out.println("Enter 6 to go to the Compound Interest Calculator.");
			input = scan.nextLine();
			
			switch (input) {
			case "1":
				return new ViewAccounts();
			case "2":
				return new OpenAccounts();
			case "3":
				return new WithdrawAccount();
			case "4":
				return new DepositAccount();
			case "5":
				return new RemoveAccount();
			case "6":
				return new InterestPrompt();
			default:
				System.out.println("Did not understand that selection, try again");
				break;
			}//end switch
		}//end while
	}//end Prompt

}//end HomePrompt class
