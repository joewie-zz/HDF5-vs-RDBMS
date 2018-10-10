package com.medneo.hdf5;

/**
 * Created by Jonathan on 09 Sep, 2018
 */
public class Patient {

    private String patientIdDiag;
    private int dob;    //could be changed to Date type
    private char sex;
    private int age;
    private double weight;

    public Patient(String patientIdDiag, int dob, char sex, int age, double weight) {
        this.patientIdDiag = patientIdDiag;
        this.dob = dob;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
    }

    public String getPatientIdDiag() {
        return patientIdDiag;
    }

    public void setPatientIdDiag(String patientIdDiag) {
        this.patientIdDiag = patientIdDiag;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

	@Override
	public String toString() {
		return "Patient [patientIdDiag=" + patientIdDiag + ", dob=" + dob + ", sex=" + sex + ", age=" + age
				+ ", weight=" + weight + "]";
	}
}
