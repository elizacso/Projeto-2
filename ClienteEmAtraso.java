package POO.java;

public class ClienteEmAtraso extends Cliente implements IDescreve{

	public ClienteEmAtraso() {}
	
	@Override
	public void descrever() {
		System.out.println("Cliente possui boletos em aberto.");
	}

}