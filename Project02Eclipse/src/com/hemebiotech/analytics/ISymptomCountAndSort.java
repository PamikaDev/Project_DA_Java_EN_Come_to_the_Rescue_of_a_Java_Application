package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * An interface that defines the behavior of the class
 * CountAndSortSymptomDataFromFile
 * 
 * @author WEB_DEV
 *
 */
public interface ISymptomCountAndSort {

	/**
	 * Counts and Sorts the specified Map in alphabetical order
	 * 
	 * @param symptomList -> Contains each line read
	 * @return a list of symptoms after counting and sorting.
	 * 
	 */
	Map<String, Integer> countAndSort(List<String> symptomList);
}
