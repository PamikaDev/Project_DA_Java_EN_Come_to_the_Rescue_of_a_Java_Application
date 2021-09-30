package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author
 *         <h1>Bounama LY</h1> AnalyticsCounter is main class of application
 *         
 *         Reads sideEffect data file grouping data by key and value. 
 *         Creates a file with out of results
 *         @throws IOException
 *         Invalid Argument IOException describe when this exception is thrown by the method
 */
public class AnalyticsCounter {

	private static String resultOut = "results.out";
	private static String file = "sideEffects.txt";

	/**
	 *
	 * @param args
	 */
	public static void main(String args[]) throws IOException {

		ArrayList<String> sideEffects = new ArrayList<>();
		
		ReadSideEffectDataFromFile rsdf = new ReadSideEffectDataFromFile(file);
		sideEffects = rsdf.readSideEffects(sideEffects);
		
		
		Map<String, Integer> sideEffectOccurence = new TreeMap<>();
		
		WriteSideEffectDataToFile wsdf = new WriteSideEffectDataToFile(resultOut);
		sideEffectOccurence = wsdf.writeSideEffects(sideEffects);
		
		WriteSideEffectDataToFile writeresults = new WriteSideEffectDataToFile(resultOut);
		((WriteSideEffectDataToFile) writeresults).writeResultsToFile(sideEffectOccurence);

	}
}
