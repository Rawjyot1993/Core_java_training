package shopping.dao;

import shopping.domain.Product;
import shopping.domain.User;
import shopping.utils.DBConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Created by rawjyot on 1/29/17.
 */
public class UserDaoImpl implements UserDao {

    Connection con;
    Statement stm;


    public UserDaoImpl() throws SQLException {



        con=DBConnection.getConnection();


        try {
           stm=con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


    @Override
    public List<User> getAllUsers() {


        List<User> users = new ArrayList<>();


        try {

            ResultSet resultSet;

                resultSet = stm.executeQuery("select * from users");
                while (resultSet.next()) {
                    User user =new User();
                user.setId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setLocalAddress(resultSet.getString("address"));
                users.add(user);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

return  users;


    }

   /* @Override
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

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                System.out.println("User's  are Added  Successfully");

                preparedStatement.setString(1, arr[0]);
                System.out.println(arr[0]);
                preparedStatement.setString(2, arr[1]);
                System.out.println(arr[1]);
                preparedStatement.setString(3, arr[2]);
                System.out.println(arr[2]);
                preparedStatement.setString(4, arr[3]);
                System.out.println(arr[3]);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
                   }






    }
*/

    public void addUser(User user) {


        String sql="Insert into users(user_name,first_name,lastname,address)"+" values(?,?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getLocalAddress());

              preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
/*
    @Override
    public void addUser(String userName,String firstName, String lastName,String officialAddress, String localAddress) {


        String sql="insert into users values(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,officialAddress);
            preparedStatement.setString(5,localAddress);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
*/


    @Override
    public void deleteUser(int id) {



        String sql="Delete from users where user_id = ? ";


        try {

          //  stm.executeUpdate(sql);
            PreparedStatement p= null;
            p = con.prepareStatement(sql);
            p.setInt(1,id);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void UpdateUser(int id,User user) {

        String sql ="update users set user_name = ? , first_name = ? , lastname = ? , address = ?  where user_id = ? ";
        PreparedStatement p=null;

        try {

            p=con.prepareStatement(sql);
            p.setString(1,user.getUserName());
            p.setString(2,user.getFirstName());
            p.setString(3,user.getLastName());
            p.setString(4,user.getOfficeAddress());
            p.setInt(5,id);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
