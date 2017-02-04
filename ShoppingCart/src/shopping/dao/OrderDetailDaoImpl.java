package shopping.dao;

import shopping.domain.OrderDetails;
import shopping.utils.DBConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class OrderDetailDaoImpl implements OrderDetailDao{

    Connection con;
    Statement stm;

    public OrderDetailDaoImpl() {
        con = DBConnection.getConnection();

        try {

            stm = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    @Override
    public List<OrderDetails> getAllOrderDetails(int id) {

      List<OrderDetails> orderDetailss=new ArrayList<>();

      String sql="select * from order_detail where order_id = ? ";
    //  String sql1="select * from order_detail";



        PreparedStatement preparedStatement= null;


        try {

            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next())
            {
                OrderDetails orderDetails=new OrderDetails();
                orderDetails.setAmount(resultSet.getDouble("amount"));
                orderDetails.setPrise(resultSet.getDouble("price"));
                orderDetails.setQuantity(resultSet.getInt("quantity"));
                orderDetails.setId(resultSet.getInt("order_detail_id"));
                orderDetails.setOrderId(resultSet.getInt("order_id"));
                orderDetails.setProductId(resultSet.getInt("product_id"));
                orderDetailss.add(orderDetails);
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

return  orderDetailss;

    }

    @Override
    public void deleteOrderDeails(int id) {

        String sql="Delete from order_detail where order_detail_id = ? ";


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
    public void addOrderDetails(OrderDetails orderDetails) {

        String sql = "Insert into order_detail(quantity,price,amount,order_id,product_id) " + " values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            System.out.println("OrderDetail's  are Added  Successfully");

            preparedStatement.setInt(1,orderDetails.getQuantity());
            preparedStatement.setDouble(2,orderDetails.getPrise());
            preparedStatement.setDouble(3,orderDetails.getAmount());
            preparedStatement.setInt(4,orderDetails.getOrderId());
            preparedStatement.setInt(5,orderDetails.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }

    @Override
    public void addOrderDetails(File file) {


        /*String sql = "Insert into order_detail(quantity,price,amount,order_id,product_id) " + " values(?,?,?,?,?)";

        File file1 = file;
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
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        string = stringBuilder.toString();
        String[] string1 = string.split("\n");
        for (String strings : string1) {
            String[] arr = strings.split(",");

            try {
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                System.out.println("OrderDetail's  are Added  Successfully");

                preparedStatement.setString(1, arr[0]);
                System.out.println(arr[0]);
                preparedStatement.setString(2, arr[1]);
                System.out.println(arr[1]);
                preparedStatement.setString(3, arr[2]);
                System.out.println(arr[2]);
                preparedStatement.setString(4, arr[3]);
                System.out.println(arr[3]);
                preparedStatement.setString(5, arr[4]);
                System.out.println(arr[4]);


                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }*/
    }

        @Override
        public void updateOrderDeatils(int id,OrderDetails orderDetails) {


            String sql ="update order_detail set quantity = ? , price = ? , amount = ? , order_id = ? , product_id= ? where order_detail_id = ? ";
            PreparedStatement p=null;

            try {
                OrderDetails orderDetails1=new OrderDetails();

                p=con.prepareStatement(sql);
                p.setInt(1,orderDetails1.getQuantity());
                p.setDouble(2,orderDetails1.getPrise());
                p.setDouble(3,orderDetails1.getAmount());
                p.setInt(4,orderDetails1.getOrderId());
                p.setInt(5,orderDetails1.getProductId());
                p.setInt(6,id);

                p.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

}
