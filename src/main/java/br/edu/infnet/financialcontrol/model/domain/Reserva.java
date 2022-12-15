package br.edu.infnet.financialcontrol.model.domain;

public class Reserva extends Lancamento {

    public Reserva(String name, float valor) {
        super(name, valor);
        //TODO Auto-generated constructor stub
    }

    @Override
    public float calcularValorFiscal() {
        // TODO Auto-generated method stub
        return 0;
    }

}
