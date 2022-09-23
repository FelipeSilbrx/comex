package comex;

public class Categoria {
 private int id;
 private String nome;
 private StatusCategoria status;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public StatusCategoria getStatus() {
	return status;
}
public void setStatus(StatusCategoria status) {	
		this.status = status;	
}

public Categoria(int id, String nome, StatusCategoria ativa) {
	super();
	this.id = id;
	this.nome = nome;
	this.status = ativa;
}

}
