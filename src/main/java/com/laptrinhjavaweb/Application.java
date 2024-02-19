package com.laptrinhjavaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laptrinhjavaweb.destination.ProductDestination;
import com.laptrinhjavaweb.modelmapper.ConfigModelMapper;
import com.laptrinhjavaweb.source.ProductSource;

//@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		
		ProductSource productSource = new ProductSource();
		productSource.setName(1);
		productSource.setDescription("Mô tả sản phẩm 1");
		
		ConfigModelMapper configModelMapper = new ConfigModelMapper();
		
		ProductDestination results = configModelMapper.map(productSource, ProductDestination.class);
		System.out.println(results.toString());
	}
}