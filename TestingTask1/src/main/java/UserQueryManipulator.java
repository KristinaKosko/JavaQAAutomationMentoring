import java.lang.reflect.Array;
import java.util.Scanner;

public class UserQueryManipulator implements Actions {

    Validator validator;
    Builder builder;

    public UserQueryManipulator(Validator validator, Builder builder) {
        this.builder = builder;
        this.validator = validator;
    }

    public double[] EnteredByUserNumbers;
    private void setEnteredByUserNumbers(double[] enteredByUserNumbers) {
        EnteredByUserNumbers = enteredByUserNumbers;
    }

    public char WantedOperation;

    public void action() {
        String userInput = "";
        System.out.println("Enter your expression");
        System.out.println("Use '+', '-', '*' or '/' and numbers for calculating.");
        System.out.println("Use Y/y for exit:");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            userInput = in.next();
        }
        if (validator.validateUserQuery(userInput, this)) {
            setEnteredByUserNumbers(getUserNumbers(userInput));
        }
        else {
                System.out.println("You entered wrong expression! Please try again: ");
                action();
        }
    }

    public double[] getUserNumbers(String userInput) {

        String[] subStrings = new String[2];
        try {
            subStrings = splitInputOnNumbers(userInput);
        } catch (NoSuchOperationException e) { }
        double[] numbers = new double[2];
        int i = 0;
        for (String subString : subStrings) {
            numbers[i] = Double.parseDouble(subString);
            i++;
        }
        return numbers;
    }

    public void defineWantedOperation(){
        switch (WantedOperation){
            case '+' : {
                builder.SumOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.SumOfNumbers.printResult();
                break;
            }

            case '/' :{
                builder.DivisionOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.DivisionOfNumbers.printResult();
                break;
            }

            case '*' :{
                builder.MultiplicationOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.MultiplicationOfNumbers.printResult();
                break;
            }

            case '-' :{
                builder.SubtractionOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.SubtractionOfNumbers.printResult();
                break;
            }

            case 'Y':{
                break;
            }

        }
    }

    public String[] splitInputOnNumbers(String input) throws NoSuchOperationException{
        char delimiter = determineSignOfOperation(input);
        if (delimiter == '0'){
            throw new NoSuchOperationException("There is no such operation with numbers like: ", delimiter);
        }
        String[] subStrings = input.replaceAll("\\s", "").split(String.format("\\%s", delimiter));
        return subStrings;
    }

    private char determineSignOfOperation(String input) {
        if (input.contains("+") && !input.contains("-") && !input.contains("/") && !input.contains("*")) {
            return WantedOperation = '+';
        } else if (input.contains("-") && !input.contains("+") && !input.contains("/") && !input.contains("*")) {
            return WantedOperation = '-';
        } else if (input.contains("*") && !input.contains("-") && !input.contains("/") && !input.contains("+")) {
            return WantedOperation = '*';
        } else if (input.contains("/") && !input.contains("-") && !input.contains("+") && !input.contains("*")) {
            return WantedOperation = '/';
        } else {
            return '0';
        }
    }
}

