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
		super();
		this.id = count.incrementAndGet();
		this.nome = nome;
		this.status = ativa;
	}

}
