package br.com.comex.sql.modelo;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.comex.modelo.ComexException;

public class Produto implements ValorQuantidade {

	protected static final AtomicInteger count = new AtomicInteger(0);
	protected int id;
	protected String nome;
	protected String descricao;
	protected BigDecimal preco_unitario;
	protected int qtd_estoque;
	public Categoria categoriaProduto;
	protected int idCategoria;
	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public BigDecimal getPreco_unitario() {
		return this.preco_unitario;
	}

	public int getQtd_estoque() {
		return this.qtd_estoque;
	}

	public Categoria getCategoriaProduto() {
		return this.categoriaProduto;
	}
	public int getIdCategoria() {
		return this.idCategoria;
	}

		
	public BigDecimal getPreco() {
		return this.preco_unitario;
	}
	
	public int getQuantidade() {
		return this.qtd_estoque;
	}
	


	public Produto(String nome, BigDecimal preco_unitario, int qtd_estoque, int idCategoria) {
		
		this.id = count.incrementAndGet();
		if(nome==null || nome.substring(0,1).matches("[0-9]*")){
			throw new ComexException(nome+". Erro: Não pode começar com números de 0 à 9");
		}
		if (id <= 0) {
			 throw new ComexException(nome+". Erro: Id deve ser maior que 0");
		}
		if (nome.length()<=5) {
			 throw new ComexException(nome+". Erro: Nome do curso deve ser maior que 3 caracteres");
		}
		
		if (qtd_estoque <= 0) {
			 throw new ComexException(nome+". Erro: Quantidade de estoque menor que 0");
		}
		if (categoriaProduto == null) {
			 throw new ComexException(nome+". Erro: A categoria não pode ser vazia");
		}
		
		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.qtd_estoque = qtd_estoque;
		this.idCategoria = categoriaProduto.getId() ;

	}
	@Override
	public String toString() {
		return "\nProduto: "+"\nId: "+ getId() +"\nNome do produto: "+getNome()+"\nValor do Produto: "+getPreco_unitario()+ "\nQuantidade de estoque: "+ getQtd_estoque() +"\nCategoria: "+categoriaProduto.getNome();
	}
}
