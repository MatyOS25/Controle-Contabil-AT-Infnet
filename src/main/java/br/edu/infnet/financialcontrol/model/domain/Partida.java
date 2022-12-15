package br.edu.infnet.financialcontrol.model.domain;

public class Partida extends Lancamento {

    private float debito;

    private float credito;
    
    public Partida(String name, float valor, String description, Conta conta ) {
        super(name, valor,description,conta);
        //TODO Auto-generated constructor stub
    }
    public Partida(String name, float valor, Conta conta) {
        super(name, valor, conta);
        //TODO Auto-generated constructor stub
    }
    @Override
    public float calcularValorFiscal() {
        // TODO Auto-generated method stub
        return 0;
    }
    public float getCredito() {
        return credito;
    }
    public void setCredito(float credito) {
        this.credito = credito;
    }


    public float getDebito() {
        return debito;
    }
    public void setDebito(float debito) {
        this.debito = debito;
    }
}
