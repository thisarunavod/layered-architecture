package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    
     boolean getExistCustomer(String id) throws SQLException, ClassNotFoundException;
    
     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String generateNewCusID() throws SQLException, ClassNotFoundException;

     CustomerDTO findCustomer(String id) throws SQLException, ClassNotFoundException;
     
}
