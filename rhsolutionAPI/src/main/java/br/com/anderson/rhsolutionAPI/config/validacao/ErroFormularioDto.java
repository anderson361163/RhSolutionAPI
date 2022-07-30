package br.com.anderson.rhsolutionAPI.config.validacao;

import org.springframework.validation.FieldError;

public class ErroFormularioDto {

	private String campo;
	private String erro;

	public ErroFormularioDto(String erro, String messagem) {
		this.campo = erro;
		this.erro = messagem;
	}
	
	public ErroFormularioDto(FieldError erro, String messagem) {
		this.campo = erro.getField();
		this.erro = messagem;
	}
	
	public ErroFormularioDto(FieldError erro) {
		this.campo = erro.getField();
		this.erro = erro.getDefaultMessage();
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
