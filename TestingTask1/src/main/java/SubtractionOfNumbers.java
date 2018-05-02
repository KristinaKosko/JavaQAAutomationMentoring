import java.util.ArrayList;

public class SubtractionOfNumbers implements NumbersManipulator {

    private double result;
    public double manipulationOfNumbers(ArrayList<Double> listOfNumbers) {
        result = 0;
        result = listOfNumbers.get(0) - listOfNumbers.get(1);
        return result;
    }

    public void printResult() {
        System.out.println(result);
    }
}
