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

	 void ValidarConstrutor() {
		if (this.getId() <= 0 || this.getNome().length() <= 3 ) {
			 throw new IllegalArgumentException();
		}
		else{
			System.out.println("Construtor Validado");
		}
	}

	public Categoria(String nome, StatusCategoria ativa) {
		super();		
		this.id = count.incrementAndGet();
		this.nome = nome;
		this.status = ativa;

	}
	
	

}
