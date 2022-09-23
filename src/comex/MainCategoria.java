package comex;

public class MainCategoria {
	 public static void main (String[] args) {
		
		Categoria informatica = new Categoria(1,"INFORMÁTICA",StatusCategoria.ATIVA);
		Categoria moveis = new Categoria(2,"MÓVEIS",StatusCategoria.INATIVA);
		Categoria livros = new Categoria(3,"LIVROS",StatusCategoria.ATIVA);		
		
		System.out.println("Categoria " + informatica.getNome() + " ("+informatica.getId() +" - "+informatica.getStatus() +")");
		System.out.println("Categoria " + moveis.getNome() + " ("+moveis.getId() +" - "+moveis.getStatus() +")");
		System.out.println("Categoria " + livros.getNome() + " ("+livros.getId() +" - "+livros.getStatus() +")");
		
		
	 }
}
