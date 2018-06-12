import java.util.ArrayList;

public class Utils {

    public String[] splitOnStringsWithNumbers(String input, UserQueryManipulator queryManipulator){
        return input.replaceAll("\\s", "").split(String.format("\\%s", queryManipulator.getWantedOperation()));
    }

    public double parseToDouble(String stringNumber){
        return Double.parseDouble(stringNumber);
    }

    public void printGuide(){
        System.out.println("Use '+', '-', '*' or '/' and numbers for calculating;");
        System.out.println("For expressions with negative numbers use brackets '(' and ')';");
        System.out.println("Use Y/y for exit;");
        System.out.print("Enter your expression: ");
    }

    public void printMenu(){
        System.out.println("Enter 1 if you want to print your expressions into console;");
        System.out.println("Enter 2 if you want to use data from DataBase;");
        System.out.println("Enter 3 if you want to use data from file (.json):");
    }

    public void determineSignOfOperation(String input, UserQueryManipulator queryManipulator) {

        if (input.contains("(") && input.contains(")")) {
            queryManipulator.setWantedOperation('(');
        } else if (input.contains("+") && !input.contains("-") && !input.contains("/") && !input.contains("*")) {
            queryManipulator.setWantedOperation('+');
        } else if (input.contains("-") && !input.contains("+") && !input.contains("/") && !input.contains("*")) {
            queryManipulator.setWantedOperation('-');
        } else if (input.contains("*") && !input.contains("-") && !input.contains("/") && !input.contains("+")) {
            queryManipulator.setWantedOperation('*');
        } else if (input.contains("/") && !input.contains("-") && !input.contains("+") && !input.contains("*")) {
            queryManipulator.setWantedOperation('/');
        } else {
            queryManipulator.setWantedOperation('0');
        }
    }

    public ArrayList<Double> determineNumbersAndSignOfOperationIfUserUsedBraces(String input, UserQueryManipulator queryManipulator) {
        ArrayList<Double> arrayOfNumbers = new ArrayList<Double>();
        if (input.startsWith("(") && input.endsWith(")")){
            String[] result = input.split("\\(");
            String[] firstOperandAndSign = result[0].split("\\)");
            arrayOfNumbers.add(parseToDouble(firstOperandAndSign[0]));
            arrayOfNumbers.add(parseToDouble(result[1].split("\\)")[0]));
            queryManipulator.setWantedOperation(firstOperandAndSign[1].toCharArray()[0]);
        } else if (input.startsWith("(")){
            String convertedInput = input.replace("(", "");
            String[] result = convertedInput.split("\\)");
            arrayOfNumbers.add(parseToDouble(result[0]));
            determineSignOfOperation(result[1], queryManipulator);
            arrayOfNumbers.add(parseToDouble(splitOnStringsWithNumbers(result[1], queryManipulator)[1]));
        } else if (input.endsWith(")")){
            String convertedInput = input.replace(")", "");
            String[] result = convertedInput.split("\\(");
            determineSignOfOperation(result[0], queryManipulator);
            arrayOfNumbers.add(parseToDouble(splitOnStringsWithNumbers(result[0], queryManipulator)[0]));
            arrayOfNumbers.add(parseToDouble(result[1]));
        }

        return arrayOfNumbers;
    }

    public ArrayList<Double> splitInputOnNumbers(String input, UserQueryManipulator queryManipulator) throws NoSuchOperationException {
        ArrayList<Double> operands = new ArrayList<Double>();
        determineSignOfOperation(input, queryManipulator);
        if (queryManipulator.getWantedOperation() == '(') {
            operands = determineNumbersAndSignOfOperationIfUserUsedBraces(input, queryManipulator);
            if (queryManipulator.getWantedOperation() == '0') {
                throw new NoSuchOperationException("There is no such operation with numbers like: ", input);
            }
            else {
                return operands;
            }
        }
        if (queryManipulator.getWantedOperation() == '0') {
            throw new NoSuchOperationException("There is no such operation with numbers like: ", input);
        }
        String[] arrayOfResults = splitOnStringsWithNumbers(input, queryManipulator);
        for (String item : arrayOfResults){
            operands.add(parseToDouble(item));
        }
        return operands;
    }
}
