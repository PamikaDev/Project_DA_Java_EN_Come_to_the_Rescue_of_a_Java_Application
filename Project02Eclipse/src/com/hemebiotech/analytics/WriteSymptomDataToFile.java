package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Takes a Map as parameter, and write the values and keys of its elements, in
 * the file.
 * 
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String resultOut = "results.out";

	public String getResultOut() {
		return resultOut;
	}

	public void setResultOut(String resultOut) throws IOException {
		if (resultOut == null) {
			throw new IOException(resultOut);
			
		}
		this.resultOut = resultOut;
	}

	public WriteSymptomDataToFile(String resultOut) {
		super();
		this.resultOut = resultOut;
	}

	public WriteSymptomDataToFile() {
	}

	/**
	 * Method - writeSymptoms () - which takes a Map as parameter, and write the
	 * values and keys of its elements, in the file
	 * 
	 * @param: symptomListOut
	 * @param: result         resultOut
	 * 
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptomListOut) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultOut));

			writer.write("List of symptoms with their occurences: " + " \n");
			writer.write("#######################################" + "\n");
			writer.write("We have " + symptomListOut.size() + " distinct(s) symptoms listed as well: " + " \n");
			writer.write("-----------------------------------------------" + "\n");

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