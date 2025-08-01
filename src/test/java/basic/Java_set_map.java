package basic;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import java.util.HashMap;

public class Java_set_map {
	@Test
	public void setExample() {
	        // Set example
	        Set<String> uniqueCountries = new HashSet<>();
	        uniqueCountries.add("USA");
	        uniqueCountries.add("Canada");
	        uniqueCountries.add(" "); // White space will be added
	        uniqueCountries.add("USA");
	        uniqueCountries.add("USA"); // duplicate, will be ignored
	        System.out.println(uniqueCountries); // [USA, Canada]

	        // Map example
	        Map<String, String> countryCapitals = new HashMap<>();
	        countryCapitals.put("USA", "Washington D.C.");
	        countryCapitals.put("Canada", "Ottawa");
	        System.out.println(countryCapitals.get("Canada")); // Washington D.C.
	   
	}  
}
