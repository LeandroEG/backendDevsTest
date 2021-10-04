package com.backend.devstest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.backend.devstest.config.YamlPropertySourceFactory;

import feign.Retryer;

@SpringBootApplication
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@ComponentScan("com.backend.devstest")
@EnableFeignClients
public class BackendDevsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDevsTestApplication.class, args);
	}

	@Bean
	public Retryer retryer() {
		return new Retryer.Default();
	}
	
}
