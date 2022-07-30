package br.com.anderson.rhsolutionAPI.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;

public class DtoDetalhesDepartamento {
	
	private String nome;
	private List<DtoFuncionario> funcionario;
	
	public DtoDetalhesDepartamento(DepartamentoPessoal dep) {
		this.nome = dep.getNome();
		this.funcionario = new ArrayList<DtoFuncionario>();
		//this.funcionario.addAll(dep.get)
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<DtoFuncionario> getFuncionario() {
		return funcionario;
	}

	
	
	
}
