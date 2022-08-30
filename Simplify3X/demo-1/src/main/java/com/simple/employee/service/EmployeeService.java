package com.simple.employee.service;

import java.util.List;
import com.simple.employee.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public Employee getEmployee(Integer empId);
	
	public Employee getEmployee1(String mail);
	
	public List<Employee> getAllEmp(Employee employee);
	
	public boolean deleteEmployee(Integer empId);
	
}
