package shopping.dao;

import shopping.domain.Product;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface ProductDao {
public List<Product> getProductDetails();
public void addProduct(Product product);
public  void  addProduct(File file);
public void deleteProduct(int id);
public void updateProduct(int d,Product product);


}
