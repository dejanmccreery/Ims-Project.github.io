package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

    private Long id;
    private Long quantity;
    private Long itemID;
    private long customerID;

    public Order(Long customerID, Long itemID, Long quantity) {
        this.customerID = customerID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public Order(Long id, Long customerID, Long itemID, Long quantity) {
        this.id = id;
        this.customerID = customerID;
        this.itemID = itemID;
        this.quantity = quantity;
    }

    public Order (Long id, Long customerID) {
        this.id = id;
        this.customerID = customerID;
    }


    public Order(Long customerID) {
        this.customerID = customerID;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getItemID() {
        return this.itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public long getCustomerID() {
        return this.customerID;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customerID='" + getCustomerID() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(quantity, order.quantity) && Objects.equals(itemID, order.itemID) && customerID == order.customerID;
    }

}
