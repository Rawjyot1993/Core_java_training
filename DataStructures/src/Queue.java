import java.util.Scanner;

/**
 * Created by rawjyot on 2/4/17.
 */
public class Queue {



    class MasterException extends Exception
    {
        public MasterException (String message)
        {
            super("Exception:"+message);
        }
    }




    int [] arr ;

    int front = -1, rear = -1 , MaxSize;


    public static void main(String[] args) {




        Scanner sc=new Scanner(System.in);

        int MaxSize=sc.nextInt();

        Queue q = new Queue(MaxSize);

        try{
            q.push(8);
            q.push(9);
            q.push(6);
            q.push(3);
            q.show();
           System.out.println("Poped Element is ->" + q.pop());
           q.show();
            //q.push(3);
            //System.out.println("Poped Element is -> " + q.pop());
            //q.push(8);
            //System.out.println("Poped Element is ->" + q.pop());
            //q.push(0);

        }
        catch(MasterException x)
        {

            System.out.println(x);
        }


    }



        public  Queue(int MaxSize)
        {
            arr = new int[MaxSize];
            this.MaxSize = MaxSize;
        }


        public  void push(int data) throws MasterException {

            if(rear==MaxSize)
            {
                throw new MasterException(" Queue Overflow");
            }

            else
            {
                if(front==-1)
                {
                    front=0;
                }
                rear++;
                arr[rear]=data;
            }

        }

        public int pop() throws MasterException {

            if (front == MaxSize-1 || front == -1)
            {
                throw new MasterException("Queue UnderFlow");
            }
            else
                {

                int x = arr[rear--];
                return x;

            }
        }

        public void show()
        {
            System.out.println("List is");
            for(int i = front; i<=rear ; i++)
            {
                System.out.println(arr[i]);
            }


        }




    }

