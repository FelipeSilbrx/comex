package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
	
	protected static final AtomicInteger count = new AtomicInteger(0);
	protected int id;
	protected String data;
	public Cliente cliente;

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
