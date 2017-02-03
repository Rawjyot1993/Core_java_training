package shopping.dao;

import shopping.domain.Product;
import shopping.domain.User;
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
public class ProductDaoImpl implements ProductDao {

    Connection con;
    Statement stm;

   public ProductDaoImpl()
    {


        con= DBConnection.getConnection();


        try {
            stm=con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    @Override
    public List<Product> getProductDetails() {

        ResultSet resultSet;
        List<Product> products = new ArrayList<>();
        Product product=new Product();
        try {

            resultSet = stm.executeQuery("select * from product");


            while (resultSet.next()) {


                product.setName(resultSet.getString("product_name"));
                product.setCode(resultSet.getString("code"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStock(resultSet.getInt("stock"));

                products.add(product);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return  products;
    }

    public  void  addProduct(File file)
    {


        String sql="Insert into product(product_name,code,price,stock)"+" values(?,?,?,?)";

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

                System.out.println("Product's  are Added  Successfully");

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

    @Override
    public void addProduct( Product product) {


        String sql="Insert into product(product_name,code,price,stock)"+" values(?,?,?,?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getCode());
            preparedStatement.setString(3, String.valueOf(product.getPrice()));
            preparedStatement.setString(4, String.valueOf(product.getStock()));

            preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }



    @Override
    public void deleteProduct(int id) {



        String sql="Delete from product where product_id = ? ";


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
    public void updateProduct(int id,Product product) {


        String sql ="update product set product_name = ?,code = ?,price = ?,stock = ? where product_id = ? ";
        PreparedStatement p=null;

        try {

            p=con.prepareStatement(sql);
            p.setString(1,product.getName());
            p.setString(2,product.getCode());
            p.setDouble(3,product.getPrice());
            p.setInt(4,product.getStock());
            p.setInt(5,id);
            p.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
