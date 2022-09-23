package comex;

import java.util.concurrent.atomic.AtomicInteger;

public class Produto implements ValorQuantidade {

	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;
	private String nome;
	private String descricao;
	private double preco_unitario;
	private int qtd_estoque;
	Categoria categoriaProduto;

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getPreco_unitario() {
		return this.preco_unitario;
	}

	public int getQtd_estoque() {
		return this.qtd_estoque;
	}

	public Categoria getCategoriaProduto() {
		return this.categoriaProduto;
	}
	
	public double CalcularValorEstoque() {
		return this.qtd_estoque * this.preco_unitario;
	}

	public double CalcularImpostoUnitario() {
		return this.preco_unitario * 0.4;
	}
	
	public double getPreco() {
		return this.preco_unitario;
	}
	
	public int getQuantidade() {
		return this.qtd_estoque;
	}
	


	public Produto(String nome, double preco_unitario, int qtd_estoque, Categoria categoriaProduto) {
		super();
		this.id = count.incrementAndGet();
		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.qtd_estoque = qtd_estoque;
		this.categoriaProduto = categoriaProduto;

	}

}
