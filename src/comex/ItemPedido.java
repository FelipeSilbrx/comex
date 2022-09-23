package comex;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemPedido {
	
	private static final AtomicInteger count = new AtomicInteger(0);   
	Produto produto;
	Pedido pedido;
	private static int id;
	private double preco_unitario;
	private int qtd_itens;	
	private double desconto;
	private TipoDesconto tipo_desconto = TipoDesconto.NENHUM;
	
	public Produto getProduto() {
		return produto;
	}
	public int getId() {
		return id;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public int getQtd_itens() {
		return qtd_itens;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public double getDesconto() {
		return desconto;
	}
	public TipoDesconto getTipo_desconto() {
		return tipo_desconto;
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
		return  PrecoTotalSDesconto()-(getPreco_unitario() * CalculaDesconto());
	}
	
	public ItemPedido(Produto produto, double preco_unitario, int qtd_itens, Pedido pedido,
			TipoDesconto tipo_desconto) {
		super();
		this.id = count.incrementAndGet();
		this.produto = produto;		
		this.preco_unitario = preco_unitario;
		this.qtd_itens = qtd_itens;
		this.pedido = pedido;		
		this.tipo_desconto = tipo_desconto;
		this.desconto = getPreco_unitario() * CalculaDesconto();
	}
	
}
