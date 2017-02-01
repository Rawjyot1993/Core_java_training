package shopping.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by rawjyot on 1/25/17.
 */
public class Order {


   private int id;
   private Date orderdate;
   private Double amount;
   private int userId;
   public List<OrderDetails> orderDetailsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
