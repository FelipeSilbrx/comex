package comex;

public class MainCliente {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "Ana", "A123", 12344321, "rua 123", "21", "C", "Torrões", "Recife",
				"Pernambuco");
		Cliente cliente2 = new Cliente(2, "Eli", "E123", 12122121, "rua abc", "3", "D", "Torre", "Recife",
				"Pernambuco");
		Cliente cliente3 = new Cliente(3, "Gabi", "G123", 19877891, "rua zxc", "4", "A", "Boa Viagem", "Recife",
				"Pernambuco");

		System.out.println("------------------ \nCliente: " + cliente1.getNome() + "\nId do Cliente: " + cliente1.getId()
				+ "\nCPF do cliente: " + cliente1.getCpf() + "\nTelefone: " + cliente1.getTelefone() + "\nRua: "
				+ cliente1.getRua() + "\nNúmero do endereço: " + cliente1.getNumero() + "\nComplemento do endereço: "
				+ cliente1.getBairro() + "\nCidade: " + cliente1.getCidade() + "\nEstado: " + cliente1.getEstado()
				+ "\n-----------------");
		System.out.println("----------------- \nCliente: " + cliente2.getNome() + "\nId do Cliente: " + cliente2.getId()
				+ "\nCPF do cliente: " + cliente2.getCpf() + "\nTelefone: " + cliente2.getTelefone() + "\nRua: "
				+ cliente2.getRua() + "\nNúmero do endereço: " + cliente2.getNumero() + "\nComplemento do endereço: "
				+ cliente2.getBairro() + "\nCidade: " + cliente2.getCidade() + "\nEstado: " + cliente2.getEstado()
				+ "\n-----------------");
		System.out.println("----------------- \nCliente: " + cliente3.getNome() + "\nId do Cliente: " + cliente3.getId()
				+ "\nCPF do cliente: " + cliente3.getCpf() + "\nTelefone: " + cliente3.getTelefone() + "\nRua: "
				+ cliente3.getRua() + "\nNúmero do endereço: " + cliente3.getNumero() + "\nComplemento do endereço: "
				+ cliente3.getBairro() + "\nCidade: " + cliente3.getCidade() + "\nEstado: " + cliente3.getEstado()
				+ "\n-----------------");
	}
}
