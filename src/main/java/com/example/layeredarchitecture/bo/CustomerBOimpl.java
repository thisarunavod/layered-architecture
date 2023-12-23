package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.DAO.Custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.Custom.impl.CustomerDAOimpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOimpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOimpl();


    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(dto);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return  customerDAO.getAll();
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    @Override
    public boolean getExist(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.getExist(id);
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    @Override
    public void generateNewID() throws SQLException, ClassNotFoundException {
        customerDAO.generateNewID();
    }


}
