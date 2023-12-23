package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderDetailsDAO {

  boolean saveOrderDeatails(String OrderID, OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
