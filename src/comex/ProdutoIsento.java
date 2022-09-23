package comex;

public class ProdutoIsento extends Produto{
	

	public ProdutoIsento(int id, String nome, double preco_unitario, int qtd_estoque, Categoria categoriaProduto) {
		super(id, nome, preco_unitario, qtd_estoque, categoriaProduto);
		
	}
	
	public double ValorEstoque(Produto p) {
		return p.CalcularValorEstoque();		
	}
	
	public double CalculaImposto() {
		return 0;
	}

}
