package shopping.client;

import shopping.domain.Product;
import shopping.domain.User;
import shopping.service.ProductServices;
import shopping.service.ProductServicesImpl;
import shopping.utils.DBConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class productClient {

    public static void main(String[] args) {

        Product product=new Product();

List<Product>products=new ArrayList<>();
        product.setName("TV");
        product.setCode("P201");
        product.setPrice(12000.00);
        product.setStock(1234);






        ProductServicesImpl productServices=new ProductServicesImpl();
        //productServices.addProduct(product);
      products= productServices.getProductDetails();

      for (Product product1: products)
      {
          System.out.println(product1.getName());
          System.out.println(product1.getCode());


      }







    }



}
