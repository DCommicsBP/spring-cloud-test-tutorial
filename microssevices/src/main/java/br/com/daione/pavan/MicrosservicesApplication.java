package br.com.daione.pavan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicrosservicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicrosservicesApplication.class, args);
	}
}
