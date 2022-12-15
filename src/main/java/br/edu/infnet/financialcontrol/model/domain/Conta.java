package br.edu.infnet.financialcontrol.model.domain;

public class Conta {
    private String conta;
    private String tipoConta;
    private String banco;
    private Conta contaMae;

    public Conta(String conta, String banco, String tipoConta) {
        this.conta = conta;
        this.banco = banco;
        this.tipoConta = tipoConta;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipoConta() {
        return tipoConta;
    }
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    public Conta getContaMae(){
        return contaMae;
    }
    public void setContaMae(Conta contaMae){
        this.contaMae = contaMae;
    }
    
}
