import org.junit.runners.Parameterized;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SubCalculatorTest {

    Builder builder;

    @BeforeTest
    public void setUp() throws Exception{
        builder = new Builder();
    }
    
    @Test
    public void test_positive_sub(double first, double second, double result){
        ArrayList<Double> arrayOfOperands = new ArrayList<Double>();
        arrayOfOperands.add(first);
        arrayOfOperands.add(second);
        Assert.assertEquals(builder.getSubtractionOfNumbers().manipulationOfNumbers(arrayOfOperands), result);
    }
}
