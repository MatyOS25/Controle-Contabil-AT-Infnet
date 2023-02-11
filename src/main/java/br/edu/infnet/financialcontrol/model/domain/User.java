package br.edu.infnet.financialcontrol.model.domain;

import br.edu.infnet.financialcontrol.model.exceptions.UserIncompletoException;

public class User{
    private String nome;
    private String email;
    private String cpf;
    private String senha;

    public User(String nome, String email, String cpf, String senha) throws UserIncompletoException {
    	if(nome == null || nome == "" || email == null || email == "" || cpf == null || cpf == "" || senha == null || senha == "" ) {
    		throw new UserIncompletoException("Nome, Email ou CPF estao com valor null");
    	}
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
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

	public String getSenha() {
		return senha;
	}




  
}
