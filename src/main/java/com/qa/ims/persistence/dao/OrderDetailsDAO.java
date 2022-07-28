package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.DBUtils;
import com.qa.ims.persistence.domain.OrderDetails;



public class OrderDetailsDAO implements Dao<OrderDetails> {

    private static final Logger LOGGER = LogManager.getLogger();



    public List<OrderDetails> readAll(Long orderID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM OrderDetails WHERE fk_order_id = ?");) {
			statement.setLong(1, orderID);
			try (ResultSet resultSet = statement.executeQuery();) {
				List<OrderDetails> OrderDetails = new ArrayList<>();
				while (resultSet.next()) {
					OrderDetails.add(modelFromResultSet(resultSet));
				}
				return OrderDetails;
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
    }



    public OrderDetails delete(Long orderID, Long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM OrderDetails WHERE fk_order_id = ? AND fk_item_id = ?");) {
    statement.setLong(1, orderID);
    statement.setLong(2, itemID);
    statement.executeUpdate();
} catch (Exception e) {
    LOGGER.debug(e);
    LOGGER.error(e.getMessage());
}
        return null;
    }


    public OrderDetails deleteall(Long id) {
    try (Connection connection = DBUtils.getInstance().getConnection();
    PreparedStatement statement = connection.prepareStatement("DELETE FROM OrderDetails WHERE fk_order_id = ?");) {
    statement.setLong(1, id);
    statement.executeUpdate();
} catch (Exception e) {
    LOGGER.debug(e);
    LOGGER.error(e.getMessage());
}
    return null;
}



    public OrderDetails modelFromResultSet(ResultSet resultSet) throws SQLException {
   Long id = resultSet.getLong("fk_order_id");
   Long itemID = resultSet.getLong("fk_item_id");
   Long quantity = resultSet.getLong("quantity");
   return new OrderDetails(id, itemID, quantity);

    }


    @Override
    public OrderDetails update(OrderDetails t) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public List<OrderDetails> readAll() {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public OrderDetails create(OrderDetails orderdetails) {
        try (Connection connection = DBUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO orderdetails (fk_order_id, fk_item_id, quantity) VALUES (?, ?, ?)");) {
    statement.setLong(1, orderdetails.getOrderID());
    statement.setLong(2, orderdetails.getItemID());
    statement.setLong(3, orderdetails.getQuantity());
    statement.executeUpdate();
    return read(orderdetails.getOrderID());
} catch (Exception e) {
    LOGGER.debug(e);
    LOGGER.error(e.getMessage());
}
        return null;
    }
    

    @Override
    public OrderDetails read(Long id) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public int delete(long id) {
        // TODO Auto-generated method stub
        return 0;
    }


}
