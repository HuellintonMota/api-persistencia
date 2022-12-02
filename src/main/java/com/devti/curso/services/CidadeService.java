package com.devti.curso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.curso.model.Cidade;
import com.devti.curso.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository rep;

	public Cidade incluir(Cidade c) {
		return rep.save(c);
	}
	
	public List<Cidade> listarTodas(){
		return rep.findAll();
	}
	
	public List<Cidade> buscarPorUf(String uf){
		return rep.findByUf(uf);
	}
	public Cidade burcarPorId(Integer id){
		return rep.findById(id).get();
	}
	
	public Cidade alterar(Cidade c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cidade cidadeExcluir = rep.findById(id).get();
		if(cidadeExcluir!=null) {
			rep.delete(cidadeExcluir);
		}
	}
	
}
