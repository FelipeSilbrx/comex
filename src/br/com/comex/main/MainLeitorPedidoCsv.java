package br.com.comex.main;

import java.io.FileNotFoundException;
import java.util.List;
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
		
		TotalProdutosVendidos totalProdutosVendidos = new TotalProdutosVendidos();
		TotalCategorias totalCategorias = new TotalCategorias();
		MontanteTotalVendas montanteTotalVendas = new MontanteTotalVendas();		
		PedidoMaisBaratoEMaisCaro pedidoMaisBaratoEMaisCaro = new PedidoMaisBaratoEMaisCaro();
				
		System.out.println("Total de pedidos: "+pedidosCsv.size());
		System.out.println("Total de produtos vendidos: "+totalProdutosVendidos.calcularProdutos(pedidosCsv));
		System.out.println("Total de categorias: "+ totalCategorias.calcularCategorias(pedidosCsv));
		System.out.println("Montante de vendas: " + NumberFormat.getCurrencyInstance().format(montanteTotalVendas.calcularMontante(pedidosCsv)));
		pedidoMaisBaratoEMaisCaro.compararBaratoECaro(pedidosCsv);
	}

}
