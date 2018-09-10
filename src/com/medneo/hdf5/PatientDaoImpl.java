package com.medneo.hdf5;
/**
 * Created by Jonathan on 09 Sep, 2018
 */
import java.sql.*;
import java.util.Set;

public class PatientDaoImpl implements PatientDao {

    //lets connect to database
    Connection connection = DBConnection.getConnection();

/*    @Override
    public Patient getPatient(int patientId) {

        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Employees WHERE id=" + patientId;
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                Patient patient = new Patient();

                patient.setPatientId(resultSet.getInt("id"));
                patient.setAge(resultSet.getInt("age"));
                //patient.set

                return  patient;
            }
        }
        catch (SQLException se){
            se.printStackTrace();
        }

        return null;
    }*/

    @Override
    public boolean insertPatient(Patient patient) {
        try{
            String sql = "INSERT INTO patient VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, patient.getPatientIdDiag());
            preparedStatement.setInt(3, patient.getDob());
            preparedStatement.setString(4, String.valueOf(patient.getSex()));
            preparedStatement.setInt(5, patient.getAge());
            preparedStatement.setDouble(6, patient.getWeight());

            int noOfRows = preparedStatement.executeUpdate();

            if(noOfRows == 1){
                //return true;
                System.out.println("Query executed successfully");
            }

        }
        catch (SQLException se){
            se.printStackTrace();
        }

        return false;
    }


}