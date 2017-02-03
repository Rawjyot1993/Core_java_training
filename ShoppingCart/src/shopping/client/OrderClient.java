package shopping.client;

import shopping.domain.Order;
import shopping.service.OrderServicesImpl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rawjyot on 2/2/17.
 */
public class OrderClient {

    static OrderServicesImpl orderServices;
    static {

        orderServices=new OrderServicesImpl();
    }

    public static void main(String[] args) {


/*

        DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
        Date o1=new Date();
*/


      /*  Order o=new Order();

        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        System.out.println(date);
        o.setOrderdate(date);
        o.setAmount(23.40);*/


     //   orderServices.updateOrder(1,o);

        File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseFileOrders.txt");
        orderServices.addOrder(file);



    }
}
