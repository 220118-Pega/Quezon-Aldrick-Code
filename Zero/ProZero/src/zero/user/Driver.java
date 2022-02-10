package zero.user;

import java.util.Scanner;

import zero.userdata.DBRepository;
import zero.userdata.InMemoryRepo;
import zero.userdata.RequestDAO;
import zero.userinterface.UserMenu;
import zero.userlogic.RqLogic;

public class Driver {

	public static void main(String[] args) {

	// Run app here
	UserMenu run = new UserMenu(new Scanner(System.in), new RqLogic(new DBRepository(new RequestDAO())));
	
	run.topMenu();
		
	}

}
