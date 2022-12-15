package br.edu.infnet.financialcontrol.model.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Provisao extends Lancamento {

    private Timestamp dataPrev; 
    private Boolean saida = true;
    private String infoAdicional;
    
    
    public Provisao(String name, float valor, Timestamp dataPrev, Boolean saida) {
        super(name, valor);
        this.dataPrev =dataPrev;
        this.saida = saida;
    }
    public Provisao(String name, float valor, Timestamp dataPrev) {
        super(name, valor);
        this.dataPrev = dataPrev;
    }
    @Override
    public float calcularValorFiscal() {
        return 0;
    }

    public String getData() {
		String date = new SimpleDateFormat("dd/MM/yyyy").format(dataPrev.getTime());
		return date;
	}

	public void setData(Timestamp dataPrev) {
		this.dataPrev = dataPrev;
	}
    public Boolean getSaida() {
        return saida;
    }
    public void setSaida(Boolean saida) {
        this.saida = saida;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }
    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
