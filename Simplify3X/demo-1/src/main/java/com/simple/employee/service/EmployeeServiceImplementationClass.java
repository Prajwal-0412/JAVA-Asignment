package com.simple.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.employee.dao.EmployeeDao;
import com.simple.employee.entity.Employee;

@Service
public class EmployeeServiceImplementationClass implements EmployeeService {

	@Autowired
	public EmployeeDao dao;

	@Override
	public Employee addEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public Employee getEmployee(Integer empId) {
		return dao.findByEmpId(empId);
	}

	@Override
	public Employee getEmployee1(String mail) {
		return dao.findByMail(mail);
	}

	@Override
	public List<Employee> getAllEmp(Employee employee) {
		return (List<Employee>) dao.findAll();
	}

	@Override
	public boolean deleteEmployee(Integer empId) {
		Employee employee = dao.findByEmpId(empId);
		if (employee != null) {
			dao.delete(employee);
			return true;
		} else {
			return false;
		}
	}

}
