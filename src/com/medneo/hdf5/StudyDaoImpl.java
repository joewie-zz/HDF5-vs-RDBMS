package com.medneo.hdf5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jonathan on 09 Sep, 2018
 */
public class StudyDaoImpl implements StudyDao {

    Connection connection = DBConnection.getConnection();

    @Override
    public boolean insertStudy(Study study) {

        try{
            String sql = "INSERT INTO study VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, study.getStudyInstanceUid());
            preparedStatement.setInt(3, study.getStudyDate());
            preparedStatement.setInt(4, study.getStudyTime());
            preparedStatement.setString(5, study.getStudyDescription());
            preparedStatement.setString(6, study.getBodyPartExamined());
            preparedStatement.setInt(7, study.getPatientID());
            preparedStatement.setString(8, study.getPatientIdDiag());

            preparedStatement.executeUpdate();

        }
        catch (SQLException se){
            se.printStackTrace();
        }

        return false;
    }
}