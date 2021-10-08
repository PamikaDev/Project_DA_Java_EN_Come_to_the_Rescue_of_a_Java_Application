package com.hemebiotech.analytics;

import java.io.IOException;

/**
 * Reads the symptom data file, counts and sorts the data by key and value.
 * Transcribes the data in a created file.
 * 
 * @author WEB_DEV
 * 
 */
public class AnalyticsCounter {

	public void setRsdf(ISymptomReader rsdf) {
		this.rsdf = rsdf;
	}

	private ISymptomReader rsdf;

	private ISymptomWriter wsdf;

	private ISymptomCountAndSort csdf;

	public AnalyticsCounter(ISymptomReader reader, ISymptomCountAndSort countSort, ISymptomWriter writer) {
		this.rsdf = reader;
		this.csdf = countSort;
		this.wsdf = writer;
	}

	// Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
	public void analytics() {
		wsdf.writeSymptoms(csdf.countAndSort(rsdf.getSymptoms()));
	}

	/**
	 * @param args
	 * 
	 *             Instantiate an object of the AnalyticsCounte class, and call the
	 *             "analytics" method
	 * 
	 * @throws IOException Invalid Argument IOException describe when this exception
	 *                     is thrown by the method.
	 */
	public static void main(String args[]) throws IOException {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile(),
				new CountAndSortSymptomDataFromFile(), new WriteSymptomDataToFile());
		analyticsCounter.analytics();
		


	}
}
