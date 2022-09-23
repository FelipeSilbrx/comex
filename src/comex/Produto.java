package comex;

public class Produto {
	 private int id;
	 private String nome;
	 private String descricao;
	 private double preco_unitario;
	 private int qtd_estoque;
	 Categoria categoriaProduto;
	 
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public int getQtd_estoque() {
		return qtd_estoque;
	}
	public void setQtd_estoque(int qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}
	public Categoria getCategoriaProduto() {
		return categoriaProduto;
	}
	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	 
	public double CalcularValorEstoque() {
		return qtd_estoque * preco_unitario;
	}
	
	public double CalcularImpostoUnitario() {
		return preco_unitario * 0.4;
	}
	
	public Produto(int id, String nome, double preco_unitario, int qtd_estoque,
			Categoria categoriaProduto) {
		super();
		this.id = id;
		this.nome = nome;		
		this.preco_unitario = preco_unitario;
		this.qtd_estoque = qtd_estoque;
		this.categoriaProduto = categoriaProduto;
		
	}
	
}
