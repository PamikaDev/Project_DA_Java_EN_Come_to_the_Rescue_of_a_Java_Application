package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, 
 * 
 */
public interface ISymptomReader {
	
	//Map<String, Integer> Symptoms () throws IOException;
	
	/**An object that maps keys to values. 
	 * 
	 * A map cannot contain duplicate keys;
	 * each key can map to at most one value.  
	 * 
	 * The Map interface provides three collection views, which allow a 
	 * map's contents to be viewed as a set of keys, collection of values,
	 * or set of key-value mappings. 
	 * 
	 * The order of a map is defined as the order in which the iterators 
	 * on the map's collection views return their elements. 
	 * 
	 * Some map implementations, like the TreeMap class, make specific 
	 * guarantees as to their order; others, like the HashMapclass, 
	 * do not.*/ 
	
	List<String> GetSymptoms () throws IOException;

//	Map<String, Integer> Symptoms() throws IOException;
	
//	void Symptoms () throws IOException;
}
