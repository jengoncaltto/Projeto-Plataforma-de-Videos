package plataforma.main;

import java.util.List;
import java.util.Scanner;
import plataforma.modelo.Usuario;
import plataforma.modelo.Video;
import plataforma.modelo.Visualizacao;

public class Menu {
	Scanner scan = new Scanner(System.in);
	Usuario conta;
	Video video;
	List filmes;
	int opcaoSelecionada;

	public Menu(Usuario conta, List filmes) {
		this.conta = conta;
		this.filmes = filmes;
		do {
		System.out.println("\n============= MENU =============");
		System.out.println("1. Selecionar um video.");
		System.out.println("2. Acessar o menu da conta do usuário.");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
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
	
	private void apresentandoLista() {
		Video videoIesimaPosicao;
		System.out.println("\nSelecione o indice de acordo com o video desejado: ");
		for (int i = 0; i < filmes.size(); i++) {
			videoIesimaPosicao = (Video) filmes.get(i);
			System.out.println(i + ". " + videoIesimaPosicao.getTitulo());
		}
		int indiceVideoSelecionado = scan.nextInt();

		if(indiceVideoSelecionado >=0 && indiceVideoSelecionado < filmes.size()){
			video =(Video) filmes.get(indiceVideoSelecionado);
			menuVideo();
		}else{
		    System.out.println("Indice inválido. Digite um número entre 0 e " + (filmes.size() -1));
		}
	}
	
	private void menuVideo() {
		do {
		System.out.println("\n============= MENU DO VIDEO =============");
		System.out.println("1. Acessar a descrição do video");
		System.out.println("2. Ver a quantidade de curtidas no video");
		System.out.println("3. Dar play no video.");
		System.out.println("4. Dar pause no video.");
		System.out.println("5. Curtir o video.");
		System.out.println("6. Comentar no video.");
		System.out.println("7. Compartilhar video.");
		System.out.println("8. Avaliar video.");
		System.out.println("9. Ver lista de comentários.");
		System.out.println("10. RETORNAR AO MENU PRINCIPAL.");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
			switch (opcaoSelecionada) {
			case 1:
				acessarDescricaoVideo();
				break;
			case 2:
				verQuantidadeCurtidas();
				break;
			case 3: 
				playNoVideo();
				break;
			case 4:
				pauseNoVideo();
				break;
			case 5:
				curtindoVideo();
				break;
			case 6:
				comentandoVideo();
				break;
			case 7:
				compartilhandoVideo();
				break;
			case 8:
				avaliandoVideo();
				break;
			case 9:
				verListaComentarios();
				break;
			case 10:
				return;
			case 0:
				break;
			default: 
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}

		} while (opcaoSelecionada != 0);
	}
	
	private void acessarDescricaoVideo() {
		System.out.println("\n" + video.toString() + "\n");
	}
	private void verQuantidadeCurtidas() {
		System.out.println("\nQuantidade de curtidas: " + video.getCurtidas() + "\n");
	}
	private void playNoVideo() {
		video.play();
		System.out.println("Assistindo video.\n");
	}
	private void pauseNoVideo() {
		video.pause();
		System.out.println("Video pausado.\n");
	}
	private void curtindoVideo() {
		video.like();
		System.out.println("Video foi curtido.\n");
	}
	private void comentandoVideo() {
		String comentario;
		scan.nextLine();
		System.out.println("Comentário: ");
		comentario = scan.nextLine();
		video.comentar(conta.getLogin() + ": " + comentario);
		System.out.println("Comentário enviado!\n");
	}
	private void compartilhandoVideo() {
		video.compartilhar();
		System.out.println("Video compartilhado\n");
	}
	private void avaliandoVideo() {
		Visualizacao view = new Visualizacao(conta, video);
		float nota;
		System.out.println("Selecione sua nota de 0 a 10: ");
		nota = scan.nextFloat();
		if(nota < 0 && nota > 10) {
			System.out.println("Número Inválido. Selecione outro número.");
		}else {
			view.avaliar(nota);
		}
	}
	private void verListaComentarios() {
		System.out.println("\nComentários:\r");
		for (int i = 0; i < video.getQuantidadeComentarios(); i++) {
			System.out.println((i+1)  + ". " + video.getListaComentarios().get(i));
		}
	}
	
	private void menuConta() {
		do {
		System.out.println("\n============= MENU DA SUA CONTA =============");
		System.out.println("1. Mostrar informações da sua conta.");
		System.out.println("2. Ver a quantidade total de videos assistidos.");
		System.out.println("3. Alterar nome de usuário.");
		System.out.println("4. Alterar gênero do usuário.");
		System.out.println("5. Retornar ao menu principal");
		System.out.println("0. SAIR DO MENU!");
		System.out.println("Insira sua opção: ");
		opcaoSelecionada = scan.nextInt();
			switch (opcaoSelecionada) {
			case 1:
				mostrarInformacoesConta();
				break;
			case 2:
				quantidadeTotalVideosAssistidos();
				break;
			case 3: 
				alterarNomeUsuario();
				break;
			case 4:
				alterarGeneroUsuario();
				break;
			case 5:
				return;
			case 0:
				break;
			default: 
				System.out.println("OPÇÃO INVÁLIDA!\n");
				break;
			}
		} while (opcaoSelecionada != 0);
	}
	
	private void mostrarInformacoesConta() {
		System.out.println("\n" + conta.toString() + "\n");
	}
	
	private void quantidadeTotalVideosAssistidos() {
		System.out.println("\nVideos Assistidos: " + conta.getTotalAssistido() + "\n");
	}
	
	private void alterarNomeUsuario() {
		scan.nextLine();
		System.out.println("Seu nome: " + conta.getNome() + "\nAlterar nome para: ");
		conta.setNome(scan.nextLine());
		System.out.println("\nNome atualizado para: " + conta.getNome());
	}
	
	private void alterarGeneroUsuario() {

		scan.nextLine();
		System.out.println("Seu gênero: " + conta.getGenero() + "\nAlterar gênero para: ");
		conta.setGenero(scan.nextLine());
		System.out.println("\nGênero atualizado para: " + conta.getGenero());
	}
}
