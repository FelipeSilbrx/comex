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
		
		this.id = count.incrementAndGet();
		if (id <= 0) {
			 throw new IllegalArgumentException(nome+". Erro: Id deve ser maior que 0");
		}
		if (nome.length()<=5) {
			 throw new IllegalArgumentException(nome+". Erro: Nome do curso deve ser maior que 3 caracteres");
		}
		if (preco_unitario <= 0) {
			 throw new IllegalArgumentException(nome+". Erro: Preco deve ser maior que 0");
		}
		if (qtd_estoque <= 0) {
			 throw new IllegalArgumentException(nome+". Erro: Quantidade de estoque menor que 0");
		}
		if (categoriaProduto == null) {
			 throw new IllegalArgumentException(nome+". Erro: A categoria não pode ser vazia");
		}
		
		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.qtd_estoque = qtd_estoque;
		this.categoriaProduto = categoriaProduto;

	}

}
