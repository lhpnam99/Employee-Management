package net.javaguilde.springboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguilde.springboot.model.Employee;
import net.javaguilde.springboot.repository.EmployeeRepository;

@Component
public class EmployeeService extends AbstractResourceService<Employee, UUID>{

	private static final String NOT_FOUND_MESSAGE = "Employee not found";

	@Autowired
	public EmployeeService(EmployeeRepository repo) {
		super(repo);
	}

	public List<Employee> get(int start, int limit) {
		return super.get(start, limit, NOT_FOUND_MESSAGE);
	}
	
	public Employee get(UUID id) {
		return super.get(id, NOT_FOUND_MESSAGE);
	}
	
	public Employee add(Employee data) {
		return super.add(data);
	}
	
	public Employee update(UUID id, Employee updatedData) {
		return super.update(id, updatedData, NOT_FOUND_MESSAGE);
	}
	
	public void delete(UUID id) {
		super.delete(id, NOT_FOUND_MESSAGE);
	}
	
	@Override
	protected void update(Employee existedData, Employee updatedData) {
		existedData.setFirstName(updatedData.getFirstName());
		existedData.setLastName(updatedData.getLastName());
		existedData.setEmailId(updatedData.getEmailId());
		existedData.setTitle(updatedData.getTitle());
		existedData.setBelongTo(updatedData.getBelongTo());
	}
	
	
}
