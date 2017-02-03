package shopping.service;

import shopping.dao.OrderDaoImpl;
import shopping.dao.OrderDetailImpl;
import shopping.dao.UserDaoImpl;
import shopping.domain.Order;
import shopping.domain.OrderDetails;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by rawjyot on 1/27/17.
 */
public class OrderServicesImpl implements OrderServices{

    static OrderDaoImpl orderDao;
    static {

        orderDao=new OrderDaoImpl();

    }


     int id;
    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

            orderDao.deleteOrder(id);
    }

    @Override
    public void addOrder(File file) {
        orderDao.addOrders(file);
    }

    @Override
    public void updateOrder(int id,Order order) {

        orderDao.updateOrder(id,order);

    }
}
