public class parser_n {
    String out[];
    int lexemesCount;
    char[] Operators = {'*', '/', '+', '-'};
    char[] Numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
    //char[] brackets = {'(', ')'};
    parser_n(String input){
        int j = 0;
        boolean LeftBracketStat = false;
        boolean OperatorStat = false;
        //out array initialisation start
        this.out = new String[input.length()];
        for(int i = 0; i < input.length();i++){
            out[i] = "";
        }
        //out array initialisation complete
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i)=='('){
                LeftBracketStat = true;
                if(i != 0) j++;
                out[j] = String.valueOf(input.charAt(i));
            } else if(inArray(input.charAt(i), Numbers) || LeftBracketStat == true || OperatorStat == true || i==0){
                if (LeftBracketStat) j++; else if(OperatorStat) j++;
                LeftBracketStat = false;
                OperatorStat = false;
                out[j] += String.valueOf(input.charAt(i));
            } else if(inArray(input.charAt(i),Operators)){
                OperatorStat = true;
                j++;
                out[j] = String.valueOf(input.charAt(i));
            } else if(input.charAt(i) == ')'){
                j++;
                out[j] = String.valueOf(input.charAt(i));
            }
        }
        this.lexemesCount = j+1;
    }
    private boolean inArray(char in, char[] array){
        boolean stat = false;
        for(int i = 0; i < array.length; i++){
            if(array[i] == in){
                stat = true;
            }
        }
        return stat;
    }
    public void viewLexemesArray(){
        for(int i = 0; i < this.lexemesCount; i++){
            System.out.println(this.out[i]);
        }
    }

}
