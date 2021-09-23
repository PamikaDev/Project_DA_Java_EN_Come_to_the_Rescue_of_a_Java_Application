package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter  {

	private ISymptomWriter symptomsWriter;
	
	public AnalyticsCounter(ISymptomWriter writer) {
		
		symptomsWriter = writer;
	}
	
	public void counter() throws IOException {
		List<String> symptomList = Files.readAllLines(Paths.get("symptoms.txt"));
		Map<String, Integer> readsymtfromfile = new TreeMap<>();

		// Initialize the frequency table
		for (String a : symptomList) {
			Integer AnalyticsCounter = readsymtfromfile.get(a);

			/**
			 * This argument is a conditional expression that has the effect of setting the
			 * frequency to one if the word has never been seen before or to one more than
			 * its current value if the word has already been seen.
			 */
			readsymtfromfile.put(a, (AnalyticsCounter == null) ? 1 : AnalyticsCounter + 1);
		}

		System.out.println("We have " + readsymtfromfile.size() + " distinct symptoms listed as well :" + " \n");

		// Order the list, line by line on the console by comparing the keys
		readsymtfromfile.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
				.forEachOrdered(System.out::println);


		symptomsWriter.writeSymptoms(readsymtfromfile);
		
	}

	//Read symptoms from file
	public static void main(String[] args) throws IOException {

		ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
		AnalyticsCounter analyticscounter = new AnalyticsCounter(symptomWriter);
		
		analyticscounter.counter();
		
		
		
		
	}

	// A SortedMap is a Map that maintains its entries in ascending order,
	// sorted according to the keys' natural ordering, or according to a
	// Comparator provided at the time of the SortedMap creation

	// keySet — the Set of keys contained in the Map.

	// values — The Collection of values contained in the Map.
	// This Collection is not a Set, because multiple keys can map to the
	// same value.

	// entrySet — the Set of key-value pairs contained in the Map.
	// The Map interface provides a small nested interface called Map.Entry,
	// the type of the elements in this Set.

}
