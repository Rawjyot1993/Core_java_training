import java.util.Scanner;

/**
 * Created by rawjyot on 1/27/17.
 */
public class ReverseStringUsingStack {



    class Underflow extends Exception
    {


        Underflow(String r)
        {
            super(r);

        }


    }


    int maxSize ;

    char arr[];

    static int top=  -1;

    public ReverseStringUsingStack(int size)
    {
        maxSize=size;
        arr = new char[maxSize];
    }




    public char pop()throws Underflow
    {
        if(isEmpty()) {

            throw new Underflow("ReverseStringUsingStack already Empty");

        } else {
            return arr[top--];
        }
    }

    public  void  push(char c)
    {

       try {
           if (top < 5) {
               arr[++top] = c;
           }
       }
       catch (Exception ex)
       {
           System.out.println("OverFlow" + c);

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
        for (char i: arr)
        {
            System.out.println("->"+i);
        }
    }

    public static void main(String[] args)  {

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        ReverseStringUsingStack r= new ReverseStringUsingStack(str.length()+1);


        for(int i=0;i<str.length();i++) {


            char c=str.charAt(i);
            r.push(c);



        }

   //It will Reverse the string using ReverseStringUsingStack

        while(!r.isEmpty())
        {


            try {
                char rev=r.pop();
                System.out.print("Reverse String->"+rev);
                System.out.println();
            } catch (Underflow underflow) {
                underflow.printStackTrace();
            }

        }








    }


}
