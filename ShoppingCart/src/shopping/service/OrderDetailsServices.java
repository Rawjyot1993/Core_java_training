package shopping.service;

import shopping.domain.OrderDetails;

import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface OrderDetailsServices {
    public List<OrderDetails> getAllOrderDetails();
    public void deleteOrderDeails();
    public void updateOrderDeatils();

}
