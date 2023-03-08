package br.edu.infnet.financialcontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.financialcontrol.controller.model.ControllerModel;
import br.edu.infnet.financialcontrol.model.domain.Lancamento;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.service.LancamentoService;
import br.edu.infnet.financialcontrol.repository.LancamentosRepository;
import br.edu.infnet.financialcontrol.repository.PartidasRepository;
import br.edu.infnet.financialcontrol.repository.UserRepository;

@Controller
public class LancamentoController extends ControllerModel<Lancamento, LancamentoService> {
    public static final String controller = "lancamentos";

    @Autowired
    private static LancamentoService service;
    
    LancamentoController() {
        super(service, controller);
    }

    @GetMapping(value = "/"+ controller + "/lista")
	public String getLista(Model model) {
        return super.getLista(model);
	}

    @GetMapping(value = "/" + controller + "/new")
    public String getTelaCadastro() {
        return super.getTelaCadastro();
    }

    @PostMapping(value = "/"+ controller +"/new")
    public String post(Model model, Lancamento entidade) {
        return super.post(model, entidade);
    }

    @GetMapping(value = "/"+ controller +"/{id}/excluir")
    public String getRemove(@PathVariable Integer id) {
        return super.getRemove(id);
    }
    
}