import java.util.ArrayList;
import java.util.Scanner;

public class UserQueryManipulator implements Actions {

    Validator validator;
    Builder builder;

    public UserQueryManipulator(Validator validator, Builder builder) {
        this.builder = builder;
        this.validator = validator;
    }

    public ArrayList<Double> EnteredByUserNumbers;

    public void setEnteredByUserNumbers(ArrayList<Double> enteredByUserNumbers) {
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
        try {
            setEnteredByUserNumbers(splitInputOnNumbers(userInput));
        } catch(Exception ex){
            System.out.println("You entered wrong expression! Please try again: ");
            action();
        }
    }

    public void defineWantedOperation() {
        switch (WantedOperation) {
            case '+': {
                builder.SumOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.SumOfNumbers.printResult();
                break;
            }

            case '/': {
                builder.DivisionOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.DivisionOfNumbers.printResult();
                break;
            }

            case '*': {
                builder.MultiplicationOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.MultiplicationOfNumbers.printResult();
                break;
            }

            case '-': {
                builder.SubtractionOfNumbers.manipulationOfNumbers(EnteredByUserNumbers);
                builder.SubtractionOfNumbers.printResult();
                break;
            }

            case 'Y': {
                break;
            }

        }
    }

    public ArrayList<Double> splitInputOnNumbers(String input) throws NoSuchOperationException {
        ArrayList<Double> operands = new ArrayList<Double>();
        determineSignOfOperation(input);
        if (WantedOperation == '(') {
            operands = determineNumbersAndSignOfOperationIfUserUsedBraces(input);
            if (WantedOperation == '0') {
                throw new NoSuchOperationException("There is no such operation with numbers like: ", input);
            }
            else {
                return operands;
            }
        }
        if (WantedOperation == '0') {
            throw new NoSuchOperationException("There is no such operation with numbers like: ", input);
        }
        String[] arrayOfResults = splitOnStringsWithNumbers(input);
        for (String item : arrayOfResults){
            operands.add(parseToDouble(item));
        }
        return operands;
    }

    private String[] splitOnStringsWithNumbers(String input){
        return input.replaceAll("\\s", "").split(String.format("\\%s", WantedOperation));
    }

    private double parseToDouble(String stringNumber){
        return Double.parseDouble(stringNumber);
    }

    private void determineSignOfOperation(String input) {

        if (input.contains("(") && input.contains(")")) {
            WantedOperation = '(';
        } else if (input.contains("+") && !input.contains("-") && !input.contains("/") && !input.contains("*")) {
            WantedOperation = '+';
        } else if (input.contains("-") && !input.contains("+") && !input.contains("/") && !input.contains("*")) {
            WantedOperation = '-';
        } else if (input.contains("*") && !input.contains("-") && !input.contains("/") && !input.contains("+")) {
            WantedOperation = '*';
        } else if (input.contains("/") && !input.contains("-") && !input.contains("+") && !input.contains("*")) {
            WantedOperation = '/';
        } else {
            WantedOperation = '0';
        }
    }

    private ArrayList<Double> determineNumbersAndSignOfOperationIfUserUsedBraces(String input) {
        ArrayList<Double> arrayOfNumbers = new ArrayList<Double>();
        if (input.startsWith("(") && input.endsWith(")")){
            String[] result = input.split("\\(");
            String[] firstOperandAndSign = result[0].split("\\)");
            arrayOfNumbers.add(parseToDouble(firstOperandAndSign[0]));
            arrayOfNumbers.add(parseToDouble(result[1].split("\\)")[0]));
            WantedOperation = firstOperandAndSign[1].toCharArray()[0];
        } else if (input.startsWith("(")){
            String convertedInput = input.replace("(", "");
            String[] result = convertedInput.split("\\)");
            arrayOfNumbers.add(parseToDouble(result[0]));
            determineSignOfOperation(result[1]);
            arrayOfNumbers.add(parseToDouble(splitOnStringsWithNumbers(result[1])[1]));
        } else if (input.endsWith(")")){
            String convertedInput = input.replace(")", "");
            String[] result = convertedInput.split("\\(");
            determineSignOfOperation(result[0]);
            arrayOfNumbers.add(parseToDouble(splitOnStringsWithNumbers(result[0])[0]));
            arrayOfNumbers.add(parseToDouble(result[1]));
        }

        return arrayOfNumbers;
    }
}

