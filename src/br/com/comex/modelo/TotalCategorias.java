package br.com.comex.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.comex.csv.PedidoCsv;

public class TotalCategorias {

	public int calcularCategorias(List<PedidoCsv> pedidos) {
		List<String> categoriaQueJaApareceram = new ArrayList<>();
		int teste = 0;
		for (PedidoCsv pedidosCsv : pedidos) {
			String categoria = pedidosCsv.getCategoria();
			if (!categoriaQueJaApareceram.contains(categoria)) {
				categoriaQueJaApareceram.add(categoria);
			}
		}
		teste = categoriaQueJaApareceram.size();
		return teste;
	}

}
