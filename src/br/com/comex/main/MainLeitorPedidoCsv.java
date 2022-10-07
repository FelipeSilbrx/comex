package br.com.comex.main;

import java.io.FileNotFoundException;
import java.util.List;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import br.com.comex.csv.LeitorPedidosCsv;
import br.com.comex.csv.PedidoCsv;
import br.com.comex.modelo.MontanteTotalVendas;
import br.com.comex.modelo.PedidoMaisBaratoEMaisCaro;
import br.com.comex.modelo.TotalCategorias;
import br.com.comex.modelo.TotalProdutosVendidos;


public class MainLeitorPedidoCsv {
	public static void main(String[] args) throws FileNotFoundException  {
		LeitorPedidosCsv leitorPedidoCsv = new LeitorPedidosCsv();
		List<PedidoCsv>  pedidosCsv = leitorPedidoCsv.lerPedidosCsv();
		
		TotalProdutosVendidos tpv = new TotalProdutosVendidos();
		TotalCategorias tc = new TotalCategorias();
		MontanteTotalVendas mtv = new MontanteTotalVendas();		
		PedidoMaisBaratoEMaisCaro pmbec = new PedidoMaisBaratoEMaisCaro();
		
		String valorFormatado;
		
		System.out.println("Total de pedidos: "+pedidosCsv.size());
		System.out.println("Total de produtos vendidos: "+tpv.calcularProdutos(pedidosCsv));
		System.out.println("Total de categorias: "+ tc.calcularCategorias(pedidosCsv));
		System.out.println("Montante de vendas: " + NumberFormat.getCurrencyInstance().format(mtv.calcularMontante(pedidosCsv)));
		pmbec.compararBaratoECaro(pedidosCsv);
	}

}
