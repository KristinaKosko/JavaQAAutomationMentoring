public class NoSuchOperationException extends Exception {

    private String input;
    public String getInput() {
        return input;
    }
    public NoSuchOperationException(String message, String userInput){
        super(message);
        this.input = userInput;
    }
}
