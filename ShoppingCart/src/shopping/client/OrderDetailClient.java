package shopping.client;

import shopping.domain.OrderDetails;
import shopping.service.OrderDetailsServicesImpl;
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


    static OrderDetailsServicesImpl orderServices;
    static {
        orderServices=new OrderDetailsServicesImpl();
    }
    public static void main(String[] args) {
       // File file=new File("/Users/rawjyot/Projects/ShoppingCart/src/shopping/utils/DataBaseOrderDetails.txt");
        //orderServices.addOrderDetails(file);

        File dir = new File("/Users/rawjyot/Projects/ShoppingCart/");
        File f1 = new File(dir,"Amount_Details.csv");

        final String cs = ",";
        final String nls = "\n";

        final String fh= "Order_Id ,Order_Details_Id,Product_Id ,Quantity ,Price ,Amount ";

        try {

                f1.createNewFile();
                FileWriter fw = new FileWriter(f1);
                fw.append(fh.toString());


                double sum = 0;


                List<OrderDetails> orderDetailss = new ArrayList<>();

                orderDetailss = orderServices.getAllOrderDetails(1);

                for (OrderDetails o : orderDetailss) {

                    System.out.print(" Amount-> "+o.getAmount());
                    System.out.print(" Order Detail ID-> "+o.getId());
                    System.out.print(" Price-> "+o.getPrise());
                    System.out.print(" Quantity-> "+o.getQuantity());
                    System.out.print(" Product_id -> "+o.getProductId());
                    System.out.print(" Order Id -> "+o.getOrderId());
                    System.out.println(" ");


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


                    //fw.append(Double.toString((q * x)));
                }

             /*   fw.append(nls);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);
                fw.append(cs);*/


                fw.flush();
                fw.close();


            } catch (IOException e) {
                e.printStackTrace();


            }

            }

    }


   /*public void createCSVFile(File file,int id)
    {

        File dir = new File("file");
        File f1 = new File(dir,"Total-Amount.csv");
        final String cs = ",";
        final String nls = "\n";
        final String fh= "ProductId,Quantity,PriceofProduct,Amount";
        try {


            f1.createNewFile();
            FileWriter fw = new FileWriter(f1);
            fw.append(fh.toString());
            List<OrderDetails> oo = new ArrayList<>();
            oo = orderServices.getAllOrderDetails(id);
            for(order d : oo)
            {
                System.out.println(d.getId() + "\t\t" + d.getOrderDate() + "\t\t");
            }
            //choose a order id

            od.getallorderdetailsbyid(1);
            double sum = 0;
            List<orderDetail> od1 = new ArrayList<>();
            od1 = od.getallorderdetails();
            for(orderDetail u : od1)
            {

                fw.append(nls);
                fw.append(Integer.toString(u.getProductId()));
                fw.append(cs);
                fw.append(Integer.toString(u.getQuantity()));
                fw.append(cs);
                Double x = u.getPrice();
                int q = u.getQuantity();
                fw.append(Double.toString(u.getPrice()));
                fw.append(cs);
                sum = sum + (q*x);
                fw.append(Double.toString((q*x)));
            }
            fw.append(nls);
            fw.append(cs);
            fw.append(cs);
            fw.append(cs);
            fw.append(Double.toString(sum));
            fw.flush();
            fw.close();






    }
*/