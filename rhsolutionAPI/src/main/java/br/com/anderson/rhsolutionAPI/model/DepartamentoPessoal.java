package br.com.anderson.rhsolutionAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.anderson.rhsolutionAPI.form.DepartamentoForm;


@Entity
@Table(name = "departamento_pessoal")
public class DepartamentoPessoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
	
    public DepartamentoPessoal() {
    	
    }
    
    public DepartamentoPessoal(DepartamentoForm form) {
    	this.nome = form.getNome();
    }
    
    
	public DepartamentoPessoal(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
}