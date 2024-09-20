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
		displayText(0);
		int userChoice = 0;
		String airplaneID = "";
			
		while(userChoice != 5) {
			displayText(1);
			displayText(2);
			
			userChoice = sc.nextInt();
			
			switch (userChoice) {
			case 1:
				displayText(3);
				displayListOfAirplanes(listOfAirPlanes);
				displayText(4);
				while (userChoice != 6) {
					userChoice = sc.nextInt();
					if (userChoice == 1) {
						displayText(5);
						airplaneID = searchForAirplane(listOfAirPlanes);
						arrayOfAirplanesPieces = addPieceToAirplane(airplaneID, arrayOfAirplanesPieces);
						displayText(10);
						System.out.println(arrayOfAirplanesPieces);
					} else if (userChoice == 2) {
						displayText(5);
						searchForAirplane(listOfAirPlanes);
						displayText(4);
					}
				}
				break;
			case 2:
				displayText(6);
				searchForAirplane(listOfAirPlanes);
				displayText(4);
				while (userChoice != 6) {
					userChoice = sc.nextInt();
					if (userChoice == 1) {
						displayText(5);
						airplaneID = searchForAirplane(listOfAirPlanes);
						displayText(4);
						arrayOfAirplanesPieces = addPieceToAirplane(airplaneID, arrayOfAirplanesPieces);
					} else if (userChoice == 2) {
						displayText(5);
						searchForAirplane(listOfAirPlanes);
						displayText(4);
					}
				}
				break;
			case 3:
				
				System.out.println("add new piece to airplane by ID");
				airplaneID = searchForAirplane(listOfAirPlanes);
				arrayOfAirplanesPieces = addPieceToAirplane(airplaneID, arrayOfAirplanesPieces);
				System.out.println(arrayOfAirplanesPieces);
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
	
	public static HashMap<String, ArrayList<String>> addPieceToAirplane(String airplaneID, HashMap<String, ArrayList<String>> arrayOfAirplanesPieces) {
		HashMap<String, ArrayList<String>> pieces = arrayOfAirplanesPieces;
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
		pieces.put(airplaneID, new ArrayList<String>(Arrays.asList("Name : " + name, "Price : " + price, "Category : " + category)));
		
		return pieces;
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
			displayListOfAirplanes(getArrayBySearchMethod(0, listOfAirPlanes, userInput));
			airplaneID = userInput;
		} else {
			displayListOfAirplanes(getArrayBySearchMethod(1, listOfAirPlanes, userInput));
		}
		
		return airplaneID;
	}
	
	public static void displayListOfAirplanes(ArrayList<ArrayList<String>> listOfAirPlanes) {
			for (int i = 0; i < listOfAirPlanes.size(); i++) {
				System.out.println(listOfAirPlanes.get(i));
			}
	}
	
	// generate a random UUID with 128bits and convert it to String
	public static String createUniqueID() {
		return UUID.randomUUID().toString();
	}
	
	public static void displayText(int index) {
		String[] arrOfSentences = {
				"Welcome to AIRBUS AIRPLANE SYSTEM!", //0
				"\nWhat do you want to do ?\n", //1
				"1 - DISPLAY ALL AIRPLANES | 2 - SEARCH FOR AIRPLANE | 3 - ADD/REMOVE AIRPLANE PIECE | 5 - EXIT\n", //2
				"LIST OF AVAIABLE AIRPLANES\n", //3
				"1 - ADD/REMOVE AIRPLANE PIECE |6 - GO BACK",//4
				"ADD AIRPLANE ID: ",//5
				"1 - ADD",//6
				"2 - REMOVE",//7
				"remove a piece from airplane by ID",//8
				"You have to choice at least one valid option !",//9
				"6 - GO BACK",//10
				"Goodbye!",//11
		};
		
		System.out.println(arrOfSentences[index]);
	}
	
	//list of airplanes pieces
	public static HashMap<Integer, ArrayList<String>> getListOfAirplanePieces(){
		
		HashMap<Integer, ArrayList<String>>ListOfAirplanePieces = new HashMap<Integer, ArrayList<String>>();
		ListOfAirplanePieces.put(1, new ArrayList<>(Arrays.asList("Turbofan Engine", "3000000", "Propulsion")));
		ListOfAirplanePieces.put(2, new ArrayList<>(Arrays.asList("Flight Control System", "100000", "Electronics/Control")));
		ListOfAirplanePieces.put(3, new ArrayList<>(Arrays.asList("Fuel Pump", "10000", "Fuel System")));
		ListOfAirplanePieces.put(4, new ArrayList<>(Arrays.asList("Wings", "1500000", "Structure")));
		ListOfAirplanePieces.put(5, new ArrayList<>(Arrays.asList("Oxygen System", "15000", "Life Support")));
		ListOfAirplanePieces.put(6, new ArrayList<>(Arrays.asList("Propeller", "75000", "Propulsion")));
		
		return ListOfAirplanePieces;
	}
	
	// list of airplanes
	public static HashMap<String, ArrayList<String>> getListOfAirPlanes(){
		
		HashMap<String, ArrayList<String>> listOfAirPlanes = new HashMap<String, ArrayList<String>>();
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("A220-100", "conception", "transport de passagers")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("A318", "conception", "transport de passagers")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("A330-200F", "conception", "frêt")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("A330P2F", "conception", "frêt")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("A400M Atlas", "conception", "militaire")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("C295", "conception", "militaire")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("ACJ320neo", "conception", "affaires")));
		listOfAirPlanes.put(createUniqueID(), new ArrayList<>(Arrays.asList("ACJ350 XWB", "conception", "affaires")));
		
		return listOfAirPlanes;
	}

}
