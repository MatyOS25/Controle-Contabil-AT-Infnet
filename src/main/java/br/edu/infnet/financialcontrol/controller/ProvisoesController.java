package br.edu.infnet.financialcontrol.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.financialcontrol.model.domain.Provisao;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.exceptions.DataPrevNullException;
import br.edu.infnet.financialcontrol.model.exceptions.FormatoDataException;
import br.edu.infnet.financialcontrol.model.exceptions.NameEmptyException;
import br.edu.infnet.financialcontrol.repository.ProvisoesRepository;
import br.edu.infnet.financialcontrol.repository.UserRepository;

@Controller
public class ProvisoesController {
    private String msg;

    @GetMapping(value = "/provisoes/lista")
	public String getReceitas(Model model) {
        model.addAttribute("lista", ProvisoesRepository.returnList());
        model.addAttribute("mensagem", msg); 
        msg = null;
		return "provisoes/lista";
	}

    @GetMapping(value = "/provisoes/new")
    public String getTelaCadastro() {
        return "provisoes/new";
    }

    @PostMapping(value = "/provisoes/new")
    public String post(Model model, @RequestParam String name, @RequestParam LocalDate dataPrev, @RequestParam Float valor, @RequestParam Boolean saida) {
        Provisao entidade = null;
        try {
            entidade = new Provisao(name , valor, dataPrev, saida);
        } catch (FormatoDataException | NameEmptyException | DataPrevNullException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Return Transacao: " + entidade);

        try {
        var response = ProvisoesRepository.add(entidade);
        if (response == false) {
            throw new Exception("Error ao incluir");
        }
        msg = entidade.getId() + " incluido com sucesso!";
        return "redirect:/provisoes/lista";

        } catch (Exception e) {
        System.out.println("Falha ao cadastrar! ");
        return getTelaCadastro();
        }
    }

    @GetMapping(value = "/provisoes/{id}/excluir")
    public String getRemove(@PathVariable Integer id) {
        Provisao entidade = ProvisoesRepository.remove(id);
        msg = "Exclus??o " + entidade.getId() + " realizada com sucesso";
        return "redirect:/provisoes/lista";
    }
}