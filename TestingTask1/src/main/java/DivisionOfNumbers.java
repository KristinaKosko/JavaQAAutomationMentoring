public class DivisionOfNumbers implements NumbersManipulator {
    public Validator validator;
    private double result;

    public DivisionOfNumbers(Validator validator) {
        this.validator = validator;
    }

    public double manipulationOfNumbers(double[] listOfNumbers) {
        try {
            validator.validateDivision(listOfNumbers);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
        }
        result = listOfNumbers[0] / listOfNumbers[1];
        return result;
    }

    public void printResult() {
        System.out.println(result);
    }
}