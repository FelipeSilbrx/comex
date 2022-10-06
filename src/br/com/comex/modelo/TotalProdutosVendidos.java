package br.com.comex.modelo;

import java.util.List;

import br.com.comex.csv.PedidoCsv;

public class TotalProdutosVendidos {	

	public double calculaProdutos(List<PedidoCsv> pedidos) {
		double aux = 0;
		
		for (int i=0 ; i <pedidos.size(); i++) {
			aux += Integer.valueOf(pedidos.get(i).getQuantidade()) ;
		}
		return aux;
	}
}
