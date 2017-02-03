package shopping.service;

import shopping.dao.ProductDaoImpl;
import shopping.dao.UserDaoImpl;
import shopping.domain.Product;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class ProductServicesImpl implements ProductServices {


    static ProductDaoImpl productDao;

    static {
        if(productDao == null) {

                productDao = new ProductDaoImpl();

        }
    }



    @Override
    public List<Product> getProductDetails() {


       List<Product> products=new ArrayList<>();
        products=productDao.getProductDetails();

      return products;

    }

    @Override
    public void addProduct(Product product) {


        productDao.addProduct(product);

    }

    @Override
    public void addProduct(File file) {

        productDao.addProduct(file);

    }

    @Override
    public void deleteProduct(int id) {

        productDao.deleteProduct(id);

    }

    @Override
    public void updateProduct(int id, Product product) {

       productDao.updateProduct(id,product);


    }


}
