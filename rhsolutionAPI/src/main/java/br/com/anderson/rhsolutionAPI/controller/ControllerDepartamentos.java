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
import br.com.anderson.rhsolutionAPI.form.FormDepartamento;
import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.service.DepartamentoPessoalService;

@RestController
@RequestMapping("/departamento")
public class ControllerDepartamentos {

	@Autowired
	private DepartamentoPessoalService departamentoservice;

	
	@GetMapping
	public List<DtoDepartamentoPessoal> listar(){ 
		
		List<DtoDepartamentoPessoal> listarDepartamentos = departamentoservice.listarDepartamentos();
		return listarDepartamentos;
	}
	
	@PostMapping
	public ResponseEntity<DtoDepartamentoPessoal> cadastrar(
			@RequestBody @Valid FormDepartamento departamentoForm,
			UriComponentsBuilder uriBuilder
			){
		DepartamentoPessoal salvarDepartamento = departamentoservice.salvarDepartamento(FormDepartamento.converter(departamentoForm));
		URI uri = uriBuilder.path("/departamento/{id}").buildAndExpand(salvarDepartamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DtoDepartamentoPessoal(salvarDepartamento));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DtoDepartamentoPessoal> detalhar( @PathVariable("id") Long id) {
		Optional<DepartamentoPessoal> dep = departamentoservice.buscarDepartamentoById(id);
		if(dep.isPresent()) {
			DepartamentoPessoal departamentoPessoal = dep.get(); 
			return ResponseEntity.ok(new DtoDepartamentoPessoal(departamentoPessoal));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DtoDepartamentoPessoal> atualizar(@PathVariable("id") Long id,
											@RequestBody @Valid FormDepartamento departamentoForm) {
		Optional<DepartamentoPessoal> depo = departamentoservice.buscarDepartamentoById(id);
		if(depo.isPresent()) {
			DepartamentoPessoal dep = departamentoservice.atualizarDepartamento(id, departamentoForm);
			return ResponseEntity.ok(new DtoDepartamentoPessoal(dep));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
		Optional<DepartamentoPessoal> dep = departamentoservice.buscarDepartamentoById(id);
		if(dep.isPresent()) {
			departamentoservice.excluirDepartamento(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
