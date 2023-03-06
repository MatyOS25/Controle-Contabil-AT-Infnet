package br.edu.infnet.financialcontrol.model.repository;
import br.edu.infnet.financialcontrol.model.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;  
import java.util.HashMap;
import java.util.Collection;

public class UserRepository {
    private static Integer id = 1;
    private static Map<Integer,User> mappedUsers = new HashMap<Integer, User>();
    public static boolean add(User user){
        try{
            user.setId(id++);
            mappedUsers.put(user.getId(),user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static User removeUser(Integer key){
      return mappedUsers.remove(key);  
    }
    public static Collection<User> returnList(){
        return  mappedUsers.values();
    }
}
