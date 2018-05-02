import java.util.ArrayList;

public class DivisionOfNumbers implements NumbersManipulator {
    public Validator validator;
    private double result;

    public DivisionOfNumbers(Validator validator) {
        this.validator = validator;
    }

    public double manipulationOfNumbers(ArrayList<Double> listOfNumbers) {
        result = 0;
        try {
            validator.validateDivision(listOfNumbers);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        }
        result = listOfNumbers.get(0) / listOfNumbers.get(1);
        return result;
    }

    public void printResult() {
        System.out.println(result);
    }
}