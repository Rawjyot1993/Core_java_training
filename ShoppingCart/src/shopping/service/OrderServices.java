package shopping.service;

import shopping.domain.Order;
import shopping.domain.OrderDetails;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface OrderServices {

    public List<Order> getAllOrder();
    public  void deleteOrder(int id);
    public  void  addOrder(File file);
    public  void updateOrder(int id,Order order);


}
