package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WriteSideEffectDataToFile implements ISideEffectWriter {

	/**
	 * counts and regroups the data in results.out trough the TreeMap (k-v)
	 * 
	 * @param results.out"        -> the file to create
	 * @param sideEffects          -> Contains each line read
	 * @param sideEffectOccurence: Object type Map<String, Integer>. 
	 *                             parameters String -> key = ( sideEffect) 
	 *                            parameters Integer -> value = ( occurence )
	 * @return a list of sideEffects and its number of occurrences.
	 *
	 */
	@Override
	public Map<String, Integer> writeSideEffects(ArrayList<String> sideEffects) {

		// I use TreeMap to order the sideEffect list by Keys in ascending Order
		TreeMap<String, Integer> sideEffectOccurence = new TreeMap<>();
		
		// I check if the sideEffect exists in the file and we count its number of occurrences
		for (String sideEffect : sideEffects) {
			Integer occurence = sideEffectOccurence.getOrDefault(sideEffect, 0);
			sideEffectOccurence.put(sideEffect, occurence + 1);
		}

		// Write the sideEffect list to file out
		try {
			FileWriter writer = new FileWriter("results.out");

			try (BufferedWriter out = new BufferedWriter(writer)) {
				for (Entry<String, Integer> sideEffect : sideEffectOccurence.entrySet()) {
					
					// Order the list, line by line on the console by comparing the keys
					sideEffectOccurence.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey())
							.forEachOrdered(System.out::println);
					
					// File.out
					out.write(sideEffect.getKey() + " = " + sideEffect.getValue() + " \n");
					out.flush(); // Force write	
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (Exception e1) {
			System.out.println("File writing problem: " + e1.getMessage());
		}

		return sideEffectOccurence;	
	}

	public void writeResultsToFile(Map<String, Integer> sideEffectOccurence) {
		return;
	}
	public Map<String, Integer> writeSideEffects() {
		return writeSideEffects();
	}
	public WriteSideEffectDataToFile(String resultOut) {
		resultOut = "results.out";
	}


}
