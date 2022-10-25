package com.fatou.EmployeeManagement.service;

import java.util.List;

import com.fatou.EmployeeManagement.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee, long id);  
	void deleteEmployee(long id);


}
