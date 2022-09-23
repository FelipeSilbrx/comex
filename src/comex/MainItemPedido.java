package comex;

import java.text.SimpleDateFormat;

public class MainItemPedido {
	public static void main(String[] args) {
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");

		Categoria informatica = new Categoria(1, "INFORMÁTICA", StatusCategoria.ATIVA);
		Categoria moveis = new Categoria(2, "MÓVEIS", StatusCategoria.INATIVA);
		Categoria livros = new Categoria(3, "LIVROS", StatusCategoria.ATIVA);

		Produto produto1 = new Produto(1, "Notebook Samsung", 3523.00, 80, informatica);
		Produto produto2 = new Produto(2, "Clean Architecture", 102.90, 52, livros);
		Produto produto3 = new Produto(3, "Monitor Dell 27", 1889.00, 26, informatica);

		Cliente cliente1 = new Cliente(1, "Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente(2, "Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife",
				"Pernambuco");
		Cliente cliente3 = new Cliente(3, "Gabi", "G123", 19877891, "rua zxc", "4", "A", "Boa Viagem", "Recife",
				"Pernambuco");

		Pedido pedido1 = new Pedido(1, spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido2 = new Pedido(2, spf.format(19 - 10 - 2019), cliente2);
		Pedido pedido3 = new Pedido(3, spf.format(31 - 07 - 2022), cliente3);
		Pedido pedido4 = new Pedido(1, spf.format(22 - 02 - 2022), cliente1);
		Pedido pedido5 = new Pedido(3, spf.format(30 - 07 - 2022), cliente3);
		Pedido pedido6 = new Pedido(1, spf.format(21 - 02 - 2022), cliente1);
		Pedido pedido7 = new Pedido(2, spf.format(12 - 10 - 2019), cliente2);
		Pedido pedido8 = new Pedido(3, spf.format(01 - 07 - 2022), cliente3);

		ItemPedido itempedido1 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido1,
				TipoDesconto.PROMOCAO);
		ItemPedido itempedido2 = new ItemPedido(produto2, produto2.getPreco_unitario(), 2, pedido2,
				TipoDesconto.NENHUM);
		ItemPedido itempedido3 = new ItemPedido(produto1, produto1.getPreco_unitario(), 1, pedido6,
				TipoDesconto.PROMOCAO);
		ItemPedido itempedido4 = new ItemPedido(produto3, produto3.getPreco_unitario(), 12, pedido3,
				TipoDesconto.QUANTIDADE);

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
