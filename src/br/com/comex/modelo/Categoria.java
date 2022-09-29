package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Categoria {
	
	
	protected static final AtomicInteger count = new AtomicInteger(0);
	protected int id;;
	protected String nome;
	protected StatusCategoria status = StatusCategoria.ATIVA;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public StatusCategoria getStatus() {
		return status;
	}


	public Categoria(String nome, StatusCategoria ativa) {			
		this.id = count.incrementAndGet();
		if (id <= 0) {
			 throw new IllegalArgumentException(nome+". Erro: Id deve ser maior que 0");
		}
		if (nome.length()<=3) {
			 throw new IllegalArgumentException(nome+". Erro: Nome da categoria deve ser maior que 3 caracteres");
		}
		if (status != StatusCategoria.ATIVA && status != StatusCategoria.INATIVA) {
			 throw new IllegalArgumentException(nome+". Erro: Status diferente de Ativa e Inativa");
		}		
		this.nome = nome;
		this.status = ativa;		
		
	}

	@Override
	public String toString() {
		return "Categoria " + getNome() + " ("+getId() +" - "+getStatus() +")";
	}
	
	

}
