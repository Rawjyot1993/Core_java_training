package shopping.client;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import shopping.domain.User;
import shopping.service.UserServices;
import shopping.service.UserServicesImpl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class userClient {


    public static void main(String[] args) {
      /*  User user = new User();
        user.setUserName("Rawjyot");
        user.setFirstName("Rawjyot");
        user.setLastName("Singh");
        user.setLocalAddress("Doon");
        // user.setOfficeAddress("Pune");*/

        /*List<User> users = new ArrayList<>();
        UserServicesImpl userServices = new UserServicesImpl();
        userServices.addUser(userServices);
        */

        List<User> users= new ArrayList<>();
        UserServicesImpl users1=new UserServicesImpl();
       users= users1.getAllUsers();

        for (User u : users) {

            System.out.println(u.getFirstName());
            System.out.println(u.getLocalAddress());


        }

        String strLine[]=new String[100];
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream("/Users/rawjyot/Projects/ShoppingCart/src/shopping/DataBaseFile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

/*

        try {
            int i=0;

            StringBuilder sb=new StringBuilder();

            while ((strLine [i]= br.readLine()) != null) {
                System.out.println("initial read :-"+ strLine[i]);
                System.out.println("initial read :-"+ strLine.length);

                String [] testStr = strLine[i].split(",",4);



                //System.out.println("inside loop "+s);

                for(int k=0;k<4;k++) {

               //     System.out.println(testStr[k]);

                    PreparedStatement pstmt ;
                    Connection conn = null;

                    String sql="insert into users(user_name,first_name,lastname,address)"+" values (?,?,?,?)";

                           pstmt = (PreparedStatement) conn.prepareStatement(sql);

                        pstmt.setString(1, testStr[k++]);
                        pstmt.setString(2, testStr[k++]);
                        pstmt.setString(3, testStr[k++]);
                        pstmt.setString(4, testStr[k++]);





                    // System.out.println("inside loop 1 :"+ testStr.toString());

                }

                //System.out.println(strLine[i]);

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
       /* FileInputStream fis = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {

            File file = new File(strLine);
            fis = new FileInputStream(file);
            pstmt = conn.prepareStatement("insert into users(user_name,first_name,lastname,address) values (?, ?, ?,?)";
            pstmt.setString(1,);
            pstmt.setString(2, );
            pstmt.setString(3, );
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {

            try {
                in.close();
                pstmt.close();
                fis.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }*/
    }

}
