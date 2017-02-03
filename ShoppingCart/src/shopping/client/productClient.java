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
public class productClient {


    static ProductServicesImpl productDao;

    static {
        if(productDao== null) {

            productDao = new ProductServicesImpl();

        }
    }


    public static void main(String[] args) {


/*




       List<Product>products=new ArrayList<>();
        product.setName("TV");
        product.setCode("P201");
        product.setPrice(12000.00);
        product.setStock(1234);

        Product product1=new Product();

        List<Product>products1=new ArrayList<>();
        product.setName("TV");
        product.setCode("P201");
        product.setPrice(12000.00);
        product.setStock(1234);

        Product product2=new Product();

        */
        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseFileProducts.txt");
        productDao.addProduct(file);




    }



}
