package br.com.comex.main;

import java.text.SimpleDateFormat;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.StatusCategoria;
import br.com.comex.modelo.TipoDesconto;

public class MainItemPedido {
	public static void main(String[] args) {
		try {
			SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

			Categoria informatica = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
			Categoria moveis = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
			Categoria livros = new Categoria("LIVROS", StatusCategoria.ATIVA);

			Produto produto1 = new Produto( "Notebook Samsung", 3523.00, 80, informatica);
			Produto produto2 = new Produto( "Clean Architecture", 102.90, 52, livros);
			Produto produto3 = new Produto( "Monitor Dell 27", 1889.00, 26, informatica);

			Cliente cliente1 = new Cliente("Ana Carolina", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
					"Pe");
			Cliente cliente2 = new Cliente("Elizabeth", "E123", 12122121, "rua abc", "03", "D", "Torre", "Recife",
					"Pe");
			Cliente cliente3 = new Cliente("Gabriela", "G123", 19877891, "rua zxc", "04", "A", "Boa Viagem", "Recife",
					"Pe");

			Pedido pedido1 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
			Pedido pedido2 = new Pedido( spf.format(19 - 10 - 2019), cliente2);
			Pedido pedido3 = new Pedido( spf.format(31 - 07 - 2022), cliente3);
			Pedido pedido4 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
			

			ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido1,
					TipoDesconto.PROMOCAO);
			ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPreco_unitario(), 2, pedido2,
					TipoDesconto.NENHUM);
			ItemPedido itempedido3 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido4,
					TipoDesconto.PROMOCAO);
			

			System.out.println(itempedido1.toString());
			System.out.println(itempedido2.toString());
			System.out.println(itempedido3.toString());


			
		}catch(IllegalArgumentException ex) {
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		

	}
}
