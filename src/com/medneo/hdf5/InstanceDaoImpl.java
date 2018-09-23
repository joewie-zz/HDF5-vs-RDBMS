package com.medneo.hdf5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jonathan on 23 Sep, 2018
 */
public class InstanceDaoImpl implements InstanceDao {

    Connection connection = DBConnection.getConnection();

    @Override
    public boolean insertInstance(Instance instance) {
        try{
            String sql = "INSERT INTO study VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, instance.getSop_class_uid());
            preparedStatement.setString(3, instance.getSop_instance_uid());
            preparedStatement.setInt(4, instance.getInstance_creation_date());
            preparedStatement.setInt(5, instance.getInstance_creation_time());
            preparedStatement.setString(6, instance.getSeries_instance_uid());
            preparedStatement.setString(7, instance.getStudy_instance_uid());
            preparedStatement.setInt(8, instance.getInstance_number());
            preparedStatement.setInt(9, instance.getImage_id());
            preparedStatement.setInt(10, instance.getSeries_id());
            preparedStatement.setInt(11, instance.getStudy_id());

            preparedStatement.executeUpdate();

        }
        catch(SQLException se){
            se.printStackTrace();
        }

        return false;
    }


}