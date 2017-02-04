package shopping.dao;

import shopping.domain.Order;
import shopping.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


        List<Order> orders = new ArrayList<>();

        Order order = new Order();

        try {
            ResultSet resultSet;
            resultSet = stm.executeQuery("select * from orders");


                while (resultSet.next()) {
                    order.setId(resultSet.getInt("order_id"));
                    order.setUserId(resultSet.getInt("user_id"));
                    order.setOrderdate(resultSet.getDate("order_date"));

                    orders.add(order);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

/*    @Override
    public void addOrders(File file) {



        String sql="insert into orders(order_date,user_id) values (?,?) ";

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
                preparedStatement.setString(1, arr[0]);
                System.out.println(arr[0]);
                preparedStatement.setString(2, arr[1]);
                System.out.println(arr[1]);

                preparedStatement.executeUpdate();

                System.out.println("Orders's  are Added  Successfully");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }*/

    @Override
    public void addOrders(Order order) {



        String sql="insert into orders(order_date,user_id) values (?,?) ";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setDate(1,convertUtilToSql(order.getOrderdate()));
           // System.out.println(arr[0]);
            preparedStatement.setInt(2,order.getUserId());
          //  System.out.println(arr[1]);

            preparedStatement.executeUpdate();

            System.out.println("Orders's  are Added  Successfully");


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public void deleteOrder(int id) {


        String sql = "Delete from Order where order_id = ? ";
        try {
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
