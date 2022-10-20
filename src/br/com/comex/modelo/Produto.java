package br.com.comex.modelo;



public class Produto implements ValorQuantidade {

	
	protected int id;
	protected String nome;
	protected String descricao;
	protected double preco_unitario;
	protected int qtd_estoque;
	public Categoria categoriaProduto;
	protected TipoProduto tipo;

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}
	public TipoProduto getTipo() {
		return this.tipo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getPrecoUnitario() {
		return this.preco_unitario;
	}

	public int getQtdEstoque() {
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
	public void setId(int id) {
		this.id = id;
		
	}

	public Produto(int id) {
		
		this.id = id;
	}

	public Produto(String nome, double preco_unitario, int qtd_estoque, Categoria categoriaProduto) {

		
		if (nome == null || nome.substring(0, 1).matches("[0-9]*")) {
			throw new ComexException(nome + ". Erro: Não pode começar com números de 0 à 9");
		}
		/*if (id <= 0) {
			throw new ComexException(nome + ". Erro: Id deve ser maior que 0");
		}*/
		if (nome.length() <= 5) {
			throw new ComexException(nome + ". Erro: Nome do curso deve ser maior que 3 caracteres");
		}
		if (preco_unitario <= 0) {
			throw new ComexException(nome + ". Erro: Preco deve ser maior que 0");
		}
		if (qtd_estoque <= 0) {
			throw new ComexException(nome + ". Erro: Quantidade de estoque menor que 0");
		}
		if (categoriaProduto == null) {
			throw new ComexException(nome + ". Erro: A categoria não pode ser vazia");
		}

		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.qtd_estoque = qtd_estoque;
		this.categoriaProduto = categoriaProduto;

	}

	public Produto(String nome, double preco_unitario,String descricao, int qtd_estoque, Categoria categoriaProduto, TipoProduto tipo) {
		
		if (nome == null || nome.substring(0, 1).matches("[0-9]*")) {
			throw new ComexException(nome + ". Erro: Não pode começar com números de 0 à 9");
		}
		/*if (id <= 0) {
			throw new ComexException(nome + ". Erro: Id deve ser maior que 0");
		}*/
		if (nome.length() <= 5) {
			throw new ComexException(nome + ". Erro: Nome do curso deve ser maior que 3 caracteres");
		}
		if (preco_unitario <= 0) {
			throw new ComexException(nome + ". Erro: Preco deve ser maior que 0");
		}
		if (qtd_estoque <= 0) {
			throw new ComexException(nome + ". Erro: Quantidade de estoque menor que 0");
		}
		if (categoriaProduto == null) {
			throw new ComexException(nome + ". Erro: A categoria não pode ser vazia");
		}

		this.nome = nome;
		this.preco_unitario = preco_unitario;
		this.descricao = descricao;
		this.qtd_estoque = qtd_estoque;
		this.categoriaProduto = categoriaProduto;
		this.tipo = tipo;

	}

	@Override
	public String toString() {
		return "\nProduto: " + "\nId: " + getId() + "\nNome do produto: " + getNome() + "\nValor do Produto: "
				+ getPrecoUnitario() + "\nQuantidade de estoque: " + getQtdEstoque() + "\nCategoria: "
				+ categoriaProduto.getNome() + "\nValor total do estoque: " + CalcularValorEstoque()
				+ "\nValor do Imposto: " + CalcularImpostoUnitario();
	}

	
}
