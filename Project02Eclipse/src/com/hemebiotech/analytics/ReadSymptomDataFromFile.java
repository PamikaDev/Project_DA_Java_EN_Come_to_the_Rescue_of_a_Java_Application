package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * 
	 * @param source a full or partial path to source with symptoms strings in it,one
	 *             per line
	 * 
	 */
	private String source = "symptoms.txt";

	public String getSource() {
		return source;
	}

	public void setSource(String source) throws IOException{
		if (source == null) {
			throw new IOException(source);
		}
		this.source = source;
	}

	public ReadSymptomDataFromFile(String source) {
		this.source = source;
	}

	public ReadSymptomDataFromFile() {
	}

	/**
	 * 
	 * Read symptom from a source and put in a Arraylist type container
	 */
	@Override
	public List<String> getSymptoms() {

		List<String> symptomList = new ArrayList<String>();

		if (source != null) {
			try {
				String line ;
				BufferedReader reader = new BufferedReader(new FileReader(source));

				while ((line = reader.readLine()) != null) {
					// Capitalize the first letter of symptoms
					symptomList.add(line.substring(0, 1).toUpperCase() + line.substring(1, line.length()));
				}
				// close resources
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return symptomList;
	}
}
