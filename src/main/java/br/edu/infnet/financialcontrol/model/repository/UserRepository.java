package br.edu.infnet.financialcontrol.model.repository;
import br.edu.infnet.financialcontrol.model.domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> list = new ArrayList<User>();
    public static boolean add(User user){
        try{
            list.add(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static List<User> returnList(){
        return list;
    }
}
