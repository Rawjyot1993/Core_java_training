package shopping.service;

import shopping.domain.Product;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface ProductServices {

    public List<Product> getProductDetails();
    public void addProduct(Product product);
    public void addProduct(File file);
    public void deleteProduct(int id);
    public void updateProduct(int id,Product product);

}
