package shopping.service;

import shopping.dao.UserDaoImpl;
import shopping.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class UserServicesImpl implements UserServices {


    @Override
    public List<User> getAllUsers() {


        List<User> users = new ArrayList<>();;

        //UserDaoImpl userDao= null;
        try {

          UserDaoImpl  userDao = new UserDaoImpl();

            users=userDao.getAllUsers();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }

    @Override
    public void addUser(User user) {

        try {
            UserDaoImpl userDaoimpl=new UserDaoImpl();
            userDaoimpl.addUser(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void UpdateUser() {

    }
}
