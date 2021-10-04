package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

	public WriteSymptomDataToFile(String resultOut) {
		AnalyticsCounter.getResultOut();
	}

	/**
	 * Counts and sorts the data
	 * 
	 * @param symptomList -> Contains each line read
	 * @return a list of symptoms after counting and sorting.
	 */
	@Override
	public Map<String, Integer> countAndSort(List<String> symptomList) {

		// We use TreeMap to order the symptom list
		/**
		 * @param symptomOccurence: Object type Map<String, Integer>. parameters String
		 *                          -> key = ( symptom) parameters Integer -> value = (
		 *                          occurence )
		 * @return a list of symptoms and its number of occurrences.
		 */
		Map<String, Integer> symptomOccurence = new TreeMap<>();

		// We check if the symptom exists in the file and we count its number of
		// occurrences
		for (String symptom : symptomList) {

			Integer occurence = symptomOccurence.getOrDefault(symptom, 0);
			symptomOccurence.put(symptom, occurence + 1);
		}

		// Order the list, line by line on the console by comparing the keys
		symptomOccurence.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
				.forEach(System.out::println);

		return symptomOccurence;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptomListOut) {
		// Write the symptom list to file out
		try {
			FileWriter writer = new FileWriter(AnalyticsCounter.getResultOut());

			writer.write("List of symptoms with their occurences: " + " \n");
			writer.write("#######################################" + " \n");

			for (Entry<String, Integer> symptoms : symptomListOut.entrySet()) {

				// File.out
				writer.write(symptoms.getKey() + " = " + symptoms.getValue() + " \n");
				writer.flush(); // Force write

			}
			writer.close();

		} catch (Exception e) {
			System.out.println("Unable to write file: " + e.getMessage());
		}

	}

}
