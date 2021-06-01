package org.sfw.boot.h2db.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.sfw.boot.h2db.entity.Customer;
import org.sfw.boot.h2db.repo.CustomerRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cust")
public class Cust_Controller {
	@Autowired
	private CustomerRepository custRepo;
	private static Logger log=(Logger) LoggerFactory.logger(Customer.class);

	@PostMapping("/saveCust")
	public ResponseEntity<Customer> save(@RequestBody Customer cust) {
		int a=10;
		System.out.println(a);
		try {
			return new ResponseEntity<>(custRepo.save(cust), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getCustomers")
	public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
		try {
			List<Customer> list = custRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				System.out.println("NO records");
				return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Customer>>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("exception");
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomerss() {
		return custRepo.findAll();
	}

	@GetMapping("/customersbyID/{id}")
	public Optional<Customer> getCustomerByID(@PathVariable("id") int id) {
		return custRepo.findById(id);
	}

	@PutMapping("/changeCust/{id}")
	public @ResponseBody ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust,
			@PathVariable("id") int id) {
		cust.setId(id);
		try {
			return new ResponseEntity<Customer>(custRepo.save(cust), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("exception");
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delCust/{id}")
	public ResponseEntity<HttpStatus> deleteCust(@PathVariable("id") int id) {
		try {
			Optional<Customer> customer = custRepo.findById(id);
			if (customer.isPresent()) {
				custRepo.delete(customer.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			System.out.println("exception");
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
