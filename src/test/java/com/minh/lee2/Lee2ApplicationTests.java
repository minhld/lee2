package com.minh.lee2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Lee2ApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void loadsOrderSeedData() {
		assertThat(countRows("customers")).isEqualTo(3);
		assertThat(countRows("items")).isEqualTo(5);
		assertThat(countRows("customer_orders")).isEqualTo(4);
		assertThat(countRows("order_items")).isEqualTo(10);
	}

	private Integer countRows(String tableName) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName, Integer.class);
	}

}
