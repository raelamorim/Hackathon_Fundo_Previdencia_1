package com.orangelittle.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.orangelittle.modelo.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Long>{
	@Query(value = "select c from Cliente c where c.segmento like ?1")
	public Iterable<Cliente> findBySegmentoStartingWith(String segmento);
}
