package net.javaguilde.springboot.service;

import java.util.List;
import java.util.UUID;

public interface ResourceService<R> {

	List<R> get(int start, int limit);

	R add(R employee);

	R update(UUID id, R employeeDetails);

	void delete(UUID id);

	R get(UUID id);

}
