package com.example.layeredarchitecture.DAO.Custom.impl;

import com.example.layeredarchitecture.DAO.Custom.QueryDAO;
import com.example.layeredarchitecture.DAO.SQLutil;
import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOimpl implements QueryDAO {


    @Override
    public ArrayList<CustomDTO> getCustomerOrderCount() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLutil.execute("SELECT  Orders.customerID ,Customer.name , COUNT(Orders.customerID) FROM Orders JOIN Customer ON Orders.customerID = Customer.id group by Orders.customerID");

        while(rst.next()){

        }
        return null;
    }
}
