package br.edu.infnet.financialcontrol.model.exceptions;

public class FormatoDataException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FormatoDataException(String mensagem){
		super(mensagem);
	}
}
