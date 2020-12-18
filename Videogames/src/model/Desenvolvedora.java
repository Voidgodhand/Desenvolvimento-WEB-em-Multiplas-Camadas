package model;

import java.util.List;

public class Desenvolvedora {
	
	private int cnpj;
	private String nome;
	private List<Jogo> jogos;
	
	public Desenvolvedora() {}
	public Desenvolvedora(int cnpj, String nome, List<Jogo> jogos) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.jogos = jogos;
	}
	
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
		result = prime * result + cnpj;
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
		Desenvolvedora other = (Desenvolvedora) obj;
		if (cnpj != other.cnpj)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Desenvolvedora [cnpj=" + cnpj + ", nome=" + nome + ", jogos=" + jogos + "]";
	}
	

}
