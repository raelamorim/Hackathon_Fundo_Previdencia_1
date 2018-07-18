package com.orangelittle.dao;

import org.springframework.data.repository.CrudRepository;

import com.orangelittle.modelo.Movimento;

public interface MovimentoDAO extends CrudRepository<Movimento, Long>{

}
