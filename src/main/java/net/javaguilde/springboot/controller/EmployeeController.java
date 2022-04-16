package net.javaguilde.springboot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguilde.springboot.model.Employee;
import net.javaguilde.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController implements ResourceController<Employee> {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public List<Employee> get(@RequestParam (defaultValue = "0") int start, @RequestParam (defaultValue = "50") int limit) {
		return  employeeService.get(start, limit);
	}
	
	public Employee get(@PathVariable("id") UUID id) {
		return employeeService.get(id);
	}
	
	public Employee add(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}
	
	public Employee update(@PathVariable("id") UUID id, @RequestBody Employee employeeDetails) {
		return employeeService.update(id, employeeDetails);
	}
	
	public void delete(@PathVariable("id") UUID id) {
		employeeService.delete(id);
	}
}
