package br.edu.infnet.financialcontrol.model.domain;

public abstract class Lancamento {
	private String name;
	private float valor;
	private String description;
	private Conta conta;


	public Lancamento(String name, float valor, String description,Conta conta) {
		this(name, valor, description);
		this.conta = conta;
	}
	public Lancamento(String name, float valor, Conta conta) {
		this(name, valor);
		this.conta = conta;
	}
	public Lancamento(String name, float valor, String description){
		this(name, valor);
		this.description = description;
	}

	public Lancamento(String name, float valor) {
		this.name = name;
		this.valor = valor;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();	
		return sb.toString();
	}
	
	public abstract float calcularValorFiscal();
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
