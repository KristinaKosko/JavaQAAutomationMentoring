public class NoSuchOperationException extends Exception {

    private char operator;
    public char getOperator() {
        return operator;
    }
    public NoSuchOperationException(String message, char operator){
        super(message);
        this.operator = operator;
    }
}
