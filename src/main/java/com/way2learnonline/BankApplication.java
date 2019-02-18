package com.way2learnonline;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.way2learnonline.service.BankService;

@SpringBootApplication
public class BankApplication {
	
	@Bean
	@ConfigurationProperties(prefix="db")
	public DataSource dataSource(){		
		BasicDataSource dataSource= new BasicDataSource();
		
		return dataSource;		
	}
	
	public static void main(String [] args) {
		ApplicationContext context = null;
		BankService service = null;
		try {
			context = SpringApplication.run(BankApplication.class, args);
			service = context.getBean(BankService.class);
			service.transfer(new Long(1), new Long(2),1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
