package shopping.dao;

import shopping.domain.User;
import shopping.utils.DBConnection;

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

        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        User user =new User();

        try {

               resultSet = stm.executeQuery("select * from users");




            while (resultSet.next()) {

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
    public void deleteUser() {





    }

    @Override
    public void UpdateUser() {

    }
}
