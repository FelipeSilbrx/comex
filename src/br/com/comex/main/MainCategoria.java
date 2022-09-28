package br.com.comex.main;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.StatusCategoria;

public class MainCategoria {
	 public static void main (String[] args) {
		try {
			Categoria informatica = new Categoria("I",StatusCategoria.ATIVA);
			System.out.println("Categoria " + informatica.getNome() + " ("+informatica.getId() +" - "+informatica.getStatus() +")");
			
			Categoria moveis = new Categoria("MOVEIS",StatusCategoria.INATIVA);
			System.out.println("Categoria " + moveis.getNome() + " ("+moveis.getId() +" - "+moveis.getStatus() +")");
			
			Categoria livros = new Categoria("LIVROS",StatusCategoria.ATIVA);
			System.out.println("Categoria " + livros.getNome() + " ("+livros.getId() +" - "+livros.getStatus() +")");
			
			
		}catch(IllegalArgumentException ex){
			System.out.println("Ih deu Erro!: " + ex.getMessage());
			System.out.println("-------------");
		}
		
		
	 }
	 
	 
}
