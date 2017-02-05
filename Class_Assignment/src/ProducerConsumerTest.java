import java.util.ArrayList;
import java.util.List;
/**
 * Created by rawjyot on 2/5/17.
 */

public class ProducerConsumerTest
{
    public static void main(String[] args)
            {
        ProducerConsumer producerConsumer=new ProducerConsumer();

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    producerConsumer.producedData();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        Thread thread1= new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    producerConsumer.consumeData();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
       thread.start();
        thread1.start();


              /*  try {
                    thread.join();
                    thread1.join();                      
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

    }


public static class ProducerConsumer
    {
        List<Integer> list=new ArrayList<>();
       int capacity = 4;
       int k=0;

        public void producedData()
        {
            int data = 0;
            while (true)
            {
                synchronized (this)
                {
                    while (list.size()==capacity)
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("Producer Data Produced:" + data);
                    list.add(data++);
                    notify();

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        public void consumeData()
        {
            while (true)
            {
                synchronized (this)
                {
                    int i=0;
                    while (list.size()==k)
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    int removedData = list.remove(i++);

                    System.out.println("Consumer Date Consumerd:"+ removedData);
                    notify();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
