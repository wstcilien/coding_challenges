import java.util.Stack;

public class ThreeWayTree{
    public Node head;
    public void ThreeWayTree(){

    }
    public void add(int val){
        System.out.println("you want to add "+val);
        if(head==null){
            this.head = new Node(val);
            System.out.println("added "+val);

            return;
        }else{
            Node current = head;
            System.out.println("head "+current.value+" ");
            recursiveCallToAdd(current,val);

        }
    }
    private void recursiveCallToAdd(Node holder,int value){
        Node current = holder;
        if(current.value > value && current.left ==null){
            System.out.println(" going left to add "+value);
            current.left = new Node(value);
            return;
        }else if(current.value < value && current.right ==null){
            current.right = new Node(value);
            System.out.println(" going right to add "+value);
            return;
        }else if(current.value == value && current.middle ==null){
            current.middle = new Stack<>();
            current.middle.push(value);
            System.out.println(value);
            return;
        }else if(current.value > value ){
            System.out.print(" moving left "+current.value);
            current = current.left;
            recursiveCallToAdd(current, value);
            System.out.println("");
            return;
        }else if(current.value < value ){
            System.out.print(" moving right "+current.value);
            current = current.right;
            recursiveCallToAdd(current, value);
            System.out.println("");
            return;
        }else {
            System.out.print(current.value);
            current.middle.push(value);
            System.out.println("");
            return;
        }
    }

    private class Node{
        private int value;
        private Node left;
        private Stack<Integer> middle;
        private Node right;

        private Node(int data){
            this.value = data;
        }
    }
}