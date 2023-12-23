package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.DAO.CRUDDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CRUDDAO<OrderDTO> {

    /*boolean saveOrder(OrderDTO orderDto) throws SQLException, ClassNotFoundException;
    boolean existOrderID(String orderId) throws SQLException, ClassNotFoundException;
    String getNewID() throws SQLException, ClassNotFoundException;  */

}
