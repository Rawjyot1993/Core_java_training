package shopping.service;

import shopping.dao.OrderDetailDaoImpl;
import shopping.domain.Order;
import shopping.domain.OrderDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 1/29/17.
 */
public class OrderDetailsServicesImpl  implements  OrderDetailsServices{


    static OrderDetailDaoImpl orderDao;
   static OrderDetails orderD;
    static {
          orderD=new OrderDetails();
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

        File file1 = file;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        string = stringBuilder.toString();
        String[] string1 = string.split("\n");
        for (String strings : string1) {
            String[] arr = strings.split(",");

            try {

                orderD.setAmount(Double.parseDouble(arr[2]));
              orderD.setPrise(Double.parseDouble(arr[1]));
              orderD.setQuantity(Integer.parseInt(arr[0]));
              orderD.setOrderId(Integer.parseInt(arr[3]));
              orderD.setProductId(Integer.parseInt(arr[4]));

              orderDao.addOrderDetails(orderD);

            }
            catch (Exception e)
            {
                e.printStackTrace();

            }

        }
    }

    @Override
    public void deleteOrderDeails(int id) {

        orderDao.deleteOrderDeails(id);

    }


    @Override
    public void updateOrderDeatils(int id,OrderDetails orderDetails) {

        orderDao.updateOrderDeatils(id,orderDetails);


    }
}
