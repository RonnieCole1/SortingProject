/**
 * This class creates a simple linked list object.
 */
package sortingprojectsimplified;

/**
 * @version Starter Code
 * @author Katie Timmerman
 */
class MyCircularLL {

    private Node tail;
    
    /**
     * creates an empty list
     */
    public MyCircularLL(){
        tail = null;
    }
    

    /**
     * Adds value to the start of the list
     *
     * @param value
     */
    public void add(int value) {
        if (tail != null) {
            Node newNode = new Node(value, tail.next,tail);
            tail.next = newNode;
        } else {
            Node newNode = new Node(value, null, null);
            tail = newNode;
            newNode.next = newNode;
        }
    }
    
      /**
     * Adds value to the end of the list
     * @param value 
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if(tail == null){
            tail = newNode;
            newNode.next = newNode;
        }else{
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    /**
     * removes the first occurrence of item from the list.
     * @param item 
     */
    public void remove(int item) {
        if (tail == null){
            System.out.println("The value " + item + " cannot be found.");
        } else {
            int test = item;
            Node current = tail.next;
            Node previous = tail;
            while(current != tail) {
                if (current.value == test) {
                    previous.next = previous.next.next;
                    return;
                } else {
                    current = current.next;
                    previous = previous.next;
                }
            }
            if (test == tail.value) { 
                    if (tail == tail.next) {
                        tail = null;
                    } else {
                        previous.next = tail.next;
                        tail = previous;
                    }
            } 
        }
    }

    /**
     * Removes the first value in the list
     */
    public void remove(){
        if(tail == null)
            return;
        else if(tail.next == tail) //only 1 item
            tail = null;
        else{
            tail.next = tail.next.next;
        }
    }
    
    /**
     * Empties the list
     */
    public void empty(){
        tail = null;
    }
    
    /**
     * Returns the location of the first occurrence of the value in the list.
     * Returns 0 if it is the first item. return -1 if it isn't in the list
     * @param value 
     */
    public int indexOf(int value){
        if(tail == null){
            return -1;
        }
        
        int index = 0;
        Node cur = tail.next;
        while(cur != tail && cur.value != value){ //Checks everything but tail
            index++;
            cur = cur.next;
        }
        if(cur.value == value)
            return index;
        else if (tail.value == value){
            return index++;
        }else{
            return -1;
        }
    }
    
    /**
     * This is the method called when a MyLinkList is passed to System.out
     * It determines what is printed
     * @return 
     */
    @Override
    public String toString(){
        if (tail == null)
            return "[]";
        String toPrint = "[ ";
        Node cur = tail.next;
        while(cur != tail){
            toPrint += cur.value + " ";
            cur = cur.next;
        }
        toPrint += cur.value + "]";
        return toPrint;
    }
    
    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {
        public Node previous;
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public Node(int value, Node next, Node previous) {
            this.next = next;
            this.value = value;
            this.previous = previous;
        }
    }
    
}
