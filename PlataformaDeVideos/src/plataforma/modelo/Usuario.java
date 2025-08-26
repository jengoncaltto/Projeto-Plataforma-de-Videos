package plataforma.modelo;
public class Usuario extends Pessoa{
	private String login;
	private int totalAssistido;
	
	public Usuario(String nome, int idade, String genero, String login) {
		super(nome, idade, genero);
		this.totalAssistido = 0;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getTotalAssistido() {
		return totalAssistido;
	}
	public void setTotalAssistido(int totalAssistido) {
		this.totalAssistido = totalAssistido;
	}

	@Override
	public String toString() {
		return "Usuario [" + super.toString() +"\nlogin=" + login + ", totalAssistido=" + totalAssistido + "]";
	}
	
	
}
