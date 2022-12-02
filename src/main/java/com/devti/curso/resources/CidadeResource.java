package com.devti.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devti.curso.model.Cidade;
import com.devti.curso.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	
	@PostMapping
	@ApiOperation(value = "Cadastra Cidade")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade Cadastrada com Sucesso"),
			@ApiResponse(code = 201, message = "Criado"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Permissão negada"),
			@ApiResponse(code = 404, message = "Não encontrado"),
	})
	public Cidade inserirCidade(@ApiParam(value = "Cidade")@RequestBody Cidade c) {
		return service.incluir(c);
	}
	
	
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna lista de Cidades"),
			@ApiResponse(code = 403, message = "Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
	})
	@ApiOperation(value = "Lista todas as Cidades Cadastradas")
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Busca uma Cidade por UF")
	public List<Cidade> listarPorUf(@ApiParam(value = "Unidade Federativa") @PathVariable("uf") String uf){
		return service.buscarPorUf(uf);
	}
	
	@PutMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade alterada com sucesso"),
			@ApiResponse(code = 403, message = "Permissão negada"),
			@ApiResponse(code = 404, message = "Cidade não encontrada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
	})
	@ApiOperation(value = "Altera cidade")
	public Cidade alterar(@ApiParam(value = "Cidade")@RequestBody Cidade c,@ApiParam(value = "ID (Chave-Primária)")@RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui uma cidade da base de dados")
	public void excluir(@ApiParam(value = "ID (Chave-primária)") @PathVariable("id") int id) {
		service.excluir(id);
	}
	
}
