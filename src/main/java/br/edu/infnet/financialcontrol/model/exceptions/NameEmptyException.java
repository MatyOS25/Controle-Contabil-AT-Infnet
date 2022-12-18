package br.edu.infnet.financialcontrol.model.exceptions;

public class NameEmptyException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NameEmptyException(String mensagem){
		super(mensagem);
	}
}
