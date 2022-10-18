package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemPedido implements ValorQuantidade {

	protected static final AtomicInteger count = new AtomicInteger(0);
	protected Produto produto;
	public Pedido pedido;
	protected int id;
	protected double preco_unitario;
	protected int qtd_itens;
	protected double desconto;
	protected TipoDesconto tipo_desconto = TipoDesconto.NENHUM;

	public Produto getProduto() {
		return this.produto;
	}

	public int getId() {
		return this.id;
	}

	public double getPrecoUnitario() {
		return this.preco_unitario;
	}

	public int getQtdItens() {
		return this.qtd_itens;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public double getDesconto() {
		return this.desconto;
	}

	public TipoDesconto getTipoDesconto() {
		return this.tipo_desconto;
	}

	public double getPreco() {
		return this.preco_unitario;
	}

	public int getQuantidade() {
		return this.qtd_itens;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}

	public double PrecoTotalSDesconto() {
		return this.getPrecoUnitario() * this.getQtdItens();
	}

	public double CalculaDesconto() {
		if (this.getTipoDesconto() == TipoDesconto.PROMOCAO) {
			return 0.2;
		} else if (this.getQtdItens() >= 10 && this.getTipoDesconto() == TipoDesconto.QUANTIDADE) {
			return 0.1;
		}
		return 0;
	}

	public double TotalComDesconto() {
		return this.PrecoTotalSDesconto() - (this.getPrecoUnitario() * this.CalculaDesconto());
	}

	public ItemPedido(Integer id) {
		super();
		this.id = id;

	}

	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido, double desconto,
			TipoDesconto tipo_desconto) {
		this.id = count.incrementAndGet();
		this.produto = produto;
		this.preco_unitario = preco_unitario;
		this.qtd_itens = qtd_itens;
		this.pedido = pedido;
		this.tipo_desconto = tipo_desconto;
		this.desconto = this.getPrecoUnitario() * this.CalculaDesconto();
	}
	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido,
			TipoDesconto tipo_desconto) {
		this.id = count.incrementAndGet();
		this.produto = produto;
		this.preco_unitario = preco_unitario;
		this.qtd_itens = qtd_itens;
		this.pedido = pedido;
		this.tipo_desconto = tipo_desconto;
		this.desconto = this.getPrecoUnitario() * this.CalculaDesconto();
	}

	

	public String toString() {
		return "-------------\nNome do Cliente: " + pedido.cliente.getNome() + "\nItem Pedido: " + getId()
				+ "\nQuantidade de item: " + getQtdItens() + "\nValor do item: " + getPrecoUnitario()
				+ "\nValor total da compra: " + TotalComDesconto() + "\nDesconto aplicado: " + getDesconto()
				+ "\n-------------";
	}

	
}
