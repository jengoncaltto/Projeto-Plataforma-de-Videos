package plataforma.main;

import java.util.ArrayList;
import java.util.List;
import plataforma.modelo.Usuario;
import plataforma.modelo.Video;

public class Main {
	public static void main(String[] args) {
		List<Video> listaVideos = new ArrayList<Video>();
		
		Usuario c1 = new Usuario("Isabelle", 22, "feminino", "araujobtc");
		Video f1 = new Video("JAVA POO", "Curso em Video", 20);
		Video f2 = new Video("Python", "Curso em Video", 40);
		listaVideos.add(f1);
		listaVideos.add(f2);
		Menu menuC1 = new Menu(c1, listaVideos);
		System.out.println("Aplicação encerrada");
	}
}
