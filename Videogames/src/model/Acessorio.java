package model;

public class Acessorio {
	private int id;
	private String nome;
	private int numero;
	
	public Acessorio() {}
	
	public Acessorio(int id, String nome, int numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Acessorio other = (Acessorio) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acessorio [id=" + id + ", nome=" + nome + ", numero=" + numero + "]";
	}	
}
