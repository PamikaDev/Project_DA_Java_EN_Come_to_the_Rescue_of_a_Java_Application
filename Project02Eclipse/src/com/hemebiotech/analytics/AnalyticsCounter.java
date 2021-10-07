package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * 
 * AnalyticsCounter is the main class of this application. Reads the symptom
 * data file, counts and sorts the data by key and value. Transcribes the data
 * in a created file.
 * 
 * @author WEB_DEV
 */
public class AnalyticsCounter {

	private static ISymptomReader rsdf = new ReadSymptomDataFromFile();

	private static ISymptomWriter wsdf = new WriteSymptomDataToFile();

	/**
	 * 
	 * Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	 * 
	 * @param args
	 * 
	 * @throws IOException Invalid Argument IOException describe when this exception
	 *                     is thrown by the method.
	 */
	public static void main(String args[]) throws IOException {

		wsdf.writeSymptoms(wsdf.countAndSort(rsdf.getSymptoms()));
	}
}
