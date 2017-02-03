package shopping.client;

import shopping.domain.Order;
import shopping.domain.OrderDetails;
import shopping.service.OrderDetailsServicesImpl;
import shopping.service.OrderServices;
import shopping.service.OrderServicesImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rawjyot on 2/3/17.
 */
public class OrderDetailClient {

    static OrderServicesImpl orderClient;
    static OrderDetailsServicesImpl orderServices;
    static {
        orderClient=new OrderServicesImpl();
        orderServices=new OrderDetailsServicesImpl();
    }
    public static void main(String[] args) {

        List<OrderDetails> orderDetailss = new ArrayList<>();
        orderDetailss = orderServices.getAllOrderDetails(1);

        for (OrderDetails order: orderDetailss)
        {

            System.out.println(order.getId());
            System.out.println(order.getQuantity());
            System.out.println(order.getPrise());


        }





       File dir = new File("/Users/rawjyot/Projects/ShoppingCart/");
        File f1 = new File(dir, "Amount_Details.csv");




        final String cs = ",";
        final String nls = "\n";
        final String fh = "Order_Id ,Order_Details_Id,Product_Id ,Quantity ,Price ,Amount ";
        FileWriter fw=null;




        try {

            try {
                f1.createNewFile();
                fw = new FileWriter(f1);
                fw.append(fh.toString());
                }
            catch (IOException e)
                {
                e.printStackTrace();
                }







               double Total=0.0;
                for (OrderDetails o : orderDetailss) {

                    double sum = 0;
                    try {

                        fw.append(nls);
                        fw.append(Integer.toString(o.getOrderId()));
                        fw.append(cs);
                        fw.append(Integer.toString(o.getId()));
                        fw.append(cs);
                        fw.append(Integer.toString(o.getProductId()));
                        fw.append(cs);
                        fw.append(Integer.toString(o.getQuantity()));
                        fw.append(cs);
                        fw.append(Double.toString(o.getPrise()));
                        fw.append(cs);


                        Double x = o.getPrise();
                        int q = o.getQuantity();
                        sum = sum + (q * x);


                        fw.append(Double.toString(sum));


                        fw.flush();
                        System.out.print(" Amount-> " + o.getAmount());
                        System.out.print(" Order Detail ID-> " + o.getId());
                        System.out.print(" Price-> " + o.getPrise());
                        System.out.print(" Quantity-> " + o.getQuantity());
                        System.out.print(" Product_id -> " + o.getProductId());
                        System.out.print(" Order Id -> " + o.getOrderId());
                        System.out.println(" ");

                         Total=Total+sum;

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }


                }
            try {
                fw.append(nls);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append("Total Amount=");
                fw.append(cs);
                fw.append(Double.toString(Total));

            }



            catch (IOException e)
            {
                e.printStackTrace();
            }



        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        }
    }



