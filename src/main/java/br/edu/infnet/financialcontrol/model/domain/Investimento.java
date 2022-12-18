package br.edu.infnet.financialcontrol.model.domain;

public abstract class Investimento {
    private float valor;
    private String setor;

    public Investimento(String setor, float valor) {
        this.setor = setor;
        this.valor = valor;
    }

    public String getSetor() {
        return setor;
    }
    
    public float getValor() {
        return valor;
    }
}
