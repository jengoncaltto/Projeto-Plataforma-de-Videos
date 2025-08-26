package plataforma.modelo;

import plataforma.interfaces.AcoesVideo;

public class Video implements AcoesVideo {
	private String titulo;
	private int avaliacao;
	private String descricao; // add 
	private int views;
	private int curtidas;
	private int comentarios; //add
	private int compartilhamentos;  //add
	private boolean reproduzindo;
	private float tempoTotalVideo;  // add 
	
	public Video(String titulo, String descricao, float tempoReproducao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.views = 0;
		this.curtidas = 0;
		this.reproduzindo = false;
		this.tempoTotalVideo = tempoReproducao;
		this.comentarios = 0;
		this.compartilhamentos = 0;
	}
	
	@Override
	public void comentar() {
		this.comentarios++;
	}

	@Override
	public void compartilhar() {
		this.compartilhamentos++;
	}

	@Override
	public void play() {
		this.reproduzindo = true;
	}

	@Override
	public void pause() {
		this.reproduzindo = false;
	}

	@Override
	public void like() {
		this.curtidas++;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public boolean isReproduzindo() {
		return reproduzindo;
	}

	public void setReproduzindo(boolean reproduzindo) {
		this.reproduzindo = reproduzindo;
	}

	public float getTempoReproducao() {
		return tempoTotalVideo;
	}

	public void setTempoReproducao(float tempoReproducao) {
		this.tempoTotalVideo = tempoReproducao;
	}

	@Override
	public String toString() {
		return "Video [titulo=" + titulo + ", descricao=" + descricao + ", views=" + views + ", curtidas=" + curtidas
				+ ", reproduzindo=" + reproduzindo + ", tempoTotalVideo=" + tempoTotalVideo + "]";
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		int nova; 
		nova = (int) (this.avaliacao + avaliacao/this.views);
		this.avaliacao = nova;
	}
}
