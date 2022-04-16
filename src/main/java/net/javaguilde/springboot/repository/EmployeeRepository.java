package net.javaguilde.springboot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguilde.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID>{
}
