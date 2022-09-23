package comex;

import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;
	private String data;
	Cliente cliente;

	public int getId() {
		return this.id;
	}

	public String getData() {
		return this.data;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Pedido(String data, Cliente cliente) {
		super();
		this.id = count.incrementAndGet();
		this.data = data;
		this.cliente = cliente;
	}

}
