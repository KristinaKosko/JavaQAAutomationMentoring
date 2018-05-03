import java.util.ArrayList;
import java.util.Scanner;

public class UserQueryManipulator implements Actions {

    Validator validator;
    Builder builder;
    Utils utils;

    public UserQueryManipulator(Validator validator, Builder builder, Utils utils) {
        this.builder = builder;
        this.validator = validator;
        this.utils = utils;
    }

    public ArrayList<Double> EnteredByUserNumbers;

    public void setEnteredByUserNumbers(ArrayList<Double> enteredByUserNumbers) {
        EnteredByUserNumbers = enteredByUserNumbers;
    }

    private char WantedOperation;

    public void setWantedOperation(char wantedOperation) {
        WantedOperation = wantedOperation;
    }

    public char getWantedOperation() {
        return WantedOperation;
    }

    public void action() {
        String userInput = "";
        System.out.println("Use '+', '-', '*' or '/' and numbers for calculating;");
        System.out.println("For expressions with negative numbers use brackets '(' and ')';");
        System.out.println("Use Y/y for exit;");
        System.out.print("Enter your expression: ");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            userInput = in.next();
        }
        if (!validator.validateExit(userInput)) {
            System.out.println("Thanks for using! Bye!");
            System.exit(0);
        }
        try {
            setEnteredByUserNumbers(utils.splitInputOnNumbers(userInput, this));
        } catch(Exception ex){
            System.out.println("You entered wrong expression! Please try again: ");
            action();
        }
    }

    public void defineWantedOperation() {
        switch (WantedOperation) {
            case '+': {
                builder.getSumOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                builder.getSumOfNumbers().printResult();
                break;
            }

            case '/': {
                builder.getDivisionOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                builder.getDivisionOfNumbers().printResult();
                break;
            }

            case '*': {
                builder.getMultiplicationOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                builder.getMultiplicationOfNumbers().printResult();
                break;
            }

            case '-': {
                builder.getSubtractionOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                builder.getSubtractionOfNumbers().printResult();
                break;
            }
        }
    }
}

