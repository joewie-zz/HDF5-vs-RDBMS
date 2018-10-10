/**
 * 
 */
package com.medneo.hdf5.fileimport;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

	
	private final Set<Patient> patients;
	
	public final String path; 
	
	public InputFileProcessor(final String pathToFile){
		this(pathToFile, new HashSet<>());
	}
	
	public InputFileProcessor(final String pathToFile, final Set<Patient> s){
		this.path = pathToFile;
		this.patients = s;
	}
	
	public Set<Patient> getPatient(){
		return patients;
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
	        StreamSupport.stream(data.values().spliterator(), true).forEach(System.out::println);;
		}
		// now switch back to not so fancy implementation styles ..
		final String ps = data.get(ACCEPTED_KEYS.PATIENT_SEX);
		//that looks weird ..as i really do not understand why date of birth is modeled as int ....
		int dob = Integer.parseInt(data.get(ACCEPTED_KEYS.PATIENT_BIRTH_DATE).trim());
		final Patient p = new Patient(data.get(ACCEPTED_KEYS.PATIENT_ID), dob, ps.trim().equals("F")?'f':'m', -1, -1.0d);
		
		
		System.out.println(p);
		this.patients.add(p);
		// ... no idea where to put that to ...
		
		//final String exam
		
		/**
		 * no idea why the patient id is an int ...
		 * guess that looks like an auto increment column ... how should that get managed from a file / hdf .....
		 * */
		final Study s = new Study(data.get(ACCEPTED_KEYS.STUDY_INSTANCE_ID), -1, -1, "TBD", "TBD", -1, "TBD");
		
	}
}
