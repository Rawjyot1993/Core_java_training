package shopping.client;

import shopping.domain.Order;
import shopping.service.OrderServicesImpl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rawjyot on 2/2/17.
 */
public class OrderClient {

    static OrderServicesImpl orderServices;
    static Order order;
    static {
        order=new Order();
        orderServices=new OrderServicesImpl();
    }

    public static void main(String[] args) {


//Add Order Details Using File.

        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseFileOrders.txt");
        //orderServices.addOrder(file);


//Update Order
      /*
      orderServices.updateOrder(1,order); //Update Order through Order ID
       */


//Show List of Orders

        /*
        List<Order> orderList=new ArrayList<>();
        orderList=orderServices.getAllOrder();
        for(Order order1: orderList)
        {
            System.out.println(order1.getId());
            System.out.println(order1.getUserId());
            System.out.println(order1.getOrderdate());
        }
        */



//Delete Order

        /*
        orderServices.deleteOrder(1);
         */



    }
}
