package br.edu.infnet.financialcontrol.controller;

import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
  private String msg;

  @GetMapping(value = "/usuario")
  public String getTelaCadastro() {
    return "usuario/cadastro";
  }

  @GetMapping(value = "/usuario/lista")
  public String getUsers(Model model) {
    model.addAttribute("usuarios", UserRepository.returnList());
    model.addAttribute("mensagem", msg);
    msg = null;
    return "usuario/lista";
  }

  @PostMapping(value = "/usuario")
  public String postUser(Model model, User usuario) {
    System.out.println("Return User: " + usuario);

    try {
      var response = UserRepository.add(usuario);
      if (response == false) {
        throw new Exception("Error ao incluir");
      }
      msg = usuario.getNome() + " incluido com sucesso!";
      return "redirect:/";

    } catch (Exception e) {
      System.out.println("Falha ao cadastrar! ");
      return getTelaCadastro();
    }
  }

  @GetMapping(value = "/usuario/{id}/excluir")
  public String getRemove(@PathVariable Integer id) {
    User user = UserRepository.removeUser(id);
    msg = "Exclusão do usuario " + user.getNome() + " realizada com sucesso";
    return "redirect:/usuario/lista";
  }
}
