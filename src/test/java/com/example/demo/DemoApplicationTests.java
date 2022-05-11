package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

/**
 * Simple spring boot test with a web environment which should listening on random port.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int localPort;

	@Test
	public void localPort() {
		// Should output random port but actually outputs the default of the Tomcat container
		Assertions.assertNotEquals(8080, localPort, "Tomcat is listening on default port which is not expected");
	}

}
