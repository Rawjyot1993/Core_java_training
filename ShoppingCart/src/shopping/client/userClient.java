package shopping.client;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import shopping.dao.UserDaoImpl;
import shopping.domain.User;
import shopping.service.UserServices;
import shopping.service.UserServicesImpl;
import shopping.utils.DBConnection;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class UserClient {



    static User user;
    static UserServicesImpl userServices;

    static {
        if(userServices == null||user==null) {
            try {
                user=new User();
                userServices = new UserServicesImpl();
            }
            catch (Exception e)
            {
e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {


//  TO SHOW THE LIST OF USER DETAILS

        /*
        List<User> userList=new ArrayList<>();
        userList=userServices.getAllUsers();
        for (User users: userList)
        {
            System.out.println(users.getId());
            System.out.println(users.getUserName());
            System.out.println(users.getFirstName());
            System.out.println(users.getLastName());
        }
        */


// Add User through file.

        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/DataBaseFileUsers.txt");

        userServices.addUser(file);




//Delete User through Id



        /*
        userServices.deleteUser(41);
        */



//UPDATE USER

        /*
        user.setFirstName("AMAN");
        user.setUserName("ROCKS");
        user.setLastName("SINGH");
        user.setOfficeAddress("Pune");
        userServices.UpdateUser(33,user);
        */






    }

}
