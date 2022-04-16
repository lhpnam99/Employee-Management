package net.javaguilde.springboot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguilde.springboot.model.Department;
import net.javaguilde.springboot.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController implements ResourceController<Department> {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService DepartmentService) {
		this.departmentService = DepartmentService;
	}
	
	public List<Department> get(@RequestParam (defaultValue = "0") int start, @RequestParam (defaultValue = "2") int limit) {
		return  departmentService.get(start, limit);
	}
	
	public Department get(@PathVariable("id") UUID id) {
		return departmentService.get(id);
	}
	
	public Department add(@RequestBody Department Department) {
		return departmentService.add(Department);
	}
	
	public Department update(@PathVariable("id") UUID id, @RequestBody Department departmentDetails) {
		return departmentService.update(id, departmentDetails);
	}
	
	public void delete(@PathVariable("id") UUID id) {
		departmentService.delete(id);
	}
}
