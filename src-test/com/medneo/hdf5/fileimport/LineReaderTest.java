package com.medneo.hdf5.fileimport;

import static org.junit.Assert.*;
//import org.hamcrest.internal.;

import java.io.StringReader;
import java.util.Map;

import org.junit.Test;

public class LineReaderTest {

	
	
	
	/**
	 * just to setup testing ...
	 * */
	@Test
	public void shouldBehaveLikeDefined() {
		final String input = "0002,0002 Media Storage SOP Class UID #1 = 1.2.840.10008.5.1.4.1.1.4";
		final Map.Entry<Key, Value> expected = new Map.Entry<Key, Value>() {
			
			@Override
			public Value setValue(Value value) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Value getValue() {
				// TODO Auto-generated method stub
				return new Value(" 1.2.840.10008.5.1.4.1.1.4");
			}
			
			@Override
			public Key getKey() {
				// TODO Auto-generated method stub
				return new Key("0002,0002 Media Storage SOP Class UID #1 ");
			}
		};
		final Map.Entry<Key, Value> actual = new LineReaderImpl().readLine(new StringReader(input));
		assertEquals("keys should match", actual.getKey().name, expected.getKey().name);
		assertEquals("values should match", actual.getValue().value, expected.getValue().value);
	}

}
