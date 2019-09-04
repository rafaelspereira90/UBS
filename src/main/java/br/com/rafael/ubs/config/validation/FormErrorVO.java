package br.com.rafael.ubs.config.validation;

public class FormErrorVO {

	private String field;
	private String error;
	
	public FormErrorVO(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}
}
