package br.com.anderson.rhsolutionAPI.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.model.Funcionario;

public class DtoFuncionario {

	//private Long id;
	private String nome;
	//private Long cpf;
	private LocalDate dataNascimento;
	//private BigDecimal salario;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;

	public DtoFuncionario(Funcionario func) {
		this.nome = func.getNome();
		this.dataNascimento = func.getDataNascimento();
		this.dataAtualizacao = func.getDataAtualizacao();
		this.dataCadastro = func.getDataCadastro();
	}
	
	/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	/*
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}*/

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
/*
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
*/
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
