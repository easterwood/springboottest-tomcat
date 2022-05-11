package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Simple bean for test purposes. The bean needs the port Tomcat is listening on.
 */
@Component
public class DemoTestBean {

    @Autowired
    private WebServerApplicationContext webServerAppCtxt;

    // Disabling the annotation so tomcat will listen only on random port
    @PostConstruct
    public int getPort() {
        // In the @PostConstruct phase the property local.server.port isn't set.
        // To get a port the bean uses the web server context.
        // This causes tomcat listening on two ports: 8080 and a random port.
        // Output: Tomcat started on port(s): 8080 (http) <random port>> (http)
        return webServerAppCtxt.getWebServer().getPort();
    }
}
