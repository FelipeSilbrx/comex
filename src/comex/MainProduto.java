package comex;

public class MainProduto {
	public static void main (String[] args) {
		Categoria informatica = new Categoria(1,"INFORMÁTICA",StatusCategoria.ATIVA);		
		Categoria livros = new Categoria(3,"LIVROS",StatusCategoria.ATIVA);
				
		Produto produto1 = new Produto(1,"Notebook Samsung", 3523.00, 1, informatica);
		Produto produto2 = new Produto(2,"Clean Architecture", 102.90, 2, livros);
		Produto produto3 = new Produto(3,"Monitor Dell 27",1889.00, 3, informatica);
		
		System.out.printf("\nProduto 1: "+"\nId: "+ produto1.getId() +"\nNome do produto: "+produto1.getNome()+"\nValor do Produto: "+produto1.getPreco_unitario()+ "\nQuantidade de estoque: "+ produto1.getQtd_estoque() +"\nCategoria: "+produto1.categoriaProduto.getNome()+"\nValor total do estoque: "+produto1.CalcularValorEstoque()+"\nValor do Imposto: "+"%.2f",produto1.CalcularImpostoUnitario());
		System.out.printf("\n-------------------");
		System.out.printf("\nProduto 2: "+"\nId: "+ produto2.getId() +"\nNome do produto: "+produto2.getNome()+"\nValor do Produto: "+produto2.getPreco_unitario()+ "\nQuantidade de estoque: "+ produto2.getQtd_estoque() +"\nCategoria: "+produto2.categoriaProduto.getNome()+"\nValor total do estoque: "+produto2.CalcularValorEstoque()+"\nValor do Imposto: "+"%.2f",produto2.CalcularImpostoUnitario());
		System.out.printf("\n-------------------");
		System.out.printf("\nProduto 3: "+"\nId: "+ produto3.getId() +"\nNome do produto: "+produto3.getNome()+"\nValor do Produto: "+produto3.getPreco_unitario()+ "\nQuantidade de estoque: "+ produto3.getQtd_estoque() +"\nCategoria: "+produto3.categoriaProduto.getNome()+"\nValor total do estoque: "+produto3.CalcularValorEstoque()+"\nValor do Imposto: "+"%.2f",produto3.CalcularImpostoUnitario());
		System.out.printf("\n-------------------");
		
		
	}
}