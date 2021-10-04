package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * @param file a full or partial path to file with symptoms strings in it,one
	 *             per line
	 */
	public ReadSymptomDataFromFile(String file) {
		AnalyticsCounter.getFile();
	}

	/**
	 * Count the symptoms read from a file and put in a Arraylist type container
	 */
	@Override
	public List<String> getSymptoms() throws IOException {

		/**
		 * Read a list of symptom and return it
		 * 
		 * @return a arrayList with symptom
		 */
		List<String> symptoms = new ArrayList<String>();
		if (AnalyticsCounter.getFile() != null) {
			try {
				// first get input
				BufferedReader reader = new BufferedReader(new FileReader(AnalyticsCounter.getFile()));
				String line = reader.readLine();

				while (line != null) {
					symptoms.add(line.substring(0, 1).toUpperCase() + line.substring(1, line.length()));
					line = reader.readLine(); // get another symptoms
				}
				// close resources
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return symptoms;
	}
}
