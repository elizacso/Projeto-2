package POO.java;

public class ClienteNormal extends Cliente implements IDescreve {

	public ClienteNormal() {

	}
	
	@Override
	public void descrever() {
		System.out.println("Desconto de 10% aplicavel.");
	}


}