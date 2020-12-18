package model;

public class Jogo {
	private int codigo;
	private String nome;
	private String lancamento;
	private int numero;
	private int cnpj;
		
	public Jogo() {}
		
	public Jogo(int codigo, String nome, String lancamento, int numero, int cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.lancamento = lancamento;
		this.numero = numero;
		this.cnpj = cnpj;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Jogo other = (Jogo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogo [codigo=" + codigo + ", nome=" + nome + ", lancamento=" + lancamento + ", numero=" + numero
				+ ", cnpj=" + cnpj + "]";
	}
	
}
