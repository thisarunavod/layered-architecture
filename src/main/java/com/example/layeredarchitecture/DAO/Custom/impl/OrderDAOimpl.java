package com.example.layeredarchitecture.DAO.Custom.impl;

import com.example.layeredarchitecture.DAO.Custom.OrderDAO;
import com.example.layeredarchitecture.DAO.SQLutil;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOimpl implements OrderDAO {

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO orderDto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderDto.getOrderId());
        stm.setDate(2, Date.valueOf(orderDto.getOrderDate()));
        stm.setString(3, orderDto.getCustomerId());
        return stm.executeUpdate() > 0 ;  */

        return SQLutil.execute(
                "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                orderDto.getOrderId(),
                Date.valueOf(orderDto.getOrderDate()),
                orderDto.getCustomerId()
        );

    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean getExist(String orderId) throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        return stm.executeQuery().next();  */
        ResultSet rst = SQLutil.execute(
                "SELECT oid FROM `Orders` WHERE oid=?",
                orderId
        );

        return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        if (rst.next()){ return rst.getString(1);}
        return null;  */
        ResultSet rst=  SQLutil.execute(
                "SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1"
        );
        if (rst.next()){ return rst.getString(1);}
        return null;

    }

    @Override
    public OrderDTO find(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
