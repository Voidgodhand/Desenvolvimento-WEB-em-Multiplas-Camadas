package model;

import java.util.List;

public class Console {
	
	private int numero;
	private String nome;
	private List<Acessorio> acessorios;
	private List<Controle> controles;
	private List<Jogo> jogos;
	
	public Console() {}
	public Console(int numero, String nome, List<Acessorio> acessorios, List<Controle> controles, List<Jogo> jogos) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.acessorios = acessorios;
		this.controles = controles;
		this.jogos = jogos;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	public List<Controle> getControles() {
		return controles;
	}
	public void setControles(List<Controle> controles) {
		this.controles = controles;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Console other = (Console) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Console [numero=" + numero + ", nome=" + nome + ", acessorios=" + acessorios + ", controles="
				+ controles + ", jogos=" + jogos + "]";
	}

}
