
public class p_languages {
    public static void main(String args[]){
        String input = "";
        for(String s:args){
            input+=s;
        }
        System.out.println(input);
        parser p = new parser(input);
        p.generate();
        for(int i = 0; i < p.countValues; i++) p.lex[i].getLexeme();
    }
}
