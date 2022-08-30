package com.simple.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.employee.entity.Employee;
import com.simple.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		Employee employee1 = service.addEmployee(employee);
		if (employee1 != null) {
			return new ResponseEntity<String>("Data added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not added", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable Integer empId) {
		Employee employee = service.getEmployee(empId);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getByMail/{mail}")
	public ResponseEntity<?> getEmployee1(@PathVariable String mail) {
		Employee employee = service.getEmployee1(mail);
		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not Found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId) {
		if (service.deleteEmployee(empId)) {
			return new ResponseEntity<String>("data deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went Wrong", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/displayAll")
	public ResponseEntity<?> displayAll(Employee employee) {
		List<Employee> employees = service.getAllEmp(employee);
		if (employees != null) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Something went Wrong", HttpStatus.BAD_REQUEST);
		}
	}
}
