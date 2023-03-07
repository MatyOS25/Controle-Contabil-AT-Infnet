package br.edu.infnet.financialcontrol.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean add(User entity){
        return repository.add(entity);
    }

    public User remove(Integer key){
        return repository.removeUser(key);
    }

    public Collection<User> returnList(){
        return repository.returnList();
    }

}
