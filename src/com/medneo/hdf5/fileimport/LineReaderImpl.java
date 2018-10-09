/**
 * 
 */
package com.medneo.hdf5.fileimport;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author dassbj01
 *
 */
public class LineReaderImpl implements LineReader {

	/* (non-Javadoc)
	 * @see com.medneo.hdf5.fileimport.LineReader#readLine(java.io.Reader)
	 */
	@Override
	public Entry<Key, Value> readLine(Reader toReadFrom) {
		CharBuffer buf = CharBuffer.allocate(1000);
				
		try {
			toReadFrom.read(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		String content = new String("");
		int indexOfEquals = content.lastIndexOf("=");
		String potentialKey = content.substring(0, indexOfEquals);
		String potentialVal = content.substring(indexOfEquals);
		return new Map.Entry<Key, Value>() {

			@Override
			public Key getKey() {
				// TODO Auto-generated method stub
				return new Key(potentialKey);
			}

			@Override
			public Value getValue() {
				// TODO Auto-generated method stub
				return new Value(potentialVal);
			}

			@Override
			public Value setValue(Value value) {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}

}
