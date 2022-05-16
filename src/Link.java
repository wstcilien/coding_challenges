import org.w3c.dom.Node;

public class Link {
    Node head;
    public void add(int data){
        if(head==null){
            this.head = new Node(data);
            return;
        }else{
            Node current = head;
            while (current.next !=null){
                current = current.next;
            }
            current.next = new Node(data);
        }
    }
    private class Node{
        Node next;
        int data;
        private Node(int data){
            this.data =data;
        }
    }
    @Override
    public String toString(){
        String s ="";
        Node current = head;
        while (current.next != null){
            s = s + current.data+" ";
            current = current.next;
        }
        s = s+current.data;
        return s;
    }

}
