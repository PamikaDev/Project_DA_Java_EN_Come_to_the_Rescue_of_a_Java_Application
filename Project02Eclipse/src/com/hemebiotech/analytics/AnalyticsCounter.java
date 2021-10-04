package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * AnalyticsCounter is main class of application Reads symptom data file
 * grouping data by key and value. Creates a file with out of results
 * 
 * @throws IOException Invalid Argument IOException describe when this exception
 *                     is thrown by the method
 */
public class AnalyticsCounter {

	private static String file = "symptoms.txt";
	private static String resultOut = "results.out";

	private static ISymptomReader rsdf = new ReadSymptomDataFromFile(file);
	private static ISymptomWriter wsdf = new WriteSymptomDataToFile(resultOut);

	public static String getResultOut() {
		return resultOut;
	}
	public static String getFile() {
		return file;
	}

	/**
	 * Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	 * @param args
	 */
	public static void main(String args[]) throws IOException {
	
		wsdf.writeSymptoms(wsdf.countAndSort(rsdf.getSymptoms()));
	}
}
