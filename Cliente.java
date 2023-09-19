package POO.java;

public abstract class Cliente {

	private String nome, sexo, servico;
	private float preco;
	
	public Cliente(String nome, String sexo, String servico,  float preco) {
				
		this.setSexo(sexo);
		this.setNome(nome);
		this.setServico(servico);
		this.setPreco(preco);
	}
	
	public Cliente(){}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("Dados invalidos. O nome do cliente nao pode estar vazio");
		} else {
			this.nome = nome;
		}
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		
		if(sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m")){
			this.sexo = sexo;
		} else {
			throw new IllegalArgumentException("Dados invalidos. O sexo deve ser 'F' ou 'M'.");
		}
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		if(servico.trim().equals("")) {
			throw new IllegalArgumentException("Dados invalidos. O nome do servico nao pode estar vazio");
		}
		this.servico = servico;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {
		System.out.println("Nome: " + nome + "\nSexo: " + sexo  + "\nServico: " + servico + "\nPreco: " + preco);
	}
	

}
