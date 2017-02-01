package shopping.dao;


import shopping.domain.Order;

import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface OrderDao {
 public List<Order> getAllOrder();
 public  void deleteOrder();
 public  void updateDate();

}
