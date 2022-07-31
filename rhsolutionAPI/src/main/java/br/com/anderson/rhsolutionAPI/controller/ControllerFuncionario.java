package br.com.anderson.rhsolutionAPI.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.anderson.rhsolutionAPI.dto.DtoDepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.dto.DtoFuncionario;
import br.com.anderson.rhsolutionAPI.form.FormDepartamento;
import br.com.anderson.rhsolutionAPI.form.FormFuncionario;
import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.model.Funcionario;
import br.com.anderson.rhsolutionAPI.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class ControllerFuncionario {
	
	@Autowired
	private FuncionarioService funcionarioservice;

	@GetMapping
	public ResponseEntity<List<Funcionario>> listar(){ 
		
		List<Funcionario> listarTodosFuncionarios = funcionarioservice.listarTodosFuncionarios();
	
		return ResponseEntity.ok(listarTodosFuncionarios);
	}
	
	/*
	@PostMapping
	public ResponseEntity<DtoFuncionario> cadastrar(
			@RequestBody @Valid FormFuncionario funcionario,
			UriComponentsBuilder uriBuilder
			){
		DtoFuncionario salvarDepartamento = funcionarioservice.salvarFuncionario(FormFuncionario.toModel(funcionario));
		URI uri = uriBuilder.path("/departamento/{id}").buildAndExpand(salvarDepartamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DtoFuncionario(salvarDepartamento));
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<DtoFuncionario> detalhar( @PathVariable("id") Long id) {
		Optional<Funcionario> funcionarioLocalizado = funcionarioservice.buscarFuncionarioById(id);
		if(funcionarioLocalizado.isPresent()) {
			Funcionario funcionario = funcionarioLocalizado.get(); 
			return ResponseEntity.ok(new DtoFuncionario(funcionario));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DtoFuncionario> atualizar(@PathVariable("id") Long id,
											@RequestBody @Valid FormDepartamento departamentoForm) {
		Optional<Funcionario> funcionarioLocalizado = funcionarioservice.buscarFuncionarioById(id);
		if(funcionarioLocalizado.isPresent()) {
			Funcionario funcionario = funcionarioLocalizado.get();
			Funcionario funcionarioPersistido = funcionarioservice.salvarFuncionario(id, funcionario);
			return ResponseEntity.ok(new DtoFuncionario(funcionarioPersistido));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		 Optional<Funcionario> funcionarioLocalizado = funcionarioservice.buscarFuncionarioById(id);
		if(funcionarioLocalizado.isPresent()) {
			Funcionario funcionario = funcionarioLocalizado.get();
			funcionarioservice.excluirFuncionarioById(funcionario.getId());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
