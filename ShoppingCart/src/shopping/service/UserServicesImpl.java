package shopping.service;

import shopping.dao.UserDaoImpl;
import shopping.domain.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class UserServicesImpl implements UserServices {

    static  User user;
    static UserDaoImpl userDao;

    static {
        if(userDao == null) {
            try {
                user=new User();
                userDao = new UserDaoImpl();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {


        List<User> users = new ArrayList<>();

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

        String sql="Insert into users(user_name,first_name,lastname,address) "+" values(?,?,?,?)";

        File file1=file;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while((string=bufferedReader.readLine())!=null){
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        string=stringBuilder.toString();
        String[] string1 = string.split("\n");
        for (String strings:string1) {
            String[] arr = strings.split(",");

            user.setUserName(arr[0]);
            user.setFirstName(arr[1]);
            user.setLastName(arr[2]);
            user.setLocalAddress(arr[3]);

            userDao.addUser(user); // Product Added as ARGUMENT


    }


    }

    @Override
    public void addUser(User user) {
// DONE WITH FILE
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
