package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@SpringBootApplication
public class DemoApplication {

    @Autowired
    private CustomProps customProps;

    @RequestMapping("/")
    public String home() {
        if(customProps.getHello().isEmpty()){
            return "Hello World!";
        }
        return "Hello " + customProps.getHello();
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
