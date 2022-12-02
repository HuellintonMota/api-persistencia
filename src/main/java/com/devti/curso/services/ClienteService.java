package com.devti.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.curso.model.Cidade;
import com.devti.curso.model.Cliente;
import com.devti.curso.repositories.CidadeRepository;
import com.devti.curso.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	ClienteRepository rep;
	
	@Autowired
	CidadeRepository repCidade;
	
	public List<Cliente> listarTodos(){
		return rep.findAll();
	}
	
	public Cliente incluir(Cliente c) {
		return rep.save(c);
	}
	
	
	public Cliente alterar(Cliente c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cliente clienteExcluir = rep.findById(id).get();
		if(clienteExcluir!= null) {
			rep.delete(clienteExcluir);
		}
	}
	
	public List<Cliente> buscaPorCidade(Integer idCidade){
		return rep.findByCidadeId(idCidade);
	}
	
	
	
}
