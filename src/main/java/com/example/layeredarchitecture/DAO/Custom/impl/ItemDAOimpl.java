package com.example.layeredarchitecture.DAO.Custom.impl;

import com.example.layeredarchitecture.DAO.Custom.ItemDAO;
import com.example.layeredarchitecture.DAO.SQLutil;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOimpl implements ItemDAO {


    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO> ItemDtoList = new ArrayList<>();
        while (rst.next()){
            ItemDtoList.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(4),
                    rst.getBigDecimal(3)
            ));
        }
        return ItemDtoList ;
*/
        ArrayList<ItemDTO> ItemDtoList = new ArrayList<>();
        ResultSet rst = SQLutil.execute("SELECT * FROM Item" );
        while (rst.next()){
            ItemDtoList.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getBigDecimal(4)
            ));
        }
        return ItemDtoList ;

    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        /*
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());
        return  pstm.executeUpdate() > 0;*/
        return SQLutil.execute(
                "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2, dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());
        return  pstm.executeUpdate() > 0 ;*/
        return SQLutil.execute(
                "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand(),
                dto.getCode()
        );
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        return  pstm.executeUpdate() > 0 ;  */
        return SQLutil.execute(
                "DELETE FROM Item WHERE code=?",
                code
        );
    }

    @Override
    public boolean getExist(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();*/

        ResultSet rst = SQLutil.execute(
                "SELECT code FROM Item WHERE code=?",
                code
        );
        return rst.next();
    }


    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

       /* Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }*/

        ResultSet rst = SQLutil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }


    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()){
            return new ItemDTO(rst.getString(1), rst.getString(2),rst.getInt(3),rst.getBigDecimal(4));
        }
        return null;
*/
        ResultSet rst = SQLutil.execute(
                "SELECT * FROM Item WHERE code=?",
                code
        );
        if (rst.next()){ return new ItemDTO(rst.getString(1), rst.getString(2),rst.getInt(3),rst.getBigDecimal(4)); }
        return null;

    }



}
