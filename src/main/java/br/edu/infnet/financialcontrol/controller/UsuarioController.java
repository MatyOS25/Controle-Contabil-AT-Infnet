package br.edu.infnet.financialcontrol.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.repository.UserRepository;

@Controller
public class UsuarioController {
	@GetMapping(value = "/usuario")
	public String getTelaCadastro() {
		return "usuario/cadastro";
	}

    @GetMapping(value = "usuario/lista")
	public String getUsers() {
        List<User> users = UserRepository.returnList();
        System.out.println("Users cadastrados: " + users.size());
		return "index";
	}

    @PostMapping(value = "/usuario")
    public String postUser(User usuario){
        System.out.println("Return User: " + usuario);
        try{
            UserRepository.add(usuario);
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
