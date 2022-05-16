public class LinkList {
    Node head;

    public void add(int value){
        if(head == null){
            this.head = new Node(value);

        }else{
            Node current = head;
            while (current != null){
                current = current.next;

            }
            if(current.next == null){
                current.next = new Node(value);
            }
        }
    }


    private class Node {
        Node next;
        int val;

        private Node(int data){
            this.val = data;
        }
    }
}
