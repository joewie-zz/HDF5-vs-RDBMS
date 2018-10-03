/**
 * 
 */
package com.medneo.hdf5.fileimport;

import java.io.Reader;
import java.util.Map;

/**
 * @author dassbj01
 *
 */
public interface LineReader {

	
	public Map.Entry<Key, Value> readLine(final Reader toReadFrom);
	
}
