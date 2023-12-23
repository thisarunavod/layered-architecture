package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.DAO.Custom.ItemDAO;
import com.example.layeredarchitecture.DAO.Custom.impl.ItemDAOimpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOimpl implements ItemBO{

    ItemDAO itemDAO = new ItemDAOimpl();
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save( dto);
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    @Override
    public boolean getExist(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.getExist(code);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.find(code);
    }
}
