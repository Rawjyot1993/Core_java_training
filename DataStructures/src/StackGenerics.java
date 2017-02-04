import java.util.Iterator;

/**
 * Created by rawjyot on 2/4/17.
 */
public class StackGenerics<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack




    class NoSuchElementException extends Exception
    {
        NoSuchElementException(String e)
        {
            super(" Exception:"+e);
        }

    }


    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public StackGenerics() {
        first = null;
        n = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return n;
    }


    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    public Item pop() throws NoSuchElementException {

        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }



    public Item peek() throws NoSuchElementException{
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();

    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()
        { return current != null;                     }
        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) try {
                throw new NoSuchElementException("NOT FOUND");
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

        StackGenerics<String> stack = new StackGenerics<>();
       stack.push("qwer");
       stack.push("asd");
       stack.push("asd");
       stack.push("xcv");
       stack.iterator();



    }
}