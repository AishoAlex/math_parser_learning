public class node{
    String data;
    int controlFlow;
    node left;
    node right;

    node(String data, int controlFlow){
        this.data = data;
        this.controlFlow = controlFlow;
    }
}
class bTreeNode {

    void insert(node node, String value, int controlFlow) {
        if (controlFlow < node.controlFlow) {
            if (node.left != null)
                insert(node.left, value, controlFlow);
            else {
                System.out.println("Inserted " + value + " to left of " + node.data);
                node.left = new node(value, controlFlow);
            }
        } else if (controlFlow > node.controlFlow) {
            if (node.right != null)
                insert(node.right, value, controlFlow);
            else {
                System.out.println("Inserted " + value + " to right of " + node.data);
                node.right = new node(value, controlFlow);
            }
        }
    }
    void preorder(node node) {
        if (node != null)  {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
