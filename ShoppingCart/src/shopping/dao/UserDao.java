package shopping.dao;

import shopping.domain.User;

import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface UserDao {
public List<User> getAllUsers();
public void addUser(User user);
public void deleteUser();
public void UpdateUser();
}
