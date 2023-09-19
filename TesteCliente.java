package POO.java;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class TesteCliente {

	private static LinkedList<Cliente> fila = new LinkedList<Cliente>();
	private static Scanner scanner ;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		int opcao = 0;
		while(true) {
			
			System.out.println("""
			\nEscolha uma opcao:
			1 - Agendar Normal
			2 - Agendar Fidelidade
			3 - Agendar Cliente Em Atraso
			4 - Chamar
			5 - Listar Todos
			6 - Selecionar
			0 - Sair
			""");
			
			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Voce deve digitar um numero.");
				continue;
			} finally {
				scanner.nextLine();
			}
			

			if(opcao == 0) {
				scanner.close();
				break;
			} else if (opcao == 1) {
				agendarNormal();
			} else if (opcao == 2) {
				agendarFidelidade();
			} else if (opcao == 3) {
				agendarClienteEmAtraso();
			} else if (opcao == 4) {
				chamarCliente();
			} else if(opcao == 5) {
				listarTodos();
			} else if(opcao == 6) {
				selecionar();
			} else {
				System.out.println("Opcao invalida.");
			}
		}
	}
	
	
	private static void agendarNormal() {
		ClienteNormal cliente = new ClienteNormal();
		solicitaDadosCliente(cliente);
		
		fila.add(cliente);

	}
	

	private static void agendarFidelidade() {
		FidelidadeCliente cliente = new FidelidadeCliente();
		solicitaDadosCliente(cliente);
		
		fila.add(cliente);

	}
	

	private static void agendarClienteEmAtraso() {
		ClienteEmAtraso cliente = new ClienteEmAtraso();
		solicitaDadosCliente(cliente);
		
		fila.add(cliente);

	}
	
	
	private static void chamarCliente() {
		Cliente cliente = fila.poll();
		System.out.println("O cliente abaixo foi chamado: \n");
		try {
			mostraDadosCliente(cliente);
		} catch (NullPointerException ex) {
			System.out.println("Erro: A fila está vazia.");
		}
	}
	
	private static void solicitaDadosCliente(Cliente cliente) {
		while(true) {
			try {
				
				System.out.println("Digite o nome:");
				String nome = scanner.nextLine();
				cliente.setNome(nome);
				
				System.out.println("Digite o sexo: ");
				cliente.setSexo(scanner.nextLine());
				
				System.out.println("Digite o servico: ");
				cliente.setServico(scanner.nextLine());
				
				System.out.println("Digite o valor: ");
				cliente.setPreco(scanner.nextFloat());
				
				System.out.println("\nServiço agendado: ");
				mostraDadosCliente(cliente);

			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
				continue;
			}

			break;
		}
	}
	
	private static void mostraDadosCliente(Cliente cliente) {
		try {
			
			cliente.visualizar();
			( (IDescreve) cliente ).descrever();

		} catch (ClassCastException ex) {
			
		}
		
		System.out.println("");
	}
	
	private static void listarTodos() {
		System.out.println("\nExibindo os agendamentos de hoje.\n");
		for(Cliente cliente: fila) {
			
			mostraDadosCliente(cliente);
		}
	}

	private static void selecionar() {
		int posicao;
		while (true) {
			System.out.println("\nInforme um numero inteiro");
			System.out.println("Para voltar ao menu anterior digite -1.\n");
			
			try {
				posicao = scanner.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Voce deve digitar um numero.");
				continue;
			} finally {
				scanner.nextLine();
			}
			
			if(posicao < 0 ) {
				break;
			} 
			
			try {
				Cliente cliente = fila.get(posicao);
				mostraDadosCliente(cliente);
			} catch (IndexOutOfBoundsException ex) {
				System.out.println(ex);
			}
			
			
		}
	}
}