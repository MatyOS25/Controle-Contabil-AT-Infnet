package br.edu.infnet.financialcontrol.repository;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.domain.Auth;
import br.edu.infnet.financialcontrol.model.exceptions.UserIncompletoException;

public class AcessoRepository {
    public static User auth(Auth auth) throws UserIncompletoException{
        if(auth.getEmail().equalsIgnoreCase(auth.getSenha())){
                return new User(auth.getEmail(), auth.getSenha(), "Acesso 1", "000.000.000-00");
        }
        return null;
    }
}
