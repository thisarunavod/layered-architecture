package com.example.layeredarchitecture.DAO.Custom.impl;

import com.example.layeredarchitecture.DAO.Custom.OrderDetailsDAO;
import com.example.layeredarchitecture.DAO.SQLutil;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    
    @Override
    public boolean saveOrderDeatails(String orderID , OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, orderID);
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());

        return stm.executeUpdate() > 0 ;  */
        return SQLutil.execute(
                "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                orderID,
                dto.getItemCode(),
                dto.getUnitPrice(),
                dto.getQty()
        );
    }
    
}
