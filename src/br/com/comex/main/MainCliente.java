package br.com.comex.main;

import br.com.comex.modelo.Cliente;

public class MainCliente {
	public static void main(String[] args) {
		try {
			Cliente cliente1 = new Cliente("Ana Carolina", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
					"Pe");
			Cliente cliente2 = new Cliente("Elizabeth", "E123", 12122121, "rua abc", "03", "D", "Torre", "Recife",
					"Pe");
			Cliente cliente3 = new Cliente("Gabriela", "G123", 19877891, "rua zxc", "04", "A", "Boa Viagem", "Recife",
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
