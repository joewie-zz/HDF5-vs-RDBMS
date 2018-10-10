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
	
	public static final Entry<Key, Value> split(String s){
		int indexOfEquals = s.lastIndexOf("=");
		if(indexOfEquals == -1){
			// atm simply returning null
			return null;
		}
		String potentialKey = s.substring(0, indexOfEquals);
		String potentialVal = s.substring(indexOfEquals + 1);
		return new Map.Entry<Key, Value>() {

			private Value v = new Value(potentialVal);
			private final Key key = new Key(potentialKey);
			@Override
			public Key getKey() {
				return key;
			}

			@Override
			public Value getValue() {
				return v;
			}

			@Override
			public Value setValue(Value value) {
				Value r = v;
				v = value;
				return r;
			}
			
		};
		
	}

	/* (non-Javadoc)
	 * @see com.medneo.hdf5.fileimport.LineReader#readLine(java.io.Reader)
	 */
	@Override
	public Entry<Key, Value> readLine(Reader toReadFrom) {
		CharBuffer buf = CharBuffer.allocate(1000);
				
		try {
			while(toReadFrom.read(buf) > -1){}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		buf.flip();
		String content = buf.toString();
		return split(content);
	}

}
