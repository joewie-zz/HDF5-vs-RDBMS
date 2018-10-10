/**
 * 
 */
package com.medneo.hdf5.fileimport;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.medneo.hdf5.Patient;
import com.medneo.hdf5.Study;

/**
 * @author dassbj01
 *
 */
public class InputFileProcessor {

	
	public final String path; 
	
	public InputFileProcessor(final String pathToFile){
		this.path = pathToFile;
	}
	
	public void readFileContent() throws IOException{
		EnumMap<ACCEPTED_KEYS,String> data;
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
	        data = stream.map(LineReaderImpl::split)
	        		//some basic filtering to get rid of "non matching lines inside the files" 
	        		.filter(x -> x != null && ACCEPTED_KEYS.isKnowValue(x.getKey().name))
	        .collect(Collectors.toMap(
	        		x -> ACCEPTED_KEYS.getForValue(x.getKey().name), 
	        		x -> x.getValue().value,
	        		(l,r) -> { throw new IllegalArgumentException("no duplicates supported ... inside a file the key must be unique"); },
	        		() -> new EnumMap<>(ACCEPTED_KEYS.class)
	        		))
	        
	        		
	        ;
	        //StreamSupport.stream(data.values().spliterator(), true).forEach(System.out::println);;
		}
		// now switch back to not so fancy implementation styles ..
		final String ps = data.get(ACCEPTED_KEYS.PATIENT_SEX);
		//that looks weird ..as i really do not understand why date of birth is modeled as int ....
		int dob = Integer.parseInt(data.get(ACCEPTED_KEYS.PATIENT_BIRTH_DATE).trim());
		final Patient p = new Patient("not yet covered", -1, ps.trim().equals("F")?'f':'m', dob, -1.0d);
		
		// ... no idea where to put that to ...
		
		//final String exam
		
		/**
		 * no idea why the patient id is an int ...
		 * guess that looks like an auto increment column ... how should that get managed from a file / hdf .....
		 * */
		final Study s = new Study(data.get(ACCEPTED_KEYS.STUDY_INSTANCE_ID), -1, -1, "TBD", "TBD", -1, "TBD");
		
	}
}
