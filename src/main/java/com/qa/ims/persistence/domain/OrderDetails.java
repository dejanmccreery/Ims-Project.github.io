package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderDetails {

    private Long quantity;
    private Long itemID;
    private Long orderID;

    public OrderDetails() {

    }

    public OrderDetails(Long orderID, Long itemID, Long quantity) {
        super();
        this.setOrderID(orderID);
        this.setItemID(itemID);
        this.setQuantity(quantity);
    }

    public OrderDetails(Long orderID, Long itemID) {
        super();
        this.orderID = orderID;
        this.itemID = itemID;
    }



    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " quantity='" + getQuantity() + "'" +
            ", itemID='" + getItemID() + "'" +
            ", orderID='" + getOrderID() + "'" +
            "}";
    }

    public Long getItemID() {
        return this.itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getOrderID() {
        return this.orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderDetails)) {
            return false;
        }
        OrderDetails orderDetails = (OrderDetails) o;
        return Objects.equals(quantity, orderDetails.quantity) && Objects.equals(itemID, orderDetails.itemID) && Objects.equals(orderID, orderDetails.orderID);
    }

}
