package br.edu.infnet.financialcontrol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.model.domain.Auth;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.exceptions.UserIncompletoException;
import br.edu.infnet.financialcontrol.model.repository.AcessoRepository;
import br.edu.infnet.financialcontrol.model.repository.UserRepository;

@Controller
public class AcessoController {
    @GetMapping(value = "/")
	public String telaIndex() {
		return telaLogin();
	}
    @GetMapping(value = "/login")
	public String telaLogin() {
		return "/acesso/login";
	}
    @PostMapping(value = "/login")
    public String verificarLogin(Auth auth){
        System.out.print("Response "+ auth);
        try {
            if(AcessoRepository.auth(auth) != null){
                return "redirect:/usuario/lista";
            }
        } catch (UserIncompletoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/";
    }
    
}
