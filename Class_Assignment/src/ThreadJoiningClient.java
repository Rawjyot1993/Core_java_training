/**
 * Created by rawjyot on 2/1/17.
 */
public class ThreadJoiningClient {


    public static void main(String[] args)  {

        ThreadOne one =new ThreadOne();
        ThreadTwo two=new ThreadTwo();

        Thread t1=new Thread(one);
        Thread t2=new Thread(two);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();






    }










}
