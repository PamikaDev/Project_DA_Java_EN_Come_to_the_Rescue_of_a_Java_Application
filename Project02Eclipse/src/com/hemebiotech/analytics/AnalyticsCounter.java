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

	private ISymptomReader rsdf;

	private ISymptomWriter wsdf;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.rsdf = reader;
		this.wsdf = writer;	
	}
	
	//Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	public void analytics () {
		this.wsdf.writeSymptoms(this.wsdf.countAndSort(this.rsdf.getSymptoms()));
	}
	
	/**
	 * @param args
	 * 
	 * @throws IOException Invalid Argument IOException describe when this exception
	 *                     is thrown by the method.
	 */
	public static void main(String args[]) throws IOException {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile(), new WriteSymptomDataToFile());
		analyticsCounter.analytics();
	}
}
