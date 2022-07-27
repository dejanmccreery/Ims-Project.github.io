package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderDetailsDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderDetails;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private Utils utils;

    public OrderController(OrderDAO orderDAO, OrderDetailsDAO orderDetailsDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.orderDetailsDAO = orderDetailsDAO;
        this.utils = utils;
    }


    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order: orders) {
            List<OrderDetails> items = orderDetailsDAO.readAll(order.getId());
            order.setItems(items);
            LOGGER.info(order);
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
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);

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
        LOGGER.info(orderdetails);
        LOGGER.info(order);

        return order;
    }
}
