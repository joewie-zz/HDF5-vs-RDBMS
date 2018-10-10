/**
 * 
 */
package com.medneo.hdf5.fileimport;

/**
 * @author dassbj01
 *
 */
public enum ACCEPTED_KEYS {
	
	PATIENT_ID("0010,0020 Patient ID #1"),
	PATIENT_SEX("0010,0040 Patient's Sex #1"),
	PATIENT_BIRTH_DATE("0010,0030 Patient's Birth Date #1"),
	STUDY_INSTANCE_ID("0020,000d Study Instance UID #1")
	;

	public final String val;
	
	ACCEPTED_KEYS(final String val){
		this.val = val;
	}
	
	public static final boolean isKnowValue(final String toTest){
		final String trimmed = toTest.trim();
		for(ACCEPTED_KEYS a : ACCEPTED_KEYS.values()){
			if(a.val.equals(trimmed)){
				return true;
			}
		} 
		return false;
	}
	
	public static final ACCEPTED_KEYS getForValue(final String val){
		final String trimmed = val.trim();
		for(ACCEPTED_KEYS a : ACCEPTED_KEYS.values()){
			if(a.val.equals(trimmed)){
				return a;
			}
		} 
		return null;
	}
	
}
