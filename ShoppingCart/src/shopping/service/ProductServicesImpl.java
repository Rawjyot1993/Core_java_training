package shopping.service;

import shopping.dao.ProductDaoImpl;
import shopping.dao.UserDaoImpl;
import shopping.domain.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        Product product = new Product();

        //READ FILE -> LIST OF PRODUCTS
        //FOR LOOP AND PASS PRODUCT TO DAO
        File file1 = file;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        string = stringBuilder.toString();
        String[] string1 = string.split("\n");
        for (String strings : string1) {
            String[] arr = strings.split(",");

            product.setName(arr[0]);
            product.setCode(arr[1]);
            product.setPrice(Integer.parseInt(arr[2]));
            product.setStock(Integer.parseInt(arr[3]));

            productDao.addProduct(product);

        }
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
