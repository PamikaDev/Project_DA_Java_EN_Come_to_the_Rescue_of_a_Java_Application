package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 */
public class ReadSideEffectDataFromFile implements ISideEffectReader {

	private String filePath;

	/**
	 * @param filePath a full or partial path to file with sideEffect strings in it,one per line
	 */
	public ReadSideEffectDataFromFile(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	public List<String> readSideEffects() {
		return readSideEffects();
	}

	 /** 
	  * Count the sideEffects read from a file and put in a Arraylist type container
	  */
	@Override
	public ArrayList<String> readSideEffects(List<String> sideEffects) throws IOException {

		/**
		 * Read a list of ideEffect and return it
		 * @return a arrayList with ideEffect
		 */
		ArrayList<String> result = new ArrayList<String>();
		if (filePath != null) {
			try {
				// first get input
				BufferedReader reader = new BufferedReader(new FileReader("sideEffects.txt"));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine(); // get another sideEffects
				}
				// close resources
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
