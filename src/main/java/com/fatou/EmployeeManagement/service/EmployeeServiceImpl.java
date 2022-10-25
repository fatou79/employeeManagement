package com.fatou.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatou.EmployeeManagement.exception.ResourceNotFoundException;
import com.fatou.EmployeeManagement.model.Employee;
import com.fatou.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired 
	private EmployeeRepository repo;
	


	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee) ;
	}



	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}



	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = repo.findById(id);
				if(employee.isPresent()) {
			return employee.get();
	}else {
		throw new ResourceNotFoundException("Employee","Id",id);
	}
	}



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = repo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee","Id",id));
		
	existingEmployee.setFirstname(employee.getFirstname());
	existingEmployee.setLastName(employee.getLastName());
	existingEmployee.setEmail(employee.getEmail());
	repo.save(existingEmployee);
		return existingEmployee;

	}



	@Override
	public void deleteEmployee(long id) {
		repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		repo.deleteById(id);
	}



	
}

	

