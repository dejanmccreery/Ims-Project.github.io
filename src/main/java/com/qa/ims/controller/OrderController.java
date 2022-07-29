package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderDetailsDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderDetails;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private Utils utils;
    private ItemDAO itemDAO;
    private CustomerDAO customerDAO;

    public OrderController(OrderDAO orderDAO, OrderDetailsDAO orderDetailsDAO, Utils utils, ItemDAO itemDAO, CustomerDAO customerDAO) {
        super();
        this.orderDAO = orderDAO;
        this.orderDetailsDAO = orderDetailsDAO;
        this.utils = utils;
        this.itemDAO = itemDAO;
        this.customerDAO = customerDAO;
    }


    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order: orders) {

            Long orderID = order.getId();
            List<OrderDetails> orderDetailsList = orderDetailsDAO.readAll(orderID); //Get all items from order

            Long customerID = order.getCustomerID();
            Customer customer = customerDAO.read(customerID); //Get the customer related to the order

            String firstName = customer.getFirstName(); //customer info
            String surName = customer.getSurname(); 
            LOGGER.info("Order ID: " + orderID + "   " + firstName + "   " + surName); //printing TODO: create stringbuilder after testing

            double totalcost = 0; //assign new variable to 0
            for (OrderDetails orderDetails: orderDetailsList) { //loop through orderdetails list 
                Long quantity = orderDetails.getQuantity(); //get item quantity
                Long itemID = orderDetails.getItemID(); //get item ID
                Item item = itemDAO.read(itemID); //Using itemID to get Item class
                String desc = item.getDescription(); //adding description
                Double price = item.getPrice(); //get price from Item
                totalcost = totalcost + (price * quantity); // calculate cost and add to totalcost
                String itemName = item.getItemname(); //get item name
                LOGGER.info("Item: " + itemName + "   " + "Price: " + price + "   " + "Description: " + desc + "   " 
                + "Quantity: " + quantity.intValue() + "   " + "Subtotal: " + (price * quantity)); //printing -- Stringbuilder after testing
            }   


            LOGGER.info("The total price of this order is: " + totalcost); //print total cost
        }
        return orders;
    }

    @Override
    public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long customerID = utils.getLong();
		Order order = orderDAO.create(new Order(customerID));
		LOGGER.info("Order created");
		return order;
    }

    @Override
    public int delete() {

        LOGGER.info("Please choose a delete option:\n To delete a specific item from an order press 1\n To delete an entire order press 2\n");
        String choice = utils.getString().toUpperCase();
       

        switch (choice) {
			case "1":
                LOGGER.info("Please enter the order ID");
                Long id = utils.getLong();
                LOGGER.info("Please enter the item ID");
                Long itemID = utils.getLong();
                orderDetailsDAO.delete(id, itemID);
                return 0;
			case "2":
                LOGGER.info("Please enter the order ID you wish to delete");
                Long orderid = utils.getLong();
                orderDetailsDAO.deleteall(orderid);
                orderDAO.delete(orderid);
                LOGGER.info("Order deleted!");
                return 0;
			case "RETURN":
				break;
			default:
				break;
			}
        return 0;
		

    }

   
    public OrderDetails deleteitemfromorder() {
        LOGGER.info("Please enter the order ID");
        Long id = utils.getLong();
        LOGGER.info("Please enter the item ID");
        Long itemID = utils.getLong();
        return orderDetailsDAO.delete(id, itemID);

    }

    public Order update() {


        LOGGER.info("Please enter the order ID you wish to update");
        Long orderID = utils.getLong();
        LOGGER.info("Please enter an item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a Quantity");
		Long quantity = utils.getLong();

    
        Order order = orderDAO.read(orderID);
        OrderDetails orderdetails = orderDetailsDAO.create(new OrderDetails(orderID, itemId, quantity));
        if (orderdetails != null) {
            LOGGER.info("You've updated the order!" + orderdetails); //stopping the print when an incorrect item order ID is entered
        }
        


        return order;
    }
}
