public class Builder {

    Validator validator = new Validator();
    private SumOfNumbers SumOfNumbers = new SumOfNumbers();
    public SumOfNumbers getSumOfNumbers() {
        return SumOfNumbers;
    }

    private DivisionOfNumbers DivisionOfNumbers = new DivisionOfNumbers(validator);
    public DivisionOfNumbers getDivisionOfNumbers() {
        return DivisionOfNumbers;
    }

    private MultiplicationOfNumbers MultiplicationOfNumbers = new MultiplicationOfNumbers();
    public MultiplicationOfNumbers getMultiplicationOfNumbers() {
        return MultiplicationOfNumbers;
    }

    private SubtractionOfNumbers SubtractionOfNumbers = new SubtractionOfNumbers();
    public SubtractionOfNumbers getSubtractionOfNumbers() {
        return SubtractionOfNumbers;
    }
}
