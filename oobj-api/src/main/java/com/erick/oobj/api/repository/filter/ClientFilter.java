package com.erick.oobj.api.repository.filter;

public class ClientFilter extends SoninhoFilter {

	private String name;

	private String cpf;
	
	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
