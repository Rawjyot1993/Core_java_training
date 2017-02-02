package shopping.service;

import shopping.domain.Order;
import shopping.domain.OrderDetails;

import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface OrderServices {

    public List<Order> getAllOrder();
    public  void deleteOrder();
    public  void updateDate();


}
