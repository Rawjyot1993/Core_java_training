package shopping.dao;


import shopping.domain.Order;
import shopping.domain.User;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface OrderDao {
 public List<Order> getAllOrder( );
 //public void  addOrders(File file);
 public void  addOrders(Order order);
 public  void deleteOrder(int id);
 public  void updateOrder(int id,Order order);

}
