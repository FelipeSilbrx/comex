package comex;

import java.util.concurrent.atomic.AtomicInteger;

public class Categoria {
	
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;;
	private String nome;
	private StatusCategoria status = StatusCategoria.ATIVA;

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
			 throw new IllegalArgumentException("Id deve ser maior que 0");
		}
		if (nome.length()<=3) {
			 throw new IllegalArgumentException("Nome do curso deve ser maior que 3 caracteres");
		}
		if (status != StatusCategoria.ATIVA && status != StatusCategoria.INATIVA) {
			 throw new IllegalArgumentException("Status diferente de Ativa e Inativa");
		}		
		this.nome = nome;
		this.status = ativa;
		
		
	}
	
	

}
