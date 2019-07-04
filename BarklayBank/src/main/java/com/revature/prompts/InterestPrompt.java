package com.revature.prompts;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Prompt calculates compound interest for a given principal amount and time frame.
 * 
 * @author carri
 *
 */
public class InterestPrompt implements Prompt{
	
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Method to calculate compound interest
	 */
	@Override
	public Prompt run() {
		
		while (true) {
			
			System.out.println(" \n Welcome to the Compound Interest Calculator. \n");
			
			double principalAmount = 0;
			double rate = 0;
			double time = 0;
			double compoundInterest;
			
			
			try {

				System.out.println("Please enter the principal amount.");

				principalAmount = Double.valueOf(scan.nextLine());
				
				if(principalAmount < 0) {
					System.out.println("Negative amounts cannot be used in this calculation. Please try again.");
					principalAmount = Double.valueOf(scan.nextLine());
				}
				
				System.out.println("Please enter the interest rate.");

				rate = Double.valueOf(scan.nextLine());
				
				System.out.println("Please enter the time.");

				time = Double.valueOf(scan.nextLine());
				
				compoundInterest = (principalAmount * Math.pow((1 + rate/100),time));
				
				DecimalFormat df = new DecimalFormat("0.00");
				System.out.println("With compound interest the new amount is now " + df.format(compoundInterest));

				break; 

			} catch (NumberFormatException e) {

				System.out.println("that is not a valid number, try again");

			}
			
		}

		return new HomePrompt();
		
	}

}
