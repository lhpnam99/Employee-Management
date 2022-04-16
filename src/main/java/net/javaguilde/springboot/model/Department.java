package net.javaguilde.springboot.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	private String name;
	
	@OneToMany(mappedBy = "belongTo")
	private Set<Employee> employees = new HashSet<>();
	
	@OneToOne
	private Employee headDepartment;

	public Department() {
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee getHeadDepartment() {
		return headDepartment;
	}

	public void setHeadDepartment(Employee headDepartment) {
		this.headDepartment = headDepartment;
	}
	
	
}
