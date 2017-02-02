package shopping.service;

import shopping.domain.Product;

import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface ProductServices {

    public List<Product> getProductDetails();
    public void addProduct(Product product);
    public void deleteProduct();
    public void updateProduct();
    public void editProductCode();


}
