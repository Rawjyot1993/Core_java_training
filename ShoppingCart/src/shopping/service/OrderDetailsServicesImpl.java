package shopping.service;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import shopping.dao.OrderDaoImpl;
import shopping.dao.OrderDetailDao;
import shopping.dao.OrderDetailImpl;
import shopping.domain.OrderDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class OrderDetailsServicesImpl  implements  OrderDetailsServices{


    static OrderDetailImpl orderDao;
    static {

        orderDao=new OrderDetailImpl() ;

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
    public void updateOrderDeatils() {

    }
}
