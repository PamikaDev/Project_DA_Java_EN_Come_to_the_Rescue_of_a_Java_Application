package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Takes a Map as parameter, and write the values and keys of its elements, in
 * the file.
 * 
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String resultOut = "results.out";
	private Instant startedAt;
	private Instant endedAt;
	@BeforeAll
	public void initStartingTime() {
		startedAt = Instant.now();
	}
	@AfterAll
	public void showTestDuration() {
		endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée d'exécution WriteSymptomDataToFile: {0} ms :", duration));
	}
	//Constructor
	public WriteSymptomDataToFile() {
		initStartingTime();
		showTestDuration();
	}
	/**
	 * @param: symptomOccurence       
	 * 
	 */
	@Override
	// Method - writeSymptoms () - which takes a Map as parameter, and write the values and keys of its elements, in the file.
	public void writeSymptoms(Map<String, Integer> symptomOccurence) {
		//Console
		System.out.println("List of symptoms with their occurences: ");
		System.out.println("#######################################");
		System.out.println("We have " + symptomOccurence.size() + " distinct(s) symptoms listed as well: " );
		System.out.println("-----------------------------------------------");
		//Try with ressources
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultOut) )) {
			//File out
			writer.write("List of symptoms with their occurences: " + " \n");
			writer.write("#######################################" + "\n");
			writer.write("We have " + symptomOccurence.size() + " distinct(s) symptoms listed as well: " + " \n");
			writer.write("-----------------------------------------------" + "\n");
			//Iteration
			for (Entry<String, Integer> symptoms : symptomOccurence.entrySet()) {
				//Output in console
				System.out.print(symptoms.getKey() + " = " + symptoms.getValue()+ " \n");
				// File.out
				writer.write(symptoms.getKey() + " = " + symptoms.getValue() + " \n");
				// Force write
				writer.flush(); 
			}
		} catch (IOException e) {
			System.out.println("Unable to write file: " + e.getMessage());
		}	
	}
}