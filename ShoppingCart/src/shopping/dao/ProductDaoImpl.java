package shopping.dao;

import shopping.domain.Product;
import shopping.domain.User;
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
    public void deleteProduct() {

    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void editProductCode() {

    }
}
