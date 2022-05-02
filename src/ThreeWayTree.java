public class ThreeWayTree {
    private int head;
    private ThreeWayTree content;
    private ThreeWayTree left;
    private ThreeWayTree middle;
    private ThreeWayTree right;

    public ThreeWayTree(){
        content = new ThreeWayTree();
        content.left = left;
        content.middle = middle;
        content.right = right;
    }
    public void insert(int num){
        if(head<num){
            put(num,left);
        }
    }
    private void put(int num,ThreeWayTree tree){
//        if(tree.head != null){
//
//        }
    }

    public int getHead() {
        return head;
    }
}
