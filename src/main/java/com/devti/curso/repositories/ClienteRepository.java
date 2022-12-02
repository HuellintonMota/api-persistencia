package com.devti.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.devti.curso.model.Cidade;
import com.devti.curso.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public List<Cliente> findByCidade(Cidade c);
	
	public List<Cliente> findByCidadeId(Integer idCidade);
	

}
