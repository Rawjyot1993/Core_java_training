package shopping.service;

import shopping.dao.ProductDaoImpl;
import shopping.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class ProductServicesImpl implements ProductServices {
    @Override
    public List<Product> getProductDetails() {


       List<Product> products=new ArrayList<>();
        ProductDaoImpl productDao=new ProductDaoImpl();
        products=productDao.getProductDetails();

      return products;

    }

    @Override
    public void addProduct(Product product) {

        ProductDaoImpl productDao=new ProductDaoImpl();
        productDao.addProduct(product);

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
