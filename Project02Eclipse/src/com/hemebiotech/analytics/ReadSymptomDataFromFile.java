package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader("results.out"));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}




//package com.hemebiotech.analytics;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//
///**
// * Simple brute force implementation
// *
// */
//public class ReadSymptomDataFromFile implements ISymptomReader {
//
//	private static String filepath;
//
//	public static String getFilepath() {
//		return filepath;
//	}
//
//	public static void setFilepath(String filepath) {
//		ReadSymptomDataFromFile.filepath = filepath;
//	}
//
//	/**
//	 * @param readsymtfromfile
//	 * @param readsymtfromfile a full or partial path to file with symptom strings
//	 *                         in it, one per line
//	 * @throws IOException
//	 */
//
//	public ReadSymptomDataFromFile(Map<String, Integer> readsymtfromfile) throws IOException {
//
//		TreeMap<String, Integer> analycount = new TreeMap<>();
//
//		analycount.putAll(readsymtfromfile);
//
//		List<String> finallines = analycount.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
//				.collect(Collectors.toList());
//		Files.write(Paths.get("results.out"), finallines);
//	}
//
//	@Override
//	public List<String> getSymptoms() throws IOException {
//		return getSymptoms();
//	}
//
//}