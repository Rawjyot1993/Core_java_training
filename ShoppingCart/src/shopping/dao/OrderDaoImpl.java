package shopping.dao;

import shopping.domain.Order;
import shopping.domain.User;
import shopping.utils.DBConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class OrderDaoImpl implements OrderDao {


    Connection con;
    Statement stm;

    public OrderDaoImpl() {
        con = DBConnection.getConnection();

        try {

            stm = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    @Override
    public List<Order> getAllOrder() {

        ResultSet resultSet;
        List<Order> orders = new ArrayList<>();

        Order order = new Order();

        try {
            resultSet = stm.executeQuery("select * from orders");
            while (resultSet.next()) {
                order.setOrderdate(resultSet.getDate("order_date"));
                order.setAmount(resultSet.getDouble("amount"));
                order.setUserId(resultSet.getInt("user_id"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public void addOrders(File file) {



        String sql="insert into orders(order_date,user_id) values (?,?,?) ";

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
                System.out.println("Orders's  are Added  Successfully");

               // System.out.println(date);

               /* Date now;
                now = new Date();
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat formatter = new SimpleDateFormat(pattern);
                String mysqlDateString = formatter.format(now);
                System.out.println("Java's Default Date Format: " + now);
                System.out.println("Mysql's Default Date Format: " + mysqlDateString);
*/


            //    preparedStatement.setDate(1,);
             //   System.out.println(arr[0]);
                preparedStatement.setString(2, arr[1]);
                System.out.println(arr[1]);
                preparedStatement.setString(3, arr[2]);
                System.out.println(arr[2]);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }

    @Override
    public void deleteOrder(int id) {


        String sql = "Delete from Order where order_id = ? ";


        try {

            //  stm.executeUpdate(sql);
            PreparedStatement p = null;
            p = con.prepareStatement(sql);
            p.setInt(1, id);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateOrder(int id, Order order) {

        String sql = "update orders set order_date = ? , amount = ? where order_id = ? ";
        PreparedStatement p = null;

        try {

            p = con.prepareStatement(sql);

            p.setDate(1,convertUtilToSql(order.getOrderdate()));
            p.setDouble(2, order.getAmount());
            p.setInt(3, id);

            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
