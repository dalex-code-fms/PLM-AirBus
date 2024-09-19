import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class PLANES {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> listOfAirPlanes = getListOfAirPlanes();
		HashMap<String, ArrayList<String>> arrayOfAirplanesPieces = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to AIRBUS AIRPLANE SYSTEM!");
		int userChoice = 0;
		String airplaneID = "";
			
		while(userChoice != 5) {
			System.out.println("\nWhat do you want to do ?\n");
			System.out.println("1 - Show all airplanes | 2 - Search for airplane | 3 - add new piece to airplane | 4 - remove piece from airplane | 5 - exit\n");
			
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1:
				System.out.println("List of all Airplanes\n");
				showListOfAirplanes(listOfAirPlanes);
				System.out.println("1 - add new piece to airplane by ID | 2 - remove a piece from airplane by ID | 6 - go back");
				while (userChoice != 6) {
					userChoice = sc.nextInt();
					if (userChoice == 1) {
						System.out.println("add airplane ID to add a piece: ");
						airplaneID = searchForAirplane(listOfAirPlanes);
						System.out.println("1 - add new piece to airplane by ID | 2 - remove a piece from airplane by ID | 6 - go back");
						addPieceToAirplane(airplaneID);
					} else if (userChoice == 2) {
						System.out.println("add airplane ID to remove a piece:");
						searchForAirplane(listOfAirPlanes);
						System.out.println("1 - add new piece to airplane by ID | 2 - remove a piece from airplane by ID | 6 - go back");
					}
				}
				break;
			case 2:
				System.out.println("Search for airplane");
				searchForAirplane(listOfAirPlanes);
				System.out.println("1 - add new piece to airplane | 2 - remove a piece from airplane | 6 - go back");
				while (userChoice != 6) {
					userChoice = sc.nextInt();
					if (userChoice == 1) {
						System.out.println("add airplane ID to add a piece: ");
						airplaneID = searchForAirplane(listOfAirPlanes);
						System.out.println("1 - add new piece to airplane by ID | 2 - remove a piece from airplane by ID | 6 - go back");
						addPieceToAirplane(airplaneID);
					} else if (userChoice == 2) {
						System.out.println("add airplane ID to remove a piece: ");
						searchForAirplane(listOfAirPlanes);
						System.out.println("1 - add new piece to airplane by ID | 2 - remove a piece from airplane by ID | 6 - go back");
					}
				}
				break;
			case 3:
				
				System.out.println("add new piece to airplane by ID");
				airplaneID = searchForAirplane(listOfAirPlanes);
				addPieceToAirplane(airplaneID);
				break;
			case 4:
				System.out.println("remove a piece from airplane by ID");
				break;
			default:
				System.out.println("You have to choice at least one valid option !");
			}
		}
		System.out.println("Goodbye!");
		
		sc.close();
	}
	
	public static void addPieceToAirplane(String airplaneID) {
		HashMap<String, ArrayList<String>> arrayOfAirplanesPieces = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String name = "";
		String price = "";
		String category = "";
		System.out.println("Add the piece details for airplane : " + airplaneID);
		System.out.print("Name : ");
		name = sc.nextLine();
		System.out.print("Price : ");
		price = sc.nextLine();
		System.out.print("Category : ");
		category = sc.nextLine();
		arrayOfAirplanesPieces.put(airplaneID, new ArrayList<String>(Arrays.asList("Name : " + name, "Price : " + price, "Category : " + category)));
		System.out.println(arrayOfAirplanesPieces);
	}
	
	public static ArrayList<ArrayList<String>> getArrayBySearchMethod(int index, ArrayList<ArrayList<String>> listOfAirPlanes, String userInput){
		
		ArrayList<ArrayList<String>> arrOfSelectedAirplanes = new ArrayList<>();
		
		for (int i = 0; i < listOfAirPlanes.size(); i++) {
			if (listOfAirPlanes.get(i).get(index).contains(userInput)) {
				arrOfSelectedAirplanes.add(listOfAirPlanes.get(i));
			}
		}
		return arrOfSelectedAirplanes;
	}
	
	public static String searchForAirplane(ArrayList<ArrayList<String>> listOfAirPlanes) {
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		String airplaneID = "";
		
		int sizeOfID = createUniqueID().length();

		if (userInput.length() == sizeOfID) {
			showListOfAirplanes(getArrayBySearchMethod(0, listOfAirPlanes, userInput));
			airplaneID = userInput;
		} else {
			showListOfAirplanes(getArrayBySearchMethod(1, listOfAirPlanes, userInput));
		}
		
		return airplaneID;
	}
	
	public static void showListOfAirplanes(ArrayList<ArrayList<String>> listOfAirPlanes) {
			for (int i = 0; i < listOfAirPlanes.size(); i++) {
				System.out.println(listOfAirPlanes.get(i));
			}
	}
	
	// generate a random UUID with 128bits and convert it to String
	public static String createUniqueID() {
		return UUID.randomUUID().toString();
	}
	
	// list of airplanes
	public static ArrayList<ArrayList<String>> getListOfAirPlanes(){
		
		ArrayList<ArrayList<String>> listOfAirPlanes = new ArrayList<>();
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A220-100", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A220-300", "clôturé", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A220-100", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A318", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330-300", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A321", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330-300", "conception", "transport de passagers")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330-200F", "conception", "frêt")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330P2F", "conception", "frêt")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330P2F", "conception", "frêt")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A300-600ST Beluga", "conception", "frêt")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A400M Atlas", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A400M Atlas", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "C295", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330 MRTT", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A400M Atlas", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "C295", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "C295", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "A330 MRTT", "conception", "militaire")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ320neo", "conception", "affaires")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ318 Atlas", "conception", "affaires")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ350 XWB", "conception", "affaires")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ318 Atlas", "conception", "affaires")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ320neo", "conception", "affaires")));
		listOfAirPlanes.add(new ArrayList<>(Arrays.asList(createUniqueID(), "ACJ350 XWB", "conception", "affaires")));
		
		// retirer le 2eme ArrayList et faire un array normal ArrayList<String []>
		// pour les pieces peut etre un arrayList of arrays et puis concat si id ==
		
		return listOfAirPlanes;
	}

}
