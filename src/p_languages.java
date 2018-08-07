import java.util.Random;

public class p_languages {
    public static void main(String args[]){
        String input = "";
        for(String s:args){
            input+=s;
        }
        System.out.println(input);
        parser_n p = new parser_n(input);
        p.viewLexemesArray();
        //попробуем построит дерево
        node node = new node("-", 0);
        bTreeNode tree = new bTreeNode();
        Random random = new Random();
        for(int i = 10 ; i > 1; i--){
            tree.insert(node, String.format("%d",random.nextInt(10)), random.nextInt(10));
        }
        tree.preorder(node);

        //

    }
}
