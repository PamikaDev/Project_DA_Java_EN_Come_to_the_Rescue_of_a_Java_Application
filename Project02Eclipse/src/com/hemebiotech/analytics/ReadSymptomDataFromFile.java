package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	private static String filepath;

	public static String getFilepath() {
		return filepath;
	}
	
	public static void setFilepath(String filepath) {
		ReadSymptomDataFromFile.filepath = filepath;
	}

	/**
	 * @param readsymtfromfile 
	 * @param readsymtfromfile a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * @throws IOException
	 */

	public ReadSymptomDataFromFile(Map<String, Integer> readsymtfromfile) throws IOException {
		
	
	//	try (FileWriter file = new FileWriter("results.out")) {
		
		TreeMap<String, Integer> analycount = new TreeMap<>();
		
		analycount.putAll(analycount);

		List<String> finallines = analycount.entrySet().stream().
		map(entry -> entry.getKey() + ": " + entry.getValue()).collect(Collectors.toList());
		Files.write(Paths.get("results.out"), finallines);}
		


				
//		Map<String, Integer> readsymtfromfile = new TreeMap<>();
//		try (FileWriter file = new FileWriter("results.out")) {
//			
//				if (file != null) {
//					
//					try (BufferedWriter out = new BufferedWriter(new FileWriter("results.out"))) {
//						readsymtfromfile = new TreeMap<>();
//
//						for (Entry<String, Integer> analycount : readsymtfromfile.entrySet()) {
//							
//							System.out.println(analycount.getKey() + ": " + analycount.getValue());
//							
//							out.write(analycount.getKey() + " = " + analycount.getValue() + " \n");
//						}
//
//					} catch (Exception FileNotFoundException) {
//						FileNotFoundException.printStackTrace();
//					}
//				}
//
//			} catch (Exception FileNotFoundException) {
//				FileNotFoundException.printStackTrace();
//			}
		


	@Override
	public List<String> GetSymptoms() throws IOException {
		return GetSymptoms();
	}





}