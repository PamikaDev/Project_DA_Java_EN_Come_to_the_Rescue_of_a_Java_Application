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
	 * @param readsymtfromfile a full or partial path to file with symptom strings
	 *                         in it, one per line
	 * @throws IOException
	 */

	public ReadSymptomDataFromFile(Map<String, Integer> readsymtfromfile) throws IOException {

		TreeMap<String, Integer> analycount = new TreeMap<>();

		analycount.putAll(readsymtfromfile);

		List<String> finallines = analycount.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
				.collect(Collectors.toList());
		Files.write(Paths.get("results.out"), finallines);
	}

	@Override
	public List<String> GetSymptoms() throws IOException {
		return GetSymptoms();
	}

}