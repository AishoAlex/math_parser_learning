public interface INode {
    String getNode();
}
class NumericNode implements INode{
    int iData; //Используется в качестве ключа
    double value;
    INode leftChild;
    INode rightChild;
    @Override
    public String getNode() {
        return null;
    }
}

class OperatorNode implements INode{
    int iData; //Используется в качестве ключа
    char value;
    INode leftChild;
    INode rightChild;
//    OperatorNode(lexemes lex, int index) {
//        this.value = lex.value.charAt(0); // TODO: 28.03.2018 Formalisation tree-generation algorithm(reqursion?) and find optimal path for set childs
//        this.iData = index;
//    }
//    @Override
//    public void setChildren(INode left, INode right) {
//
//    }

    @Override
    public String getNode() {
        return null;
    }
}
class Tree{
    INode root;
    public void insert(int index, lexemes lex){
        {

        }
    }
}