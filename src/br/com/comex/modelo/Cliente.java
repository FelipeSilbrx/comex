package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
	
	protected static final AtomicInteger count = new AtomicInteger(0); 
	protected int id ;
	protected String nome;
	protected String cpf;
	protected int telefone;
	protected String rua;
	protected String numero;
	protected String complemento;
	protected String bairro;
	protected String cidade;
	protected String estado;

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
		String s = String.valueOf(telefone);
		this.id = count.incrementAndGet();
		
		if (id <= 0) {
			 throw new IllegalArgumentException(nome+". Erro: Id deve ser maior que 0");
		}
		if (nome.length()<=5) {
			 throw new IllegalArgumentException(nome+". Erro: Nome do cliente");
		}
		if (cpf.length() >= 11 && cpf.length() <= 14) {
			 throw new IllegalArgumentException(nome+". Erro: CPF está errado");
		}
		if (s.length() >= 11 && s.length() <= 16) {
			 throw new IllegalArgumentException(nome+". Erro: Telefone inválido");
		}
		if (rua.length() <= 5) {
			 throw new IllegalArgumentException(nome+". Erro: Rua inválida");
		}
		if (numero.length() <= 1) {
			 throw new IllegalArgumentException(nome+". Erro: Numero do endereço errado");
		}
		if (bairro.length()<=1) {
			 throw new IllegalArgumentException(nome+". Erro: Bairro errado");
		}
		if (cidade.length() <= 1) {
			 throw new IllegalArgumentException(nome+". Erro: Cidade errada");
		}
		if (estado.length() != 2) {
			 throw new IllegalArgumentException(nome+". Erro: Estado errado");
		}		
		
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
	@Override
	public String toString() {
		return "------------------ \nCliente: " + getNome() + "\nId do Cliente: " + getId()
		+ "\nCPF do cliente: " + getCpf() + "\nTelefone: " + getTelefone() + "\nRua: "
		+getRua() + "\nNúmero do endereço: " + getNumero() + "\nComplemento do endereço: "
		+ getBairro() + "\nCidade: " + getCidade() + "\nEstado: " + getEstado()
		;
	}
}
