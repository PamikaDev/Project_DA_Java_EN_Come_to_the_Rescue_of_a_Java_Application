package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Transcribe a map in a file
 * 
 * @author WEB_DEV
 *
 */
public interface ISymptomWriter {

	/**
	 * @param symptomListOut: Object type Map<String, Integer>.
	 * @return a list of symptoms and its number of occurrences.
	 * 
	 */
	void writeSymptoms(Map<String, Integer> symptomListOut);
}
