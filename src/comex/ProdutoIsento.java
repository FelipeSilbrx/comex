package comex;

public class ProdutoIsento extends Produto{
	

	
	public ProdutoIsento(String nome, double preco_unitario, int qtd_estoque, Categoria categoriaProduto) {
		super(nome, preco_unitario, qtd_estoque, categoriaProduto);
		
	}

	public double ValorEstoque() {
		return this.CalcularValorEstoque();		
	}
	
	public double CalculaImposto() {
		return 0;
	}

}
