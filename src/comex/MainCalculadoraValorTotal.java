package comex;

import java.text.SimpleDateFormat;

public class MainCalculadoraValorTotal {
	public static void main(String[] args) {
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

		Categoria informatica = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria livros = new Categoria("LIVROS", StatusCategoria.INATIVA);

		Produto produto1 = new Produto("Notebook Samsung", 3523.00, 80, informatica);
		Produto produto2 = new Produto("Clean Architecture", 102.90, 52, livros);

		Cliente cliente1 = new Cliente("Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente("Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife", "Pernambuco");

		Pedido pedido1 = new Pedido(spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido2 = new Pedido(spf.format(19 - 10 - 2019), cliente2);

		ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido1,
				TipoDesconto.PROMOCAO);
		ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPreco_unitario(), 2, pedido2,
				TipoDesconto.NENHUM);

		CalculadoraValorTotal cvt = new CalculadoraValorTotal();
		
		System.out.println("\nValor unitario: "+itempedido1.getPreco()+"\nQuantidade: "+itempedido1.getQuantidade()+"\nValores Totais: " + cvt.Calcula(itempedido1));
		System.out.println("\nValor unitario: "+produto2.getPreco()+"\nQuantidade: "+produto2.getQuantidade()+"\nValores Totais: " + cvt.Calcula(produto2));
		
		
	}
}
