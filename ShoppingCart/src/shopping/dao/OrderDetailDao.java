package shopping.dao;

import shopping.domain.OrderDetails;

import java.io.File;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface OrderDetailDao {

    public List<OrderDetails> getAllOrderDetails(int id);
    public void deleteOrderDeails(int id);
    public void addOrderDetails(OrderDetails orderDetails);
    public void addOrderDetails(File file);
    public void updateOrderDeatils(int id,OrderDetails orderDetails);

}
