package com.hemebiotech.analytics;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Counts and sorts the list.
 * Then uses the following filter: if the value of the row contains the "symptom" 
 * property of an element object in the list,
 * then, we increment the value of its "occurrence" property otherwise, we
 * create an object for the new symptom and initialize its occurrence value to 1
 * and insert it into the list
 * 
 */
public class CountAndSortSymptomDataFromFile implements ISymptomCountAndSort {
	private static Instant startedAt;
	public CountAndSortSymptomDataFromFile() {
		initStartingTime();
		showTestDuration();
	}
	@BeforeAll
	static public void initStartingTime() {
		startedAt = Instant.now();
	}

	@AfterAll
	public static void showTestDuration() {
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée d'exécution CountAndSortSymptomDataFromFile: {0} ms", duration));
	}
	/**
	 * @param symptomList : Map to countAndSort
	 * @return symptCountAndSort: sorted Map
	 * 
	 */
	@Override
	public Map<String, Integer> countAndSort(List<String> symptomList) {
		Map<String, Integer> symptCountAndSort = new TreeMap<>();
		for (String symptom : symptomList) {
			if (symptCountAndSort.containsKey(symptom)) {
				symptCountAndSort.put(symptom, symptCountAndSort.get(symptom) + 1);
			} else {
				symptCountAndSort.put(symptom, 1);
			}
		}
		return symptCountAndSort;
	}
}