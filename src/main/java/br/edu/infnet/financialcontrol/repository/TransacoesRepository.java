package br.edu.infnet.financialcontrol.repository;
import br.edu.infnet.financialcontrol.model.domain.Transacao;
import br.edu.infnet.financialcontrol.model.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.Collection;

public class TransacoesRepository {
    private static Integer id = 1;
    private static Map<Integer,Transacao> mappedEntity = new HashMap<Integer, Transacao>();
    public static boolean add(Transacao entity){
        try{
            entity.setId(id++);
            mappedEntity.put(entity.getId(),entity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static Transacao remove(Integer key){
      return mappedEntity.remove(key);  
    }
    public static Collection<Transacao> returnList(){
        return  mappedEntity.values();
    }
}
