
use loadtestdb;

CREATE TABLE patient (
  /*
  0010,0020 Patient ID #1
  */
  patient_id varchar(32) NOT NULL,
  /*
  0010,0030 Patient's Birth Date #1
  */
  birthDate date NOT NULL,
  /*
  0010,0040 Patient's Sex #1
  */
  sex char(1) NOT NULL,
  /*
  0010,1020 Patient's Size #1
  please check if that is mandatory ... if so it can become NOT NULL
  */
  size decimal(2,2),
  /*
  0010,1030 Patient's Weight #1
  ==> datatype is questionable ... maybe decimal(4,4) would fit better
  please check if that is mandatory ... if so it can become NOT NULL
  */
  weight int,
  CONSTRAINT PATIENT_PK PRIMARY KEY (patient_id)
);

CREATE TABLE examination (
  /*
  0020,000d Study Instance UID #1
  */
  examination_id varchar(500) NOT NULL,
  /*
  0008,0020 Study Date #1 = 20170502
  0008,0030 Study Time #1 = 1450
  */
  examination_date timestamp NOT NULL,
  patient_id varchar(32) NOT NULL,
  CONSTRAINT EXAMIMATION_PK PRIMARY KEY (examination_id),
  CONSTRAINT exam2patient FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);

CREATE TABLE image(
  image_id SERIAL,
/*
* mysql is just offering one type to store binary data of arbitary size...  
*/
  image_data blob,
  examination_id varchar(500) NOT NULL,
  CONSTRAINT IMAGE_PK PRIMARY KEY (image_id),
  CONSTRAINT image2exam FOREIGN KEY (examination_id) REFERENCES examination(examination_id)
);
