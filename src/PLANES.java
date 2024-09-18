import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PLANES {

	public static void main(String[] args) {
		String[][] listOfAirPlanes = getListOfAirPlanes();
		
		for (int l = 0; l < listOfAirPlanes.length; l++) {
		
			System.out.println(Arrays.toString(listOfAirPlanes[l]));				
			
			
		}
	}
	
	public static String createUniqueID() {
		return UUID.randomUUID().toString();
	}
	
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
