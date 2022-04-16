package net.javaguilde.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import net.javaguilde.springboot.exception.ResourceNotFoundException;

public abstract class AbstractResourceService<R, I> {
	
	private final JpaRepository<R, I> repo;
	
	protected AbstractResourceService(JpaRepository<R, I> repo) {
		this.repo = repo;
	}

	protected List<R> get(int start, int limit, String notFoundMessage) {
		Page<R> page = repo.findAll(PageRequest.of(start, limit));
		List<R> content = page.getContent();
		if(CollectionUtils.isEmpty(content)) {
			throw new ResourceNotFoundException(notFoundMessage);
		}
		return page.getContent();
	}

	protected R get(I id, String notFoundMessage) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
	}

	protected R add(R data) {
		return repo.save(data);
	}

	protected R update(I id, R updatedData, String notFoundMessage) {
		R existedData = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
		update(existedData, updatedData);
		return repo.save(existedData);
	}
	
	protected void delete(I id, String notFoundMessage) {
		R data = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
		repo.delete(data);
	}

	protected abstract void update(R existedData, R updatedData);

}
