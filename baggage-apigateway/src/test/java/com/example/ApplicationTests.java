package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brownfield.pss.book.apigateway.BaggageApiGateway;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BaggageApiGateway.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

}