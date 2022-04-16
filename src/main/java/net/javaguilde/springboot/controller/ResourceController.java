package net.javaguilde.springboot.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


public interface ResourceController<R> {
	
	@GetMapping
	 List<R> get(@RequestParam (defaultValue = "0") int start, @RequestParam (defaultValue = "2") int limit);
	
	@GetMapping("/{id}")
	 R get(@PathVariable("id") UUID id);
	
	@PostMapping
	 R add(@RequestBody R data);
	
	@PutMapping("/{id}")
	 R update(@PathVariable("id") UUID id, @RequestBody R updatedData);
	
	@DeleteMapping("/{id}")
	 void delete(@PathVariable("id") UUID id);
}
