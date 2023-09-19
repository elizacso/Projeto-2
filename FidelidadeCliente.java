package POO.java;

public class FidelidadeCliente extends Cliente {
	
	public FidelidadeCliente(String nome, String sexo, String servico,  float preco) {
		super(nome, sexo, servico,  preco);
	}

	public FidelidadeCliente() {
		
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Preco para cliente fidelidade: R$" + this.getPreco() * 0.5);
	}
	
}