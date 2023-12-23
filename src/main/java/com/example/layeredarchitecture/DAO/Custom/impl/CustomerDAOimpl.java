package com.example.layeredarchitecture.DAO.Custom.impl;

import com.example.layeredarchitecture.DAO.Custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.SQLutil;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {


    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {

       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());

        return pstm.executeUpdate() > 0 ;
*/
        return SQLutil.execute(
                "INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
                dto.getId(),
                dto.getName(),
                dto.getAddress()
        );

    }
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> customerDTOLIST = new ArrayList<>();

        while (rst.next()){
            customerDTOLIST.add( new CustomerDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3)
                    )
            );
        }
        return customerDTOLIST;*/
        ArrayList<CustomerDTO> customerDTOLIST = new ArrayList<>();
        ResultSet rst = SQLutil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            customerDTOLIST.add(new CustomerDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3)
                    )
            );
        }

        return customerDTOLIST;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {

      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET  name = ? , address = ? WHERE id = ?");
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getId());

        return pstm.executeUpdate() > 0 ;*/

        return SQLutil.execute(
                "UPDATE Customer SET  name = ? , address = ? WHERE id = ?",
                dto.getName(),
                dto.getAddress(),
                dto.getId()
        );

    }


    @Override
    public boolean getExist(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);

        return pstm.executeQuery().next();*/
        ResultSet rst = SQLutil.execute(
                "SELECT id FROM Customer WHERE id=?",
                id
        );
        return rst.next();

    }


    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return  pstm.executeUpdate() > 0 ;  */
        return SQLutil.execute(
                "DELETE FROM Customer WHERE id=?",
                id
        );

    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {

      /*  Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }  */

        ResultSet rst = SQLutil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

    }

    @Override
    public CustomerDTO find(String id) throws SQLException, ClassNotFoundException {

        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, id + "");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()){
            return  new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
        }

        return null; */

        ResultSet rst = SQLutil.execute(
                "SELECT * FROM Customer WHERE id=?",
                id
        );

        if (rst.next()){
            return  new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }



}
