package br.com.rafael.ubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class UbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsApplication.class, args);
	}

}
