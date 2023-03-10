package br.edu.infnet.financialcontrol.controller;

import br.edu.infnet.financialcontrol.model.domain.Auth;
import br.edu.infnet.financialcontrol.model.exceptions.UserIncompletoException;
import br.edu.infnet.financialcontrol.repository.AcessoRepository;
import br.edu.infnet.financialcontrol.repository.UserRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class AcessoController {
  @GetMapping(value = "/")
  public String telaIndex() {
    return "index";
  }

  @GetMapping(value = "/error")
  public String telaError404() {
    return "error";
  }

  @GetMapping(value = "/login")
  public String telaLogin() {
    return "/acesso/login";
  }


  @PostMapping(value = "/login")
  public String verificarLogin(Model model, Auth auth) {
    System.out.print("Response " + auth);
    try {
      var getAuth = AcessoRepository.auth(auth);
      if (getAuth != null) {
        UserRepository.add(getAuth);
        model.addAttribute("usuario", getAuth);
        return "redirect:/";
      }
    } catch (UserIncompletoException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    model.addAttribute("mensagem", "As credenciais estão invalidas para: " +
                                       auth.getEmail());
    return telaLogin();
  }

  @GetMapping(value = "/logout")
  public String logout(HttpSession session, SessionStatus status) {
    status.setComplete();
    session.removeAttribute("usuario");
    return "redirect:/";
  }
}
