package br.edu.infnet.financialcontrol.repository;
import br.edu.infnet.financialcontrol.model.domain.Partida;
import br.edu.infnet.financialcontrol.model.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.Collection;

public class PartidasRepository {
    private static Integer id = 1;
    private static Map<Integer,Partida> mappedEntity = new HashMap<Integer, Partida>();
    public static boolean add(Partida entity){
        try{
            entity.setId(id++);
            mappedEntity.put(entity.getId(),entity);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static Partida remove(Integer key){
      return mappedEntity.remove(key);  
    }
    public static Collection<Partida> returnList(){
        return  mappedEntity.values();
    }
}
