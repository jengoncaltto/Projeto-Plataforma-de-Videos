package plataforma.main;

import java.util.List;
import java.util.Scanner;
import plataforma.modelo.Usuario;
import plataforma.modelo.Video;

public class Menu {
	Scanner scan = new Scanner(System.in);
	Usuario conta;
	List filmes;

	// código que não serão utilizados em herança, melhor estar private e não protected.
	
	
	public Menu(Usuario conta, List filmes) {
		this.conta = conta;
		this.filmes = filmes;
		int opcaoSelecionada;
		
		System.out.println("============= MENU =============");
		System.out.println("1. Selecionar um video.");
		System.out.println("2. Acessar o menu da conta do usuário.");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
		do {
			switch (opcaoSelecionada) {
			case 1:
				apresentandoLista();
				break;
			case 2:
				menuConta();
				break;
			case 0:
				break;
			default: 
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}

		} while (opcaoSelecionada != 0);
	}
	
	private void  apresentandoLista() {
		System.out.println("Selecione o indice de acordo com o video desejado: ");
		for (int i = 0; i < filmes.size(); i++) {
			System.out.println(i + ". " + filmes.get(i));
		}
		int aux = scan.nextInt();

		//if(aux >=0 && aux < filmes.size()){
		//	menuVideo(filmes.get(aux));
		//}else{
		//	System.out.println("Indice inválido. 
		//	Digite um número entre 0 e " + (filmes.sizes()-1));
		//}
	}
	
	protected void menuVideo(Video video) {
		int opcaoSelecionada;
		System.out.println("============= MENU DO VIDEO =============");
		System.out.println("1. Acessar a descrição do video");
		System.out.println("2. Ver a quantidade de curtidas no video");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
		do {
			switch (opcaoSelecionada) {
			case 1:
				acessarDescricaoVideo();
				break;
			case 2:
				verQuantidadeCurtidas();
				break;
			case 0:
				break;
			default: 
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}

		} while (opcaoSelecionada != 0);
	}
	
	protected void acessarDescricaoVideo() {
		System.out.println(filmes.get(0));
	}
	protected void verQuantidadeCurtidas() {
		System.out.println();
	}
	
	protected void menuConta() {
		int opcaoSelecionada;
		System.out.println("============= MENU DA SUA CONTA =============");
		System.out.println("1. Alterar nome");
		System.out.println("2. ");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
		do {
			switch (opcaoSelecionada) {
			case 1:
				mostrarInformacoesConta();
				break;
			case 2:
				quantidadeTotalVideosAssistidos();
				break;
			case 0:
				break;
			default: 
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}
		} while (opcaoSelecionada != 0);
	}
	
	protected void mostrarInformacoesConta() {
		System.out.println(conta.toString());
	}
	
	protected void quantidadeTotalVideosAssistidos() {
		System.out.println(conta.getTotalAssistido());
	}
}
