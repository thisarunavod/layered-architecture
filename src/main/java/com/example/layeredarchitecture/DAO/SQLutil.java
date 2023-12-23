package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLutil {

    public static <T>T execute(String sql , Object ... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);

        for (int i = 0; i < args.length ; i++) {
            pst.setObject(i+1, args[i]);
        }

        if (sql.startsWith("SELECT")){ return  (T) pst.executeQuery();}

        else{ return (T)(Boolean)(pst.executeUpdate() > 0) ;}

    }

}
