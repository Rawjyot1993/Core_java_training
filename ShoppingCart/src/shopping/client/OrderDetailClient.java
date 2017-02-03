package shopping.client;

import shopping.domain.OrderDetails;
import shopping.service.OrderDetailsServicesImpl;
import shopping.service.OrderServicesImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/3/17.
 */
public class OrderDetailClient {


    static OrderDetailsServicesImpl orderServices;
    static {

        orderServices=new OrderDetailsServicesImpl();
    }

    public static void main(String[] args) {


       // File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseOrderDetails.txt");
        //orderServices.addOrderDetails(file);


        List<OrderDetails> orderDetailss=new ArrayList<>();

        orderDetailss=orderServices.getAllOrderDetails(1);

        for (OrderDetails o:orderDetailss
             ) {


            System.out.println(o.getAmount());
            System.out.println(o.getId());
            System.out.println(o.getPrise());
            System.out.println(o.getQuantity());

        }
        {

        }

    }

}
