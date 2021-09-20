package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		ReadSymptomDataFromFile.filepath = filepath;
	}

	private static String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * @throws IOException
	 */

	public ReadSymptomDataFromFile() throws IOException {

		try (FileWriter file = new FileWriter(filepath)) {

			try {
				if (filepath != null) {

					try (BufferedWriter out = new BufferedWriter(new FileWriter("results.out"))) {

						Map<String, Integer> sympt = new TreeMap<>();

						for (Entry<String, Integer> analycount : sympt.entrySet()) {

							System.out.println(analycount.getKey() + ": " + analycount.getValue());

							out.write(analycount.getKey() + " = " + analycount.getValue() + " \n");
						}

					} catch (Exception FileNotFoundException) {
						FileNotFoundException.printStackTrace();
					}
				}

			} catch (Exception FileNotFoundException) {
				FileNotFoundException.printStackTrace();
			}

		}
	}

	public Entry<String, Integer> getEntry() {
		return getEntry();
	}

	public void setEntry(Entry<String, Integer> entry) {
		this.setEntry(entry);
	}

	@Override
	public Map<String, Integer> Symptoms() throws IOException {
		return Symptoms();
	}

	

}

//---------------------------------------------------------------------	

// public Map<String, Integer> Symptoms () throws IOException {
//	public List<String> GetSymptoms () throws IOException{
//	
//		Map<String, Integer> sympt = new TreeMap<>();
//		
//		FileWriter writer = new FileWriter("results.out");
//
//		 if (filepath != null) {
//
//		try (BufferedWriter out = new BufferedWriter(writer)) {
//
//			for (Map.Entry<String, Integer> entry : sympt.entrySet()) {
//
//				out.write(entry.getKey() + " = " + entry.getValue() + " \n");
//
//				out.flush(); // Force write
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//		return entry;
//}
//
//	@Override
//	public Map<String, Integer> Symptoms() throws IOException {
//		
//		return Symptoms();
//	}
//
//}