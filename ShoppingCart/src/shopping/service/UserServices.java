package shopping.service;

import shopping.domain.User;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface UserServices {


    public List<User> getAllUsers();
     public void addUser(File file);
      public void addUser(User user);
    public void deleteUser(int id);
    public void UpdateUser(int id,User user);


}
