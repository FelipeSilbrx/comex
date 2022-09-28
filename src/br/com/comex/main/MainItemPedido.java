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
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

		Categoria informatica = new Categoria("INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria moveis = new Categoria("MÓVEIS", StatusCategoria.INATIVA);
		Categoria livros = new Categoria("LIVROS", StatusCategoria.ATIVA);

		Produto produto1 = new Produto( "Notebook Samsung", 3523.00, 80, informatica);
		Produto produto2 = new Produto( "Clean Architecture", 102.90, 52, livros);
		Produto produto3 = new Produto( "Monitor Dell 27", 1889.00, 26, informatica);

		Cliente cliente1 = new Cliente("Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente("Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife",
				"Pernambuco");
		Cliente cliente3 = new Cliente("Gabi", "G123", 19877891, "rua zxc", "4", "A", "Boa Viagem", "Recife",
				"Pernambuco");

		Pedido pedido1 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido2 = new Pedido( spf.format(19 - 10 - 2019), cliente2);
		Pedido pedido3 = new Pedido( spf.format(31 - 07 - 2022), cliente3);
		Pedido pedido4 = new Pedido( spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido5 = new Pedido( spf.format(30 - 07 - 2022), cliente3);
		Pedido pedido6 = new Pedido( spf.format(21 - 02 - 2022), cliente1);
		Pedido pedido7 = new Pedido( spf.format(12 - 10 - 2019), cliente2);
		Pedido pedido8 = new Pedido( spf.format(01 - 07 - 2022), cliente3);

		ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido1,
				TipoDesconto.PROMOCAO);
		ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPreco_unitario(), 2, pedido2,
				TipoDesconto.NENHUM);
		ItemPedido itempedido3 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido6,
				TipoDesconto.PROMOCAO);
		

		System.out.println("-------------\nNome do Cliente: " + itempedido1.pedido.cliente.getNome() + "\nItem Pedido: "
				+ itempedido1.getId() + "\nQuantidade de item: " + itempedido1.getQtd_itens() + "\nValor do item: "
				+ itempedido1.getPreco_unitario() + "\nValor total da compra: " + itempedido1.TotalCDesconto()
				+ "\nDesconto aplicado: " + itempedido1.getDesconto() + "\n-------------");

		System.out.println("-------------\nNome do Cliente: " + itempedido2.pedido.cliente.getNome() + "\nItem Pedido: "
				+ itempedido2.getId() + "\nQuantidade de item: " + itempedido2.getQtd_itens() + "\nValor do item: "
				+ itempedido2.getPreco_unitario() + "\nValor total da compra: " + itempedido2.TotalCDesconto()
				+ "\nDesconto aplicado: " + itempedido2.getDesconto() + "\n-------------");
		System.out.println("-------------\nNome do Cliente: " + itempedido3.pedido.cliente.getNome() + "\nItem Pedido: "
				+ itempedido3.getId() + "\nQuantidade de item: " + itempedido3.getQtd_itens() + "\nValor do item: "
				+ itempedido3.getPreco_unitario() + "\nValor total da compra: " + itempedido3.TotalCDesconto()
				+ "\nDesconto aplicado: " + itempedido3.getDesconto() + "\n-------------");

	}
}
