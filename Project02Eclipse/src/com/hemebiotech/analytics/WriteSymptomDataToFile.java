package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private static String resultOut = "results.out";

	public static String getResultOut() {
		return resultOut;
	}

	public static void setResultOut(String resultOut) {
		setResultOut(resultOut);
	}

	public WriteSymptomDataToFile() {
		super();
	}

	/**
	 * 
	 * Counts and sorts the data
	 * 
	 * @param symptomList -> Contains each line read
	 * @return a list of symptoms after counting and sorting.
	 */
	@Override
	public Map<String, Integer> countAndSort(List<String> symptomList) {

		Map<String, Integer> symptomListSort = new TreeMap<>();

		// We check if the symptom exists in the file and we count its number of
		// occurrences
		for (String symptom : symptomList) {

			symptomListSort.put(symptom, symptomListSort.getOrDefault(symptom, 0) + 1);
		}

		System.out.println("We have " + symptomListSort.size() + " distinct(s) symptoms listed: ");
		System.out.println("--------------------------------------- ");

		// Order the list, line by line on the console by comparing the keys
		symptomListSort.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
				.forEach(System.out::println);

		return symptomListSort;
	}

	// Write the symptom list to file out
	@Override
	public void writeSymptoms(Map<String, Integer> symptomListOut) {

		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultOut));

			writer.write("List of symptoms with their occurences: " + " \n");
			writer.write("#######################################" + "\n");

			writer.write("We have " + symptomListOut.size() + " distinct(s) symptoms listed as well: " + " \n");
			writer.write("###############################################" + "\n\n");

			for (Entry<String, Integer> symptoms : symptomListOut.entrySet()) {

				// File.out
				writer.write(symptoms.getKey() + " = " + symptoms.getValue() + " \n");

				writer.flush(); // Force write
			}

			writer.close();

		} catch (IOException e) {

			System.out.println("Unable to write file: " + e.getMessage());
		}
	}
}