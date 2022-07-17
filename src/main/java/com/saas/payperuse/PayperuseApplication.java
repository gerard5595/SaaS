package com.saas.payperuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayperuseApplication {
	
	  @Autowired
//	  private CustomerRepository customerRepository;
	  
	public static void main(String[] args) {
		SpringApplication.run(PayperuseApplication.class, args);
	}
	
//	  @PostConstruct
//	  private void initDb() {
//		  Customer customer = new Customer("Deutsche Bahn", 10, 2.5, LocalDate.now());
//		  customerRepository.save(customer);
//	  }
}
