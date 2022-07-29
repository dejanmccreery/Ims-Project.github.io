package com.qa.ims.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
    private final ItemDAO DAO = new ItemDAO();


    @BeforeEach
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }
    
    @Test
	public void testCreate() {
		final Item created = new Item(2L, "teddy", "fatbear", 10.0, 10);
		assertEquals(created, DAO.create(created));
	}
}
