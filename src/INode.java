public interface INode {
    void setNode(lexemes lex);
    String getNode();
}
class NumericNode implements INode{
    int iData; //Используется в качестве ключа
    double value;
    INode leftChild;
    INode rightChild;
    @Override
    public void setNode(lexemes lex) {
        this.value = Double.parseDouble(lex.value); // TODO: 28.03.2018 Formalisation tree-generation algorithm(reqursion?) and find optimal path for set childs 
    }

    @Override
    public String getNode() {
        return null;
    }
}

class OperatorNode implements INode{

    @Override
    public void setNode(lexemes lex) {
    }

    @Override
    public String getNode() {
        return null;
    }
}