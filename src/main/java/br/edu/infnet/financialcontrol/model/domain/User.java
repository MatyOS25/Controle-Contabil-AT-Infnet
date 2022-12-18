package br.edu.infnet.financialcontrol.model.domain;

import br.edu.infnet.financialcontrol.model.exceptions.UserIncompletoException;

public class User{
    private String nome;
    private String email;
    private String cpf;

    public User(String nome, String email, String cpf) throws UserIncompletoException {
    	if(nome == null || email == null || cpf == null) {
    		throw new UserIncompletoException("Nome, Email ou CPF estao com valor null");
    	}
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(email);
		
		return sb.toString();
	}

     public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }




  
}
