package comex;

public class MainCategoria {
	 public static void main (String[] args) {
		
		Categoria informatica = new Categoria("INFORMATICA",StatusCategoria.ATIVA);
		Categoria moveis = new Categoria("M",StatusCategoria.INATIVA);
		Categoria livros = new Categoria("LIVROS",StatusCategoria.ATIVA);
		
		try {			
			moveis.ValidarConstrutor();
			livros.ValidarConstrutor();
			
		}catch(IllegalArgumentException IAex){
			String msg = IAex.getMessage();
			System.out.println("IllegalArgumentException " + msg);
		}
		/*
		System.out.println("Categoria " + informatica.getNome() + " ("+informatica.getId() +" - "+informatica.getStatus() +")");
		System.out.println("Categoria " + moveis.getNome() + " ("+moveis.getId() +" - "+moveis.getStatus() +")");
		System.out.println("Categoria " + livros.getNome() + " ("+livros.getId() +" - "+livros.getStatus() +")");
		*/
		
	 }
	 
	 
}
