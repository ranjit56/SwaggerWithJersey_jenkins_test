package com.Swagger.Jersey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwaggerWithJerseyExApplicationTests {

	public final static Logger logger = LoggerFactory.getLogger(SwaggerWithJerseyExApplicationTests.class);
	
	@Test
	void contextLoads() {
		logger.info("test Integtation");
		assertEquals(true, true);
	}


}
