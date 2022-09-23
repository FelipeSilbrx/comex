package comex;

import java.text.SimpleDateFormat;


public class MainPedido {
	public static void main(String[] args) {
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente1 = new Cliente(1, "Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente(2, "Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife",
				"Pernambuco");
		Cliente cliente3 = new Cliente(3, "Gabi", "G123", 19877891, "rua zxc", "4", "A", "Boa Viagem", "Recife",
				"Pernambuco");
		
		Pedido pedido1 = new Pedido(1,spf.format(22-02-2022) ,cliente1);
		Pedido pedido2 = new Pedido(2,spf.format(19-10-2019) ,cliente2);
		Pedido pedido3 = new Pedido(3,spf.format(31-07-2022) ,cliente3);
		Pedido pedido4 = new Pedido(4,spf.format(26-02-2022) ,cliente1);
		Pedido pedido5 = new Pedido(5,spf.format(07-10-2019) ,cliente1);
		Pedido pedido6 = new Pedido(6,spf.format(15-07-2022) ,cliente2);
		
		System.out.println ("------------------\nPedido 1 \nId: "+pedido1.getId()
		+"\nData do Pedido: "+pedido1.getData()+"\nNome do Cliente: "
		+pedido1.cliente.getNome()
		+ "\n-----------------");
		System.out.println("------------------\nPedido 2 \nId: "+pedido2.getId()
		+"\nData do Pedido: "+pedido2.getData()+"\nNome do Cliente: "
		+pedido2.cliente.getNome()
		+ "\n-----------------");
		System.out.println("------------------\nPedido 3 \nId: "+pedido3.getId()
		+"\nData do Pedido: "+pedido4.getData()+"\nNome do Cliente: "
		+pedido3.cliente.getNome());
		System.out.println("------------------\nPedido 4 \nId: "+pedido4.getId()
		+"\nData do Pedido: "+pedido4.getData()+"\nNome do Cliente: "
		+pedido4.cliente.getNome()+
		"\n-----------------");
	}
}