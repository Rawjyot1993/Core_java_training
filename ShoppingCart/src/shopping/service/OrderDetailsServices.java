package shopping.service;

import shopping.domain.OrderDetails;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 2/1/17.
 */
public interface OrderDetailsServices {
    public List<OrderDetails> getAllOrderDetails(int id);
    public void addOrderDetails(File file);
    public void deleteOrderDeails(int id);
    public void updateOrderDeatils(int id,OrderDetails orderDetails);

}
