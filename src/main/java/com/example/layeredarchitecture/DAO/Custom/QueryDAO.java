package com.example.layeredarchitecture.DAO.Custom;

import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {

    ArrayList<CustomDTO> getCustomerOrderCount() throws SQLException, ClassNotFoundException;




}
