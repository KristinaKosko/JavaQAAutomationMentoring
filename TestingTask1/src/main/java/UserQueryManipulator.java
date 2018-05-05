import java.util.ArrayList;
import java.util.Scanner;

public class UserQueryManipulator implements Actions {

    Validator validator;
    DataReadersBuilder dataReadersBuilder;
    Builder builder;
    Utils utils;

    public UserQueryManipulator(Validator validator, Builder builder, Utils utils, DataReadersBuilder dataReadersBuilder) {
        this.builder = builder;
        this.validator = validator;
        this.utils = utils;
        this.dataReadersBuilder = dataReadersBuilder;
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
        Scanner in = new Scanner(System.in);
        String userInput = "";
        utils.printMenu();
        if (in.hasNext()) {
            userInput = in.next();
        }
        try {
            if (validator.validateMenu(userInput)) {
                switch (Integer.parseInt(userInput)) {
                    case (1):
                        utils.printGuide();
                        if (in.hasNext()) {
                            userInput = in.next();
                        }
                        if (!validator.validateExit(userInput)) {
                            System.out.println("Thanks for using! Bye!");
                            System.exit(0);
                        }
                        setEnteredByUserNumbers(utils.splitInputOnNumbers(userInput, this));
                        defineWantedOperation();
                        printResultOfOperation();
                        break;
                    case (2):
                        ArrayList<String> input = dataReadersBuilder.getDataGetterFromDB().getData();
                        for (String expression : input) {
                            setEnteredByUserNumbers(utils.splitInputOnNumbers(expression, this));
                            defineWantedOperation();
                            printResultOfOperation();
                        }
                        break;
                    case (3):
                        dataReadersBuilder.getJsonParser().parseJsonFile("C:\\Users\\Krystsina_Kasko\\IdeaProjects\\TestingTask1\\src\\main\\resources\\JsonDataProvider.json");
                        input = dataReadersBuilder.getJsonParser().getData();
                        for (String expression : input) {
                            setEnteredByUserNumbers(utils.splitInputOnNumbers(expression, this));
                            defineWantedOperation();
                            System.out.print(EnteredByUserNumbers.get(0)+String.valueOf(WantedOperation)+EnteredByUserNumbers.get(1)+"=");
                            printResultOfOperation();
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            System.out.println("You entered wrong expression! Please try again: ");
            action();
        }
    }

    public void defineWantedOperation() {
        switch (WantedOperation) {
            case '+': {
                builder.getSumOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                break;
            }

            case '/': {
                builder.getDivisionOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                break;
            }

            case '*': {
                builder.getMultiplicationOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                break;
            }

            case '-': {
                builder.getSubtractionOfNumbers().manipulationOfNumbers(EnteredByUserNumbers);
                break;
            }
        }
    }

    public void printResultOfOperation() {
        switch (WantedOperation) {
            case '+': {
                builder.getSumOfNumbers().printResult();
                break;
            }

            case '/': {
                builder.getDivisionOfNumbers().printResult();
                break;
            }

            case '*': {
                builder.getMultiplicationOfNumbers().printResult();
                break;
            }

            case '-': {
                builder.getSubtractionOfNumbers().printResult();
                break;
            }
        }
    }
}

