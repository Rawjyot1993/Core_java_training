package shopping.service;

import shopping.dao.OrderDaoImpl;
import shopping.domain.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rawjyot on 1/27/17.
 */
public class OrderServicesImpl implements OrderServices{

    static OrderDaoImpl orderDao;
    static  Order order;
    static {
        order=new Order();
        orderDao=new OrderDaoImpl();

    }


     int id;
    @Override
    public List<Order> getAllOrder() {

        List<Order> orderList;
        orderList=new ArrayList<>();
        orderList=orderDao.getAllOrder();

        return  orderList;
    }

    @Override
    public void deleteOrder(int id) {

            orderDao.deleteOrder(id);
    }

    @Override
    public void addOrder(File file) {




        File file1=file;
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
            while((string=bufferedReader.readLine())!=null){
                stringBuilder.append(string).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        string=stringBuilder.toString();
        String[] string1 = string.split("\n");
        for (String strings:string1) {
            String[] arr = strings.split(",");
            java.util.Date today = new java.util.Date();
               order.setOrderdate(today);
               order.setUserId(Integer.parseInt(arr[1]));



                orderDao.addOrders(order);



        }
    }

    @Override
    public void updateOrder(int id,Order order) {

        orderDao.updateOrder(id,order);

    }
}
