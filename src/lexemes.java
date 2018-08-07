public class lexemes {
    String type;
    String value;

    lexemes(String type, String value){
        this.type = type;
        this.value = value;
    }
    void getLexeme(){
        System.out.printf("Type:%8s  |Value: %s\n", this.type,this.value);
    }
    int validation(){
        if(this.type == "Numeric"){
            boolean dot = false;
            for(int i = 0; i < this.value.length(); i++){
                if(this.value.charAt(i) == '.' && !dot){
                    dot = true;
                } else if(this.value.charAt(i) == '.' && dot){
                    System.out.println("Error: the number cannot be " + this.value);
                    return -1;
                }
            }
        }
        return 0;
    }

}
