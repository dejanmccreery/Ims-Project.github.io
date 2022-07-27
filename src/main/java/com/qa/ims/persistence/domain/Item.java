package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

    private Long id;
    private String itemname;
    private String description;
    private Double price;
    private Double stock;


    public Item(String itemname, String description, Double price, Double stock) {
        this.setItemname(itemname);
        this.setDescription(description);
        this.setPrice(price);
        this.setStock(stock);
    }

    public Item(Long id, String itemname, String description) {
        this.setId(id);
        this.setItemname(itemname);
        this.setDescription(description);
    }

    public Item(Long id, String itemname, String description, Double price, Double stock) {
        this.id = id;
        this.itemname = itemname;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Item(Long id, String itemname, String description, Double price, double stock) {
        this.id = id;
        this.itemname = itemname;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemname() {
        return this.itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock() {
        return this.stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item items = (Item) o;
        return Objects.equals(id, items.id) && Objects.equals(itemname, items.itemname) && Objects.equals(description, items.description) && Objects.equals(price, items.price) && Objects.equals(stock, items.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemname, description, price, stock);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", itemname='" + getItemname() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }
    
    }
    

