public interface INode {
    int Key = 0;
    INode parent = null;
    String value = null;
    INode leftChild = null;
    INode rightChild = null;
    String getNode();
    String nodeType();
}
class numericNode implements INode{
    INode parent;
    Double value;
    int Key;
    numericNode(INode parent, String value, int Key){
        this.parent = parent;
        this.value = Double.valueOf(value);
        this.Key = Key;
    }
    @Override
    public String getNode() {
        return null;
    }

    @Override
    public String nodeType() {
        return "Numeric";
    }
}

class operatorNode implements INode{
    INode parent;
    INode leftChild;
    INode rightChild;
    String value;
    int Key;
    operatorNode(INode parent, String value, int Key){
        this.parent = parent;
        this.value = value;
        this.Key = Key;
    }
    @Override
    public String getNode() {
        return null;
    }

    @Override
    public String nodeType() {
        return "Operator";
    }

}
class nodeTree implements INode {
    operatorNode root;

    nodeTree(INode parent, String value, int Key){
        root = new operatorNode(parent, value, Key);
    }
    public void getTree(INode node){

            System.out.println(node.value);
            if(node.leftChild!=null){
                getTree(node.leftChild);
            }
            if(node.rightChild!=null){
                getTree(node.rightChild);
            }
    }

    @Override
    public String getNode() {
        return null;
    }

    @Override
    public String nodeType() {
        return null;
    }
}