package shopping.service;

import shopping.dao.UserDaoImpl;
import shopping.domain.User;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class UserServicesImpl implements UserServices {


    static UserDaoImpl userDao;

    static {
        if(userDao == null) {
            try {
                userDao = new UserDaoImpl();
            } catch (SQLException ex) {
                //TODO
            }
        }
    }

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
    public void addUser(File file) {



            userDao.addUser(file);




    }

    @Override
    public void deleteUser(int id) {



        userDao.deleteUser(id);
       // try {
            //UserDaoImpl userDao=new UserDaoImpl();
            userDao.deleteUser(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void UpdateUser(int id,User user) {


        userDao.UpdateUser(id,user);

    }
}
