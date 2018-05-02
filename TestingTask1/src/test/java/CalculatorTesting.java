import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorTesting {

    Builder builder;

    @BeforeTest
    public void setUp() throws Exception{
        builder = new Builder();
    }

    @DataProvider
    public Object[][] sumPositiveData(){
        return new Object[][]{
                {1, 0, 1.0},
                {1, 5, 6.0},
                {1, -1, 0.0},
                {0, 0, 0.0},
        };
    }

    @Test(dataProvider = "sumPositiveData")
    public void test_positive_sum_1and0(double first, double second, double result){
        //Assert.assertEquals(builder.SumOfNumbers.manipulationOfNumbers( new ArrayList<Double>() {first, second}), result);
    }
}
