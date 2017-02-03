package shopping.service;

import shopping.dao.OrderDetailDaoImpl;
import shopping.domain.OrderDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class OrderDetailsServicesImpl  implements  OrderDetailsServices{


    static OrderDetailDaoImpl orderDao;
    static {

        orderDao=new OrderDetailDaoImpl() ;

    }

    @Override
    public List<OrderDetails> getAllOrderDetails(int id) {

        List<OrderDetails> orderDetailss=new ArrayList<>();
        orderDetailss=orderDao.getAllOrderDetails(id);

     return orderDetailss;
    }

    @Override
    public void addOrderDetails(File file) {

        orderDao.addOrderDetails(file);

    }

    @Override
    public void deleteOrderDeails() {

    }

    @Override
    public void updateOrderDeatils(int id,OrderDetails orderDetails) {

        orderDao.updateOrderDeatils(id,orderDetails);


    }
}
