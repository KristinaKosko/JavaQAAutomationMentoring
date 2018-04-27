public class SumOfNumbers implements NumbersManipulator {
    private double result;

    public double manipulationOfNumbers(double[] listOfNumbers) {
        for (double item : listOfNumbers) {
            result += item;
        }
        return result;
    }

    public void printResult() {
        System.out.println(result);
    }
}
