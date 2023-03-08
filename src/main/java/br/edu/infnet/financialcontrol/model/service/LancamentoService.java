package br.edu.infnet.financialcontrol.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.financialcontrol.model.domain.Lancamento;
import br.edu.infnet.financialcontrol.model.domain.User;
import br.edu.infnet.financialcontrol.model.service.interfaces.IService;
import br.edu.infnet.financialcontrol.model.service.model.ServiceModel;
import br.edu.infnet.financialcontrol.repository.LancamentosRepository;
import br.edu.infnet.financialcontrol.repository.UserRepository;

@Service
public class LancamentoService extends ServiceModel<LancamentosRepository,Lancamento> implements IService<Lancamento>  {

    @Autowired
    private static LancamentosRepository repository;

    LancamentoService() {
        super(repository);
    }

    public boolean add(Lancamento entity){
        return super.add(entity);
    }

    public Lancamento remove(Integer key){
        return super.remove(key);
    }

    public Collection<Lancamento> returnList(){
        return super.returnList();
    }

}
