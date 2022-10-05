package br.com.comex.main;

import br.com.comex.csv.PedidoCsv;
import br.com.comex.csv.LeitorPedidosCsv;
import java.io.FileNotFoundException;
import java.util.List;


public class MainLeitorPedidoCsv {
	public static void main(String[] args) throws FileNotFoundException  {
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv>  pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		System.out.println("Total de pedidos: "+pedidosCsv.size());
		
	}

}
