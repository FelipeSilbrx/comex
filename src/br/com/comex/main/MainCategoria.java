package br.com.comex.main;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class MainCategoria {
	 public static void main (String[] args) {
		try {
			Categoria informatica = new Categoria("IFORMATICA",StatusCategoria.ATIVA);
			System.out.println(informatica.toString());	
			Categoria moveis = new Categoria("MOVEIS",StatusCategoria.INATIVA);
			System.out.println(moveis.toString());
			
			Categoria livros = new Categoria("LIVROS",StatusCategoria.ATIVA);
			System.out.println(livros.toString());
			
			
		}catch(IllegalArgumentException ex){
			System.out.println("\nIh deu Erro!\n-> " + ex.getMessage());			
			System.out.println("-------------");
		}
		
		
	 }
	 
	 
}
