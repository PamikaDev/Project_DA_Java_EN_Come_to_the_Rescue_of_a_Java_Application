package com.hemebiotech.analytics;

/**
 * Process -> file > getSymptoms > countAndSort > writeSymptoms > resultOut
 * @author WEB_DEV
 * 
 */
public class AnalyticsCounter {
	//ATTRIBUTS
	private ISymptomReader rsdf;
	private ISymptomWriter wsdf;
	private ISymptomCountAndSort csdf;
	//CONSTRUCTORS
	public AnalyticsCounter(ISymptomReader rsdf, ISymptomCountAndSort csdf, ISymptomWriter wsdf) {
		this.rsdf = rsdf; this.csdf = csdf; this.wsdf = wsdf;
	}
	//METHOD
	public void analytics() {
		wsdf.writeSymptoms(csdf.countAndSort(rsdf.getSymptoms()));
	}
	
	/**
	 * @param args
	 * 
	 *             Instantiate an object of the AnalyticsCounte class, and call the
	 *             "analytics" method
	 * 
	 *                     
	 */
	public static void main(String args[]) {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile(),
				new CountAndSortSymptomDataFromFile(), new WriteSymptomDataToFile());
		analyticsCounter.analytics();
	}
}
