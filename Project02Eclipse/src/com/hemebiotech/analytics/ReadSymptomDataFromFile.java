package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 * 
	 * @param source a full or partial path to source with symptoms strings in
	 *               it,one per line
	 */
	private String source = "symptoms.txt";
	private static Instant startedAt;
	private static Instant endedAt;
	public ReadSymptomDataFromFile() {
		initStartingTime();
		showTestDuration();
	}
	@BeforeAll
	public static void initStartingTime() {
		startedAt = Instant.now();
	}
	@AfterAll
	public static void showTestDuration() {
		endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée d'exécution ReadSymptomDataFromFile: {0} ms :", duration));
	}
	/**
	 * 
	 * Read symptom from a source and put in a Arraylist type container
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> symptomList = new ArrayList<String>();
		if (source != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(source))) { 
				String line;
				while ((line = reader.readLine()) != null) {
					// Capitalize the first letter of symptoms
					symptomList.add(line.substring(0, 1).toUpperCase() + line.substring(1, line.length()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return symptomList;
	}
}
