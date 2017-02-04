package shopping.dao;

import shopping.domain.Product;
import shopping.domain.User;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface UserDao {
public List<User> getAllUsers();
//public void addUser(File file);
public void addUser(User user);
public void deleteUser(int id);
public void UpdateUser(int id,User user);
}
