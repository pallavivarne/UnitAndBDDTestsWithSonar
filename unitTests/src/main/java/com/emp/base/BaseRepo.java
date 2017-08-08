package com.emp.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 		   @author Pallavi Varne
 *         Each entity repository will implement this interface
 * 
 */
@NoRepositoryBean
public interface BaseRepo<E, ID extends Serializable> extends CrudRepository<E, ID>
{

}
