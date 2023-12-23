package com.example.layeredarchitecture.model;


public class CustomDTO {

    private String CustomerID;
    private String CustomerName;
    private int orderCount;

    public CustomDTO(String customerID, String customerName, int orderCount){
        CustomerID = customerID;
        CustomerName = customerName;
        this.orderCount = orderCount;
    }


    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
