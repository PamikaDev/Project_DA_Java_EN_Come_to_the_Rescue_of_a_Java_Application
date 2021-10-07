package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomWriter {

	/**
	 * 
	 * Counts and sorts the data
	 * 
	 * @param symptomList -> Contains each line read
	 * @return a list of symptoms after counting and sorting.
	 */
	Map<String, Integer> countAndSort(List<String> symptomList);

	/**
	 * 
	 * @param symptomListOut: Object type Map<String, Integer>.
	 * @return a list of symptoms and its number of occurrences. Transcribe a map in
	 *         a file
	 */
	void writeSymptoms(Map<String, Integer> symptomListOut);
}
