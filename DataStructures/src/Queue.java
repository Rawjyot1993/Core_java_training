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



    public void deQueue() throws  MasterException{

        int value;

        if (isempty()) {
            throw new MasterException("Queue is empty, cant dequeue");
        }
        else if (front == rear)
        {
            value = queue[front];
            front = -1;
            rear = -1;

        }
        else {
            value = queue[front];
            front=(front+1);

        }

        System.out.println(" Deleted "+ value);
    }

    int[] queue;


    public boolean isempty() {
        return (front == -1 && rear == -1);
    }

    public void enQueue(int value)throws  MasterException

    {
        if (isempty()) {
            front++;
            rear++;
            queue[rear] = value;

        }
        else {
            rear=(rear+1);
            queue[rear] = value;

        }
    }


    int front = -1, rear = -1 , MaxSize;


    public static void main(String[] args) {




        Scanner sc=new Scanner(System.in);

        int MaxSize=sc.nextInt();

        Queue q = new Queue(MaxSize);

        try{
           q.enQueue(5);
            q.enQueue(6);
            q.enQueue(7);
            q.enQueue(8);
            q.show();
            q.deQueue();
            q.show();

        }
        catch(MasterException x)
        {

            System.out.println(x);
        }


    }



        public  Queue(int MaxSize)
        {

            queue = new int[MaxSize];
            this.MaxSize = MaxSize;

        }




        public void show()
        {
            System.out.println("List is");
            for(int i = front; i<=rear ; i++)
            {
                System.out.println(queue[i]);
            }


        }




    }

