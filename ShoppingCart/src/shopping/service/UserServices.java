package shopping.service;

import shopping.domain.User;

import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface UserServices {


    public List<User> getAllUsers();
     public void addUser(User user);
    public void deleteUser();
    public void UpdateUser();


}
