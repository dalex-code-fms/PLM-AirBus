import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class PLANES {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to AirBus !");
		int userChoice = 0;
		
		
		while(userChoice != 5) {
			System.out.println("\nWhat do you want to do ?\n");
			System.out.println("1 - Show all airplanes | 2 - Search for airplane | 3 - add new piece to airplane | 4 - remove piece from airplane | 5 - exit\n");
			
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1:
				System.out.println("List of all Airplanes\n");
				showListOfAirplanes(getListOfAirPlanes());
				System.out.println("1 - add new piece to airplane | 2 - remove a piece from airplane | 6 - go back");
				while (userChoice != 6) {
					userChoice = sc.nextInt();
					
					if (userChoice == 1) {
						System.out.println("add new piece to airplane");
					} else if (userChoice == 2) {
						System.out.println("remove a piece from airplane");
					}
				}
				break;
			case 2:
				System.out.println("Search for airplane");
				break;
			case 3:
				System.out.println("add new piece to airplane");
				break;
			case 4:
				System.out.println("remove piece from airplane");
				break;
			default:
				System.out.println("You have to choice at least one valid option !");
			}
		}
		System.out.println("Goodbye!");
		
		/*for (int l = 0; l < listOfAirPlanes.length; l++) {
			System.out.println(Arrays.toString(listOfAirPlanes[l]));					
		}*/
	}
	
	public static void showListOfAirplanes(String[][] listOfAirPlanes ) {
		for (int i = 0; i < listOfAirPlanes.length; i++) {
			System.out.println(Arrays.toString(listOfAirPlanes[i]));
		}
	}
	
	// generate a random UUID with 128bits and convert it to String
	public static String createUniqueID() {
		return UUID.randomUUID().toString();
	}
	
	// list of airplanes
	public static String[][] getListOfAirPlanes(){
		String [][] listOfAirPlanes = {
				{createUniqueID(), "A220-100", "conception", "transport de passagers"},
				{createUniqueID(), "A220-300", "clôturé", "transport de passagers"},
				{createUniqueID(), "A220-100", "conception", "transport de passagers"},
				{createUniqueID(), "A318", "conception", "transport de passagers"},
				{createUniqueID(), "A330-300", "conception", "transport de passagers"},
				{createUniqueID(), "A321", "conception", "transport de passagers"},
				{createUniqueID(), "A330-300", "conception", "transport de passagers"},
				{createUniqueID(), "A330-200F", "conception", "frêt"},
				{createUniqueID(), "A330P2F", "conception", "frêt"},
				{createUniqueID(), "A330P2F", "conception", "frêt"},
				{createUniqueID(), "A300-600ST Beluga", "conception", "frêt"},
				{createUniqueID(), "A400M Atlas", "conception", "militaire"},
				{createUniqueID(), "A400M Atlas", "conception", "militaire"},
				{createUniqueID(), "C295", "conception", "militaire"},
				{createUniqueID(), "A330 MRTT", "conception", "militaire"},
				{createUniqueID(), "A400M Atlas", "conception", "militaire"},
				{createUniqueID(), "C295", "conception", "militaire"},
				{createUniqueID(), "A330 MRTT", "conception", "militaire"},
				{createUniqueID(),"ACJ320neo", "conception", "affaires" },
				{createUniqueID(), "ACJ318 Atlas", "conception", "affaires"},
				{createUniqueID(), "ACJ350 XWB", "conception", "affaires"},
				{createUniqueID(), "ACJ318 Atlas", "conception", "affaires"},
				{createUniqueID(), "ACJ320neo", "conception", "affaires"},
				{createUniqueID(), "ACJ350 XWB", "conception", "affaires"},
		};
		
		return listOfAirPlanes;
	}

}
