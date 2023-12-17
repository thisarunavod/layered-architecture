package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {


    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

    boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean upateItems(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    boolean deleteItems(String code) throws SQLException, ClassNotFoundException ;

    boolean getExitItem(String code) throws SQLException, ClassNotFoundException ;

    String generateNewItemCode() throws SQLException, ClassNotFoundException ;

    ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
