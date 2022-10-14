package br.com.comex.modelo;

public class ProdutoIsento extends Produto {

	public ProdutoIsento(String nome, double preco_unitario, int qtd_estoque, int categoriaProduto) {
		super(nome, preco_unitario, qtd_estoque, categoriaProduto);

	}

	public double ValorEstoque() {
		return this.CalcularValorEstoque();
	}

	public double CalculaImposto() {
		return 0;
	}

	@Override
	public String toString() {
		return "\nProduto Isento:\nNome do produto: " + getNome() + "\nValor do produto: " + getPreco()
				+ "\nImposto do produto: " + CalculaImposto() + "\nImposto: " + CalculaImposto();
	}

}
