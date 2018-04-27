public class Builder {

    Validator validator = new Validator();
    public SumOfNumbers SumOfNumbers = new SumOfNumbers();
    public SumOfNumbers getSumOfNumbers() {
        return SumOfNumbers;
    }

    public DivisionOfNumbers DivisionOfNumbers = new DivisionOfNumbers(validator);
    public DivisionOfNumbers getDivisionOfNumbers() {
        return DivisionOfNumbers;
    }

    public MultiplicationOfNumbers MultiplicationOfNumbers = new MultiplicationOfNumbers();
    public MultiplicationOfNumbers getMultiplicationOfNumbers() {
        return MultiplicationOfNumbers;
    }

    public SubtractionOfNumbers SubtractionOfNumbers = new SubtractionOfNumbers();
    public SubtractionOfNumbers getSubtractionOfNumbers() {
        return SubtractionOfNumbers;
    }
}
