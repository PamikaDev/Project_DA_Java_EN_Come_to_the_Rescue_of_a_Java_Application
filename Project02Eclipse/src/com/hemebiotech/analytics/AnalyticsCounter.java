package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) {

		try {
			File file = new File("symptoms.txt");
			try (Scanner scan = new Scanner(file)) {
				Map<String, Integer> wordCount = new TreeMap<>();
				while (scan.hasNext()) {
					String word = scan.nextLine();
					if (wordCount.containsKey(word)) {

						wordCount.put(word, wordCount.get(word) + 1);

					} else {
						wordCount.put(word, 1);
					}
				}

				// Result in console & Write file output
				FileWriter writer = new FileWriter("results.out");
				try (BufferedWriter out = new BufferedWriter(writer)) {
					for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						out.write(entry.getKey() + " = " + entry.getValue() + " \n");
						out.flush(); // Force write
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Fichier introuvable");
		}

	}
}