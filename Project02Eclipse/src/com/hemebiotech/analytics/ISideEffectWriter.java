package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface ISideEffectWriter {

	/**
	 * 
	 * @param sideEffects          -> Contains each line read
	 * @return a list of sideEffects and its number of occurrences.
	 *
	 */
	Map<String, Integer> writeSideEffects(ArrayList<String> sideEffects) throws IOException;
	
	

}
