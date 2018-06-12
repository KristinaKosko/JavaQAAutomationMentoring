public enum Operations {
    sum ('+'),
    division ('/'),
    multiplication ('*'),
    subtraction ('-');

    private final char operation;

    Operations(char operation){
        this.operation = operation;
    }

    public char getChosenOperation(){
        return operation;
    }
}
