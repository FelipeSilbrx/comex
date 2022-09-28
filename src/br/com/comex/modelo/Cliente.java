package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	private int id ;
	private String nome;
	private String cpf;
	private int telefone;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public Cliente(String nome, String cpf, int telefone, String rua, String numero, String complemento,
			String bairro, String cidade, String estado) {
		super();
		this.id = count.incrementAndGet();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

}
