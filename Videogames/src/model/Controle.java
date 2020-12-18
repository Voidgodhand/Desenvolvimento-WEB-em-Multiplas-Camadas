package model;

public class Controle {
	private int seq;
	private String cor;
	private int numero_botoes;
	private int numero;
	
	public Controle() {}
		
	public Controle(int seq, String cor, int numero_botoes, int numero) {
		super();
		this.seq = seq;
		this.cor = cor;
		this.numero_botoes = numero_botoes;
		this.numero = numero;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getNumero_botoes() {
		return numero_botoes;
	}

	public void setNumero_botoes(int numero_botoes) {
		this.numero_botoes = numero_botoes;
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
		result = prime * result + seq;
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
		Controle other = (Controle) obj;
		if (seq != other.seq)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Controle [seq=" + seq + ", cor=" + cor + ", numero_botoes=" + numero_botoes + ", numero=" + numero
				+ "]";
	}
	
}
