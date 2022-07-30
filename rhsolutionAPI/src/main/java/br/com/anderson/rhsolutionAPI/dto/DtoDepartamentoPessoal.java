package br.com.anderson.rhsolutionAPI.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;

public class DtoDepartamentoPessoal {

	private Long id;
	private String nome;

    public DtoDepartamentoPessoal() {
    	
    }
    
	public DtoDepartamentoPessoal(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public DtoDepartamentoPessoal(DepartamentoPessoal obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<DtoDepartamentoPessoal> converte(List<DepartamentoPessoal> topicos) {
		return topicos.stream().map(DtoDepartamentoPessoal::new).collect(Collectors.toList());
	}

}
