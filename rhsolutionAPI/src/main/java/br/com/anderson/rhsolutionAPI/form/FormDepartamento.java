package br.com.anderson.rhsolutionAPI.form;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;

public class FormDepartamento {
	
	@NotEmpty
	@NotNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static DepartamentoPessoal converter(@Valid FormDepartamento departamentoForm) {
		return new DepartamentoPessoal(departamentoForm);
	}
	
}
