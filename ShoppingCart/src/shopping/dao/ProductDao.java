package shopping.dao;

import shopping.domain.Product;

import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface ProductDao {

public List<Product> getProductDetails();
public void addProduct(Product product);
public void deleteProduct();
public void updateProduct();
public void editProductCode();


}
