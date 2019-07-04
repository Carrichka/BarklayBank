package com.revature.driver;

import com.revature.prompts.HomePrompt;
import com.revature.prompts.Prompt;

/**
 * main method
 * 
 * @author carri
 * 
 * @param args String[]
 *
 */
public class BarklayBankDriver {

	public static void main(String[] args) {
		Prompt currentPrompt = new HomePrompt();
		while(true) {
			currentPrompt = currentPrompt.run();
		}
	}

}
