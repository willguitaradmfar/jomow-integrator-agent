package br.com.jomow.integratorMDB.bean;

import java.sql.Date;

public class Movimentacao {
	
	private String nome;
	private Date data;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	

}
