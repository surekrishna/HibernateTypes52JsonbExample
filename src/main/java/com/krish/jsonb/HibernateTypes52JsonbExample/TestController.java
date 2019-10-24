package com.krish.jsonb.HibernateTypes52JsonbExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private TestRepository testRepository;
	
	@PostMapping("/save")
	public Test saveTest() {
		var car1 = new Car();
		car1.setBrand("Hublot");
		car1.setCountry("Bottle");
		
		var car2 = new Car();
		car2.setBrand("Rollex");
		car2.setCountry("watch");
		
		var test = new Test();
		test.setCars(List.of(car1, car2));
		//test.setWheels("Four");
		//test.setNoOfSeats(5);
		
		return testRepository.save(test);
	}
	
	@GetMapping("/{id}")
	public Test getTest(@PathVariable Long id) {
		var test = testRepository.findById(id).orElse(null);
		System.out.println(test);
		System.out.println(test.getCars());
		return test;
	}
}
