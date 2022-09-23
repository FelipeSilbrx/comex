package comex;



public class Pedido {
private int id;
private String data;
Cliente cliente;

public int getId() {
	return id;
}
public String getData() {
	return data;
}
public Cliente getCliente() {
	return cliente;
}
public Pedido(int id, String data, Cliente cliente) {
	super();
	this.id = id;
	this.data = data;
	this.cliente = cliente;
}


}
