package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Categoria {
	public enum Status {
		ATIVA, INATIVA
		}

	
	protected static final AtomicInteger count = new AtomicInteger(0);
	protected int id;;
	protected String nome;
	protected Status status = Status.ATIVA;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Status getStatus() {
		return status;
	}


	public Categoria(String nome, Status ativa) {			
		this.id = count.incrementAndGet();
		if(nome.substring(0,1).matches("[0-9]*")){
			throw new IllegalArgumentException(nome+". Erro: Não pode começar com números de 0 à 9");
		}
		if (id <= 0) {
		
			 throw new IllegalArgumentException(nome+". Erro: Id deve ser maior que 0");
		}
		if (nome.length()<=3) {
			 throw new IllegalArgumentException(nome+". Erro: Nome da categoria deve ser maior que 3 caracteres");
		}
		if ((Status.ATIVA != status) && (Status.INATIVA != status)) {
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
