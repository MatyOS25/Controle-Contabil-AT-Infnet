package br.edu.infnet.financialcontrol.controller;

import br.edu.infnet.financialcontrol.model.service.IService;

public class IController<T extends IService> {
	public String getLista(Model model) {
        model.addAttribute("lista", T.returnList());
        model.addAttribute("mensagem", msg); 
        msg = null;
		return controller +"/lista";
	}

    public String getTelaCadastro() {
        return "lancamentos/new";
    }

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

    public String getRemove(@PathVariable Integer id) {
        Lancamento entidade = LancamentosRepository.remove(id);
        msg = "Exclusão " + entidade.getId() + " realizada com sucesso";
        return "redirect:/lancamentos/lista";
    }
}
