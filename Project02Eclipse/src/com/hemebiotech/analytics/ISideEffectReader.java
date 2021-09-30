package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Anything that will read sideEffect data from a source. The important part is,
 * the return value from the operation, which is a list of strings, that may
 * contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISideEffectReader {

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all sideEffectS obtained from a data source,
	 *         duplicates are possible/probable
	 */
	public ArrayList<String> readSideEffects(List<String> sideEffects) throws IOException; 
	//List<String> readSideEffects(List<String> sideEffects) throws IOException;

}
