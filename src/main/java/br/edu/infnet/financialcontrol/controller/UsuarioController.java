package br.edu.infnet.financialcontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.model.domain.User;

@Controller
public class UsuarioController {
	
	@GetMapping(value = "/")
	public String telaIndex() {
		return "index";
	}
	
	@GetMapping(value = "/usuario")
	public String getTelaCadastro() {
		return "usuario/cadastro";
	}

    @PostMapping(value = "/usuario")
    public String postUser(User usuario){
        try{
            return responseUser(usuario);
        }
        catch(Exception e ){
            System.out.println("Falha ao cadastrar! ");
            return getTelaCadastro();
        }
    }
    public String responseUser(User usuario){
        System.out.println("Usuario cadastrado: "+ usuario);
        return "usuario/confirmacao";
    }
    
    
    

}
