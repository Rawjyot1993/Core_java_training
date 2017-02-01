package shopping.dao;

import shopping.domain.OrderDetails;

import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public interface OrderDetailDao {

    public List<OrderDetails> getAllOrderDetails();
    public void deleteOrderDeails();
    public void updateOrderDeatils();

}
