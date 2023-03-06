package br.edu.infnet.financialcontrol.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.repository.UserRepository;

@Controller
public class ReceitasController {
    private String msg;

    @GetMapping(value = "/receitas/lista")
	public String getReceitas(Model model) {
        model.addAttribute("usuarios", UserRepository.returnList());
        model.addAttribute("mensagem", msg); 
        msg = null;
		return "receitas/lista";
	}
}
