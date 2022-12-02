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
import com.devti.curso.model.Cliente;
import com.devti.curso.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna lista de Clientes"),
			@ApiResponse(code = 403, message = "Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
	})
	@ApiOperation(value = "Lista todos os Clientes")
	public List<Cliente> listarTodos(){
		return service.listarTodos();
	}
	
	@GetMapping("/buscacidade")
	@ApiOperation(value = "Lista os Clientes por cidade")
	public List<Cliente> listarPorCidade(@ApiParam(value = "ID da Cidade")@RequestParam("id") int id){
		return service.buscaPorCidade(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra o Cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente Cadastrado com Sucesso"),
			@ApiResponse(code = 201, message = "Criado"),
			@ApiResponse(code = 401, message = "Não autorizado"),
			@ApiResponse(code = 403, message = "Permissão negada"),
			@ApiResponse(code = 404, message = "Não encontrado"),
	})
	public Cliente inserirCliente(@ApiParam(value = "Cliente (Application/JSON)")@RequestBody Cliente c) {
		return service.incluir(c);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualiza o Cliente")
	public Cliente alterarCliente(@ApiParam(value = "Cliente (Application/JSON)")@RequestBody Cliente c,@ApiParam(value = "ID (Chave-Primária)")@RequestParam("id")int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exlui o Cliente com o ID informado")
	public void excluir(@ApiParam(value = "ID (Chave-Primária)")@PathVariable("id") int id) {
		service.excluir(id);
	}
	
}
