package br.com.comex.main;

import br.com.comex.modelo.Cliente;

public class MainCliente {
	public static void main(String[] args) {
		try {
			Cliente cliente1 = new Cliente("Ana Carolina", "111.111.111-11", "81 9 88785225", "rua 123", "21", "CASA C", "Torrões", "Recife",
					"Pe");
			Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "81 9 87785825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
					"Pe");
			Cliente cliente3 = new Cliente("Gabriela", "333.333.333-22", "82 9 87785825", "rua zxc", "04", "S/N", "Boa Viagem", "Recife",
					"Pe");
			System.out.println(cliente1.toString());
			System.out.println("\n-----------------");
			System.out.println(cliente2.toString());
			System.out.println("\n-----------------");
			System.out.println(cliente3.toString());
			System.out.println("\n-----------------");
		}catch (IllegalArgumentException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		
	}
}
