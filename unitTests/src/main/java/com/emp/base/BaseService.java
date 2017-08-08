package com.emp.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 *  @author Pallavi Varne
 *  Each service will implement BaseService
 * 
 */

public abstract class BaseService<E, ID extends Serializable> {
	protected BaseRepo<E, ID> entityRepo;
	
	public BaseService(BaseRepo<E, ID> entityRepo) {
		super();
		this.entityRepo = entityRepo;
	}
	
	public BaseRepo<E, ID> getEntityRepo() {
		return entityRepo;
	}

	public void setEntityRepo(BaseRepo<E, ID> entityRepo) {
		this.entityRepo = entityRepo;
	}
	
	public List<E> readAll(){
		Iterable<E> entities = entityRepo.findAll();
		return (List<E>) entities;
	}
	
	public E create(E inputentity) {
		return entityRepo.save(inputentity);
	}
	
	public E update(E inputentity){
		return entityRepo.save(inputentity);
	}
	
	public E findById(ID id){
		return entityRepo.findOne(id);
	}
	
	public HttpStatus delete(ID id){
		entityRepo.delete(id);
		return HttpStatus.OK;
	}
}
