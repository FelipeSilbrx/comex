package comex;

public class  CalculadoraValorTotal {
	
	private double ValorTotal;
	private double aux_vt;
	
	public double Calcula(ValorQuantidade v) {
		double preco = v.getPreco();
		int quantidade = v.getQuantidade();
		aux_vt = preco * quantidade; 
		return this.ValorTotal+= aux_vt;
	}
		
}
