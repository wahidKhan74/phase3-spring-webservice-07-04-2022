package com.simplilearn.webservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.simplilearn.webservice.contoller.HomeController;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@DisplayName("Application Test : Main Test")
class WebserviceApplicationTests {

	@Autowired
	private HomeController controller;
	
	@LocalServerPort
	private int randomPort;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	@DisplayName("Test : Load Application Context")
	void contextLoads() {		
		assertNotNull(controller);
	}

	@Test
	@DisplayName("Test : Server Running Test")
	void testForRunningServer() {
		String url = "http://localhost:"+randomPort+"/";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		String expected = "Welcome, to spring boot developement, Server is up and running !";
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(expected, response.getBody());
	}
	
	@Test
	@DisplayName("Test : Hello Server")
	void testHelloServer() {
		String url = "http://localhost:"+randomPort+"/hello";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		String expected = "Hello, everyone ! welcome to Webservice learning !";
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(expected, response.getBody());
	}
}
