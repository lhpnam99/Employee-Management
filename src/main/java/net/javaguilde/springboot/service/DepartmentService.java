package net.javaguilde.springboot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.javaguilde.springboot.model.Department;
import net.javaguilde.springboot.repository.DepartmentRepository;

@Component
public class DepartmentService extends AbstractResourceService<Department, UUID>{
	private static final String NOT_FOUND_MESSAGE = "Department not found";
	
	@Autowired
	public DepartmentService(DepartmentRepository repo) {
		super(repo);
	}
	
	public List<Department> get(int start, int limit) {
		return super.get(start, limit, NOT_FOUND_MESSAGE);
	}
	
	public Department get(UUID id) {
		return super.get(id, NOT_FOUND_MESSAGE);
	}
	
	public Department add(Department data) {
		return super.add(data);
	}
	
	public Department update(UUID id, Department updatedData) {
		return super.update(id, updatedData, NOT_FOUND_MESSAGE);
	}
	
	public void delete(UUID id) {
		super.delete(id, NOT_FOUND_MESSAGE);
	}
	
	@Override
	protected void update(Department existedData, Department updatedData) {
		existedData.setName(updatedData.getName());
	}

}
