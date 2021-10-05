package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * 
 * AnalyticsCounter is main class of application Reads symptom data file
 * grouping data by key and value. Creates a file with out of results
 */
public class AnalyticsCounter {

	private static ISymptomReader rsdf =  new ReadSymptomDataFromFile(ReadSymptomDataFromFile.getFile());
	
	private static ISymptomWriter wsdf = new WriteSymptomDataToFile(WriteSymptomDataToFile.getResultOut());

	/**
	 * 
	 * Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	 * @param args
	 * @throws IOException Invalid Argument IOException describe when this exception
	 * is thrown by the method
	 */
	public static void main(String args[]) throws IOException {
		
		wsdf.writeSymptoms(wsdf.countAndSort(rsdf.getSymptoms()));
	}	
}
