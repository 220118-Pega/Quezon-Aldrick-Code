package zero.userinterface;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zero.userlogic.IRqLogic;
import zero.usermodels.Request;

public class UserMenu {

	private Scanner userInput;
	
	private IRqLogic requestLogic;
	
	// Set up logging
	// Have logger per class so you have more flexibility
	 // in configuring logs
	private final Logger logger = LogManager.getLogger(this.getClass());
	
	public UserMenu(Scanner userInput, IRqLogic requestLogic) {
		this.userInput = userInput;
		this.requestLogic = requestLogic;
		
		
	}
	
	
	public void topMenu() {
		
		boolean proceed = true;
		
		do {
			System.out.println("What do you want?");
			System.out.println("[1] Make a Request");
			System.out.println("[2] View Requests");
			System.out.println("[3] Nothing");
			
			String userChoice = userInput.nextLine();
//			String userChoice = userInput.nextLine();
			switch (userChoice) {
			case "1":
				System.out.println("Making Request Form--\n");
//			    Request newRequest = new Request();
//				System.out.println(newRequest);
				makeRequest();
				break;
			case "2":
				System.out.println("What do you wanna see?");
				System.out.println("[1] My Requests");
				System.out.println("[2] Sent Requests");
				System.out.println("[3] Never Mind");
				String userChoice2 = userInput.nextLine();
				
				switch (userChoice2) {
				case "1":
					System.out.println("Fetching--");
					requestViewForm();
					break;
				case "2":
					System.out.println("Depends. You an Employee or Manager?");
					System.out.println("[E] Employee");
					System.out.println("[M] Manager");
					String userChoice3 = userInput.nextLine();
					
					switch (userChoice3) {
					case "E":
					case "e":
						System.out.println("Nope. Sorry. Can't. Not a manager. Taking you back.\n");
						proceed = true;
						break;
					case "M":
					case "m":
						System.out.println("Fetching--");
						getRequest();
						proceed = true;
						break;
					default:
						System.out.println("Only 2 options and you missed both. Try again.");
						proceed = true;
						break;
					}
				}
				break;	
				case "3":
					System.out.println("Later.");
					proceed = false;
					break;
				default:
					System.out.println("There are only 3 options. Seriously. Let's try this again.");
					break;
				}
			
		} while (proceed);
		
	}
	


	private void requestViewForm() {
		System.out.println("Enter the Request Form # to view-- ");
		String strFormNum = userInput.nextLine();
		Request viewRequest;
		
		try {
			viewRequest = requestLogic.getRqByFormNum(Integer.parseInt(strFormNum));
			System.out.println(viewRequest);
		} catch (Exception e1) {
			System.out.println("Could not find that request. Try a different form #\n");
			logger.error("Invalid user input");
		}
		
	}


	private void getRequest() {
//		
//		for (Request rq:requestLogic.getRequest()) {
//			
//			System.out.println(rq);
//		}
		
		
		
		System.out.println("Which requests do you wanna look at?");
		System.out.println("Pending / Approved / Rejected / All");
		
		String statusFetch = userInput.nextLine();
		Request viewByForm;
		
		try {
			viewByForm = requestLogic.getRqByStatus(statusFetch);
			System.out.println(viewByForm);
			
		} catch (Exception e1) {
			System.out.println("No Request form found.");
			logger.error("Request form not found");
		} 
		
	}
	
	




	private void makeRequest() {
		
//		String[] status = {"Approved", "Rejected", "Pending"};
//		String rqStatus = status[(int) (Math.random() * status.length)];
//		System.out.println(rqStatus);
		
		System.out.println("Enter your name");
		String requestUser = userInput.nextLine();
		System.out.println("Choose the type of request");
		System.out.println("Lodging / Business / Food / Other");
		String requestType = userInput.nextLine();
		System.out.println("Enter amount for your request");
		String requestAmount = userInput.nextLine();
		Request newRequest = new Request(requestUser, requestType, requestAmount);
		
		// Store data
		requestLogic.addRequest(newRequest);
		System.out.println(newRequest); //+ "\n        [Status: " + rqStatus + "]");
	}
	
}

