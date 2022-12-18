package br.edu.infnet.financialcontrol.model.exceptions;

public class UserIncompletoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserIncompletoException(String mensagem){
		super(mensagem);
	}
}
