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
public class userClient {

    static UserServicesImpl userServices;

    static {
        if(userServices == null) {
            try {
                userServices = new UserServicesImpl();
            }
            catch (Exception e)
            {

            }
        }
    }
    public static void main(String[] args) {


        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/DataBaseFile.txt");

        userServices.addUser(file);




    }

}
