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
                if ((inArray(input.charAt(i), Operators) || inArray(input.charAt(i), brackets)) && !stat_operator) {
                if(j!=0 && stat_number!=false) j++;
                output[j] = String.valueOf(input.charAt(i));
                stat_number = false;
                stat_operator = true;
                j++;
                } else if (inArray(input.charAt(i), Numbers) || stat_operator){
                    output[j] += String.valueOf(input.charAt(i));
                    stat_operator = false;
                    stat_number = true;
                } else if(inArray(input.charAt(i), brackets)){
                    output[j] = String.valueOf(input.charAt(i));
                    stat_operator = true;
                    stat_number = false;
                    j++;
                }
            }
        j = 0;
        while(output[j] != ""){
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
           if(inArray(this.out[i].charAt(0), Operators)&&this.lex[i-1].type!="Operator") this.lex[i]=new lexemes("Operator", this.out[i]); else {
               this.lex[i] = new lexemes("Numeric", this.out[i]);
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
}
