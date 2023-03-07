package br.edu.infnet.financialcontrol.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.model.domain.Lancamento;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.repository.LancamentosRepository;
import br.edu.infnet.financialcontrol.repository.PartidasRepository;
import br.edu.infnet.financialcontrol.repository.UserRepository;

@Controller
public class LancamentoController {
    private String msg;

    @GetMapping(value = "/lancamentos/lista")
	public String getReceitas(Model model) {
        model.addAttribute("lista", LancamentosRepository.returnList());
        model.addAttribute("mensagem", msg); 
        msg = null;
		return "lancamentos/lista";
	}

    @GetMapping(value = "/lancamentos/new")
    public String getTelaCadastro() {
        return "lancamentos/new";
    }

    @PostMapping(value = "/lancamentos/new")
    public String post(Model model, Lancamento entidade) {
        System.out.println("Return Transacao: " + entidade);

        try {
        var response = LancamentosRepository.add(entidade);
        if (response == false) {
            throw new Exception("Error ao incluir");
        }
        msg = entidade.getId() + " incluido com sucesso!";
        return "redirect:/lancamentos/lista";

        } catch (Exception e) {
        System.out.println("Falha ao cadastrar! ");
        return getTelaCadastro();
        }
    }

    @GetMapping(value = "/lancamentos/{id}/excluir")
    public String getRemove(@PathVariable Integer id) {
        Lancamento entidade = LancamentosRepository.remove(id);
        msg = "Exclusão " + entidade.getId() + " realizada com sucesso";
        return "redirect:/lancamentos/lista";
    }
    
}