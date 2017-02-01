/**
 * Created by rawjyot on 1/27/17.
 */
public class LinkedList {

    Node Head;

    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;

        }

    }
    public void create(int data)
    {
        Node n=new Node(data);


        if(Head==null)
        {
            Head=n;

        }

         Node temp=Head;

         while(temp.next!=null)
         {
              temp=temp.next;
         }

         temp.next=n;
         //n=temp;
        System.out.println("Done"+temp.data);



    }
    public void display()
    {

         while(Head!=null)
         {
             System.out.print("NODE - > " + Head.data);

             Head=Head.next;

         }



    }

    public static void main(String[] args) {

        LinkedList newlist=new LinkedList();

        newlist.create(5);
        newlist.create(6);
        newlist.create(7);
        newlist.create(8);
        newlist.create(9);
        newlist.display();

    }









}
