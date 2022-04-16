package net.javaguilde.springboot;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguilde.springboot.model.R;

public interface ResourceController<T> {
	
	@GetMapping
	public List<T> get(@RequestParam (defaultValue = "0") int start, @RequestParam (defaultValue = "2") int limit);
	
	@GetMapping("/{id}")
	public T get(@PathVariable("id") UUID id);
	
	@PostMapping
	public R add(@RequestBody T t);
	
	@PutMapping("/{id}")
	public R update(@PathVariable("id") UUID id, @RequestBody T t);
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") UUID id);
}
