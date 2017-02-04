import java.util.Collection;

/**
 * Created by rawjyot on 1/27/17.
 */
public class LinkedList {

    Node Head;


    public void middleElemet()
    {

        Node SlowPointer=Head;
        Node FastPointer=Head;


        while(FastPointer.next!=null)
        {

            SlowPointer=SlowPointer.next;
            FastPointer=FastPointer.next.next;


        }
        System.out.println(" Middle Element is->"+SlowPointer.data);



    }


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
    public void addAtFront(int data)
    {

        Node n=new Node(data);

        if(Head==null)
        {
            Head=n;
        }
        else {

            n.next = Head;
            Head = n;
        }

    }


    public  void addAtLast(int data) {

      Node n=new Node(data);
      Node current=null;


        if (Head == null) {
            Head =n;
            current=n;
        }
        else {

             Node temp=Head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = n;
        }






    }

    public void display()
    {

        Node next=Head;

         while(next!=null)
         {

             System.out.print("NODE - > " + next.data);
             System.out.print("\t");

             next=next.next;

         }



    }


    public void addAtMiddele(int data,int position)
    {

        Node node=new Node(data);


        Node temp=Head;
        Node prev=Head;
        int i=0;
        while(i<position-1)
        {
            prev=temp;

            temp=temp.next;
             i++;
        }
        prev.next=node;
        node.next=temp;


    }



    public static void main(String[] args) {

        LinkedList newlist=new LinkedList();

        newlist.addAtLast(2);
        newlist.addAtLast(3);
        newlist.addAtLast(4);
        newlist.addAtLast(5);
        newlist.addAtLast(6);

        newlist.addAtFront(4);
        newlist.addAtMiddele(7,3);

        newlist.middleElemet();

        newlist.display();



    }
}
