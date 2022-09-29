package br.com.comex.modelo;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemPedido implements ValorQuantidade {
	
	protected static final AtomicInteger count = new AtomicInteger(0);   
	protected Produto produto;
	public Pedido pedido;
	protected int id ;
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
	public double getPreco_unitario() {
		return this.preco_unitario;
	}
	public int getQtd_itens() {
		return this.qtd_itens;
	}
	public Pedido getPedido() {
		return this.pedido;
	}
	public double getDesconto() {
		return this.desconto;
	}
	public TipoDesconto getTipo_desconto() {
		return this.tipo_desconto;
	}
	
	public double getPreco() {
		return this.preco_unitario;
	}
	
	public int getQuantidade() {
		return this.qtd_itens;
	}	
	
	public double PrecoTotalSDesconto () {
		return this.getPreco_unitario() * this.getQtd_itens();
	}
	
	public double CalculaDesconto () {
		if(this.getTipo_desconto()== TipoDesconto.PROMOCAO ) {
			return 0.2;
		}else if(this.getQtd_itens()>=10 && this.getTipo_desconto()== TipoDesconto.QUANTIDADE ){
			return 0.1;
		}
		return 0;
	}
	
	public double TotalCDesconto() {
		return  this.PrecoTotalSDesconto()-(this.getPreco_unitario() * this.CalculaDesconto());
	}
	
	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido,
			TipoDesconto tipo_desconto) {		
		this.id = count.incrementAndGet();		
		this.produto = produto;		
		this.preco_unitario = preco_unitario;
		this.qtd_itens = qtd_itens;
		this.pedido = pedido;		
		this.tipo_desconto = tipo_desconto;
		this.desconto = this.getPreco_unitario() * this.CalculaDesconto();
	}
	public String toString() {
		return "-------------\nNome do Cliente: " + pedido.cliente.getNome() + "\nItem Pedido: "
				+ getId() + "\nQuantidade de item: " + getQtd_itens() + "\nValor do item: "
				+ getPreco_unitario() + "\nValor total da compra: " + TotalCDesconto()
				+ "\nDesconto aplicado: " + getDesconto() + "\n-------------";
	}
}
