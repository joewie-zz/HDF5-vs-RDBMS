package com.medneo.hdf5;

public class Load {

    public static void main(String[] args){

        //loadPatient();
        loadStudy();

    }

    public static void loadPatient(){

        Patient patient = new Patient("ACE4450424023", 20140104, 'F', 62, 74.10);

        PatientDao patientDao = new PatientDaoImpl();
        patientDao.insertPatient(patient);

    }

    public static void loadStudy(){
        Study study = new Study("1.3.12.2.1107.5.2.19.145226.2017050215055250148237218", 20170502, 1450, "CERVICAL_THORACIC_SPINE^ROUTINE", "SPINE", 1, "AAA150424106");

        StudyDao studyDao = new StudyDaoImpl();
        studyDao.insertStudy(study);
    }


}