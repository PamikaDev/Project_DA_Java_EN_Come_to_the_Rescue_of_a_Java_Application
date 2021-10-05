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


	private static ISymptomReader rsdf =  new ReadSymptomDataFromFile(ReadSymptomDataFromFile.getFile());
	
	private static ISymptomWriter wsdf = new WriteSymptomDataToFile(WriteSymptomDataToFile.getResultOut());
	

	public static ISymptomReader getRsdf() {
		return rsdf;
	}
	public static void setRsdf(ISymptomReader rsdf) {
		AnalyticsCounter.rsdf = rsdf;
	}
	
	public static ISymptomWriter getWsdf() {
		return wsdf;
	}
	public static void setWsdf(ISymptomWriter wsdf) {
		AnalyticsCounter.wsdf = wsdf;
	}
	
	public static void getResultOut() {
		return;	
	}
	
	public static void getFile() {
		return;	
	}

	
	
	/**
	 * Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	 * @param args
	 */
	public static void main(String args[]) throws IOException {
		
	
		wsdf.writeSymptoms(wsdf.countAndSort(rsdf.getSymptoms()));
		
		
	}
	
	
}
