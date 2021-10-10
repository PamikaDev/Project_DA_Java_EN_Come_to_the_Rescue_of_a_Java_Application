package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Reads the file line by line, then uses the following filter. if the value of
 * the row contains the "symptom" property of an element object in the list,
 * then, we increment the value of its "occurrence" property otherwise, we
 * create an object for the new symptom and initialize its occurrence value to 1
 * and insert it into the list
 * 
 */
public class CountAndSortSymptomDataFromFile implements ISymptomCountAndSort {
	public CountAndSortSymptomDataFromFile() {
	}

	/**
	 * @param symptomList : Map to countAndSort
	 * @return symptCountAndSort: sorted Map
	 * 
	 */
	@Override
	public Map<String, Integer> countAndSort(List<String> symptomList) {
		Map<String, Integer> symptCountAndSort = new TreeMap<>();

		try {
			for (String symptom : symptomList) {

				if (symptCountAndSort.containsKey(symptom)) {
					symptCountAndSort.put(symptom, symptCountAndSort.get(symptom) + 1);
				} else {
					symptCountAndSort.put(symptom, 1);
				}
			}

			System.out.println("List of symptoms with their occurences: ");
			System.out.println("---------------------------------------");
			symptCountAndSort.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
					.forEachOrdered(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return symptCountAndSort;
	}
}