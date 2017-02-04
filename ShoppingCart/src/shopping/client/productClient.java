package shopping.client;

import shopping.dao.ProductDaoImpl;
import shopping.domain.Product;
import shopping.domain.User;
import shopping.service.ProductServices;
import shopping.service.ProductServicesImpl;
import shopping.utils.DBConnection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public class ProductClient {

    static Product product;
    static ProductServicesImpl productDao;

    static {
        if(productDao== null) {
            product=new Product();
            productDao = new ProductServicesImpl();

        }
    }


    public static void main(String[] args) {


//POPULATING DATABASE THROUGH FILES


        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseFileProducts.txt");

       /*   productDao.addProduct(file);  */

// To Iterate the list of Product

      /*  List<Product> productList=new ArrayList<>();
        productList=productDao.getProductDetails();
        for(Product product1:productList)
        {
            System.out.println(product1.getId());
            System.out.println(product1.getName());
            System.out.println(product1.getStock());

        }
       */

//Update the Product

     /* Product product=new Product();
      product.setName("Perfume");
      product.setStock(12);
      product.setPrice(200);
      product.setCode("P201");
      productDao.updateProduct(2,product);
     */

//Delete the Product

     /* productDao.deleteProduct(7); */




    }





}
