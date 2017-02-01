/**
 * Created by rawjyot on 1/27/17.
 */
public class Stack {



    class Underflow extends Exception
    {


        Underflow(String r)
        {
            super(r);

        }


    }


    int maxSize ;

    int arr[];

    static int top=-1;

    public Stack(int size)
    {
        maxSize=size;
        arr = new int[maxSize];
    }




    public int pop()throws Underflow
    {
        if(isEmpty()) {

            throw new Underflow("Stack already Empty");

        } else {
            return arr[top--];
        }
    }

    public  void  push(int i)
    {

       try {
           if (top < 5) {
               arr[++top] = i;
           }
       }
       catch (Exception ex)
       {
           System.out.println("OverFlow" + i);

       }


    }


    public boolean isEmpty()
    {

        if(top==-1)
        {
            return true;

        }
        else
            return  false;

    }

    public void display()
    {
        for (int i: arr)
        {
            System.out.println("->"+i);
        }
    }

    public static void main(String[] args)  {


        Stack r= new Stack(5);
       // r.push(2);
       // r.push(3);
       //  r.push(4);
       //  r.push(5);
       // r.push(6);
        // r.push(7);

        try {
            r.pop();
        } catch (Underflow underflow) {
            System.out.println(underflow.getMessage());
        }
        System.out.println(r.isEmpty());

        r.display();

    }


}
