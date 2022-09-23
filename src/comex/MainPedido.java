package comex;

import java.text.SimpleDateFormat;


public class MainPedido {
	public static void main(String[] args) {
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente1 = new Cliente( "Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente( "Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife",
				"Pernambuco");
		Cliente cliente3 = new Cliente("Gabi", "G123", 19877891, "rua zxc", "4", "A", "Boa Viagem", "Recife",
				"Pernambuco");
		
		Pedido pedido1 = new Pedido(spf.format(22-02-2022) ,cliente1);
		Pedido pedido2 = new Pedido(spf.format(19-10-2019) ,cliente2);
		Pedido pedido3 = new Pedido(spf.format(31-07-2022) ,cliente3);
		Pedido pedido4 = new Pedido(spf.format(26-02-2022) ,cliente1);
		
		
		System.out.println ("------------------\nPedido \nId: "+pedido1.getId()
		+"\nData do Pedido: "+pedido1.getData()+"\nNome do Cliente: "
		+pedido1.cliente.getNome()
		+ "\n-----------------");
		System.out.println("------------------\nPedido \nId: "+pedido2.getId()
		+"\nData do Pedido: "+pedido2.getData()+"\nNome do Cliente: "
		+pedido2.cliente.getNome()
		+ "\n-----------------");
		System.out.println("------------------\nPedido \nId: "+pedido3.getId()
		+"\nData do Pedido: "+pedido4.getData()+"\nNome do Cliente: "
		+pedido3.cliente.getNome());
		System.out.println("------------------\nPedido \nId: "+pedido4.getId()
		+"\nData do Pedido: "+pedido4.getData()+"\nNome do Cliente: "
		+pedido4.cliente.getNome()+
		"\n-----------------");
	}
}