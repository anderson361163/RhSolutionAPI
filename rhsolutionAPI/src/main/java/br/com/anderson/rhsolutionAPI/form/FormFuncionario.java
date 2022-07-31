package br.com.anderson.rhsolutionAPI.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.anderson.rhsolutionAPI.model.Funcionario;

public class FormFuncionario {

	private String nome;
	private Long cpf;
	private LocalDate dataNascimento;
	private BigDecimal salario;
	private FormDepartamentoPessoal departamentoPessoal;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizacao;

	public FormFuncionario(Funcionario funcionario) {
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.dataNascimento = funcionario.getDataNascimento();
		this.salario = funcionario.getSalario();
		//this.departamentoPessoal = funcionario.getDepartamentoPessoal();
		this.dataCadastro = funcionario.getDataCadastro();
		this.dataAtualizacao = funcionario.getDataAtualizacao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getNomeDepartamentoPessoal() {
		return departamentoPessoal.getNome();
	}
	
	public FormDepartamentoPessoal getDepartamentoPessoal() {
		return departamentoPessoal;
	}
	
/*
	public void setDataCadastro(FormDepartamentoPessoal departamentoPessoal) {
		this.departamentoPessoal = departamentoPessoal;
	}*/
	
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
	
	public static List<Funcionario> toModel(List<FormFuncionario> topicos) {
		return topicos.stream().map(Funcionario::new).collect(Collectors.toList());
	}
	
	public static List<FormFuncionario> toForm(List<Funcionario> topicos) {
		return topicos.stream().map(FormFuncionario::new).collect(Collectors.toList());
	}
}
