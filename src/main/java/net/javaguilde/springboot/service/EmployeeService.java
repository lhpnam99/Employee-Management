package net.javaguilde.springboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import net.javaguilde.springboot.exception.ResourceNotFoundException;
import net.javaguilde.springboot.model.Employee;
import net.javaguilde.springboot.repository.EmployeeRepository;
@Component
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> get(int start, int limit) {
		Page<Employee> page = employeeRepository.findAll(PageRequest.of(start, limit));
		return page.getContent();
	}

	public Employee get(UUID id) {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee does not exist"));
	}

	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee update(UUID id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee does not exist"));
		employee.setId(id);
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		return employeeRepository.save(employee);
	}

	public void delete(UUID id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee does not exist"));
		employeeRepository.delete(employee);
	}

	public List<Employee> addAll(List<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
