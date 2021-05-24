package org.sfw.boot.h2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootH2InmemoryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2InmemoryDbApplication.class, args);
	}

}
