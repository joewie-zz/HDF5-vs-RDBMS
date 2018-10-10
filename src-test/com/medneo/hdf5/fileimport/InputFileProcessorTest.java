package com.medneo.hdf5.fileimport;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

public class InputFileProcessorTest {

	
	
	@Test
	public void test() throws IOException {
		URL url = this.getClass().getResource("/0000.txt");
		
		InputFileProcessor t = new InputFileProcessor(url.getPath());
		t.readFileContent();
		
	}

}
