package br.edu.infnet.financialcontrol.repository;
import br.edu.infnet.financialcontrol.model.domain.Provisao;
import br.edu.infnet.financialcontrol.model.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.Collection;

public class ProvisoesRepository {
    private static Integer id = 1;
    private static Map<Integer,Provisao> mappedEntity = new HashMap<Integer, Provisao>();
    public static boolean add(Provisao entity){
        try{
            entity.setId(id++);
            mappedEntity.put(entity.getId(),entity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static Provisao remove(Integer key){
      return mappedEntity.remove(key);  
    }
    public static Collection<Provisao> returnList(){
        return  mappedEntity.values();
    }
}
