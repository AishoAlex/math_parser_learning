public class parser {
    String out[];
    int countValues;
    char[] Operators = {'*', '/', '+', '-'};
    char[] Numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
    char[] brackets = {'(', ')'};

    lexemes[] lex;
    boolean errorStats = false;
    parser(String input){
        String[] output = new String[input.length()];
        for(int i = 0; i < input.length();i++){
            output[i] = "";
        }
        boolean stat_number = false;
        boolean stat_operator = false;
        int j = 0;
        for(int i = 0; i < input.length(); i++) {
                if ((inArray(input.charAt(i), Operators)) && !stat_operator) {
                if(j!=0 && stat_number!=false) j++;
                output[j] = String.valueOf(input.charAt(i));
                stat_number = false;
                stat_operator = true;
                j++;
                } else if (inArray(input.charAt(i), Numbers) || stat_operator && input.charAt(i) != '('){
                    output[j] += String.valueOf(input.charAt(i));
                    stat_operator = false;
                    stat_number = true;
                } else if(inArray(input.charAt(i), brackets)){
                    if(j!=0 && input.charAt(i) == ')' && input.charAt(i-1)!=')') j++;
                    output[j] = String.valueOf(input.charAt(i));
                    stat_operator = false;
                    stat_number = false;
                    j++;
                }
            }
        j = 0;
        while(!output[j].isEmpty()){
            j++;
        }
        this.out = new String[j];
        for(int i = 0; i < j; i++){
            this.out[i] = output[i];
        }
        this.countValues = j;
        for(int i = 0; i < this.countValues; i++){
            System.out.println(this.out[i]);
        }
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
    public int generate(){
        this.lex = new lexemes[this.countValues];
        for(int i = 0; i < this.countValues; i++){
           if((inArray(this.out[i].charAt(0), Operators) || inArray(this.out[i].charAt(0), brackets)) && this.out[i].length() == 1)
               this.lex[i]=new lexemes("Operator", this.out[i]);
           else {
               this.lex[i] = new lexemes("Numeric", this.out[i]); //&&this.lex[i-1].type!="Operator"
               if(this.lex[i].validation()!=0){ // TODO: 28.03.2018 Get refactored!
                   System.out.println("Error!");
                   this.errorStats = true;
                   break;
               }
           }
        }
        return 0;
    }
    public boolean validation(){
        boolean stat = true;
        int bracket = 0;
        if(this.lex[0]!=null){
            for(int i = 0; i < countValues; i++){
                //Brackets check
                if(this.lex[i].value.charAt(0) == '('){
                    bracket++;
                }else if(this.lex[i].value.charAt(0) == ')'){
                    bracket--;
                }
                if(bracket < 0) return false;
            }
        } else stat = false;
        if(bracket!=0) stat = false;
        return stat;
    }
    public int findNode(){
        int opIndex = 0;
        int Node = 0;
        int priority = -1;
        int bracketStat = 0;
        lexemes[][] complex;
        complex = new lexemes[countValues][countValues];
        int complexCount = 0;
        int complexIndex = 0;
        int subStrLex = 0;
        for(int i = 0; i < countValues; i++){
            if(lex[i].type == "Operator") {
                switch (lex[i].value) {
                    case "(":
                        bracketStat++;
                        break;

                    case ")":
                        bracketStat--;
                        //complexIndex++;
                        complex[complexCount][complexIndex] = new lexemes(lex[i].type, lex[i].value);
                        complexCount++;
                        complexIndex = 0;
                        subStrLex++;
                        break;
                }
            }
                if(bracketStat == 0){
                    if(operatorPriority(lex[i].value) > priority){
                        priority = operatorPriority(lex[i].value);
                        Node = i;
                    }
                } else {
                    complex[complexCount][complexIndex] = new lexemes(lex[i].type, lex[i].value);
                    complexIndex++;
                    subStrLex++;
                }
            System.out.println(lex[i].value+": "+operatorPriority(lex[i].value));
            }

        subStrLex = 0;
        System.out.println("Субстрока:");
        for(int j = 0;complex[j][0]!=null; j++){
            deleteLexeme(complex[j], 0);
        for(int i = 0;complex[j][i]!=null; i++){
        subStrLex++;
        }
            deleteLexeme(complex[j], subStrLex-1);
            subStrLex = 0;
        }
        System.out.println("_______________");
        for(int i = 0; complex[i][0]!=null; i++){
            for(int j = 0; complex[i][j]!=null; j++){
                System.out.println(complex[i][j].value+" : "+complex[i][j].type);
            }
            System.out.println("_______________");
        }
        //Node = opIndex;
        return Node;
    }
    private int deleteLexeme(lexemes[] dlex, int index){
        dlex[index] = new lexemes("0", "0");
        for(int i = index; dlex[i]!=null; i++){
            dlex[i] = dlex[i+1];
        }
        return 0;
    }
    private int operatorPriority(String o){

        switch (o) {
            case "+":
                return 2;
            case "-":
                return 2;
            case "*":
                return 1;
            case "/":
                return 1;
            case "(":
                return 0;
            case ")" :
                return 0;
            default:  return -1;
        }
    }
}
