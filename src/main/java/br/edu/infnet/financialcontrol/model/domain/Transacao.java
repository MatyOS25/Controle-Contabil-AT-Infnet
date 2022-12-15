package br.edu.infnet.financialcontrol.model.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Transacao {
	
	private Timestamp data;
	
	private Lancamento[] lancamentos;
	

	public Transacao(Timestamp data, Lancamento[] lancamentos) {
		this.data = data;
		this.lancamentos = lancamentos;
	}

	public Lancamento[] getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(Lancamento[] lancamentos) {
		this.lancamentos = lancamentos;
	}

	public String getData() {
		String date = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
		return date;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
	
	public void setToday() {
		this.data = new Timestamp(System.currentTimeMillis());
	}



}
