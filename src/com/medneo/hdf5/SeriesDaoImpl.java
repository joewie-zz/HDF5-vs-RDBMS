package com.medneo.hdf5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jonathan on 09 Sep, 2018
 */
public class SeriesDaoImpl implements SeriesDao {

    Connection connection = DBConnection.getConnection();

    @Override
    public boolean insertSeries(Series series) {

        try{
            //TODO
            //insert statement
            String sql = "";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

        }
        catch(SQLException se){
            se.printStackTrace();
        }

        return false;
    }
}