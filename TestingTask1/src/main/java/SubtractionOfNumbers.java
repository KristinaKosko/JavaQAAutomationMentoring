public class SubtractionOfNumbers implements NumbersManipulator {

    private double result;
    public double manipulationOfNumbers(double[] listOfNumbers) {
        result = listOfNumbers[0]-listOfNumbers[1];
        return result;
    }

    public void printResult() {
        System.out.println(result);
    }
}
