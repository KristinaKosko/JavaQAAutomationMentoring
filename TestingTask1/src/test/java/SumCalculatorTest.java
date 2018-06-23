import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SumCalculatorTest {


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
        public void test_positive_sum(double first, double second, double result){
            ArrayList<Double> arrayOfOperands = new ArrayList<Double>();
            arrayOfOperands.add(first);
            arrayOfOperands.add(second);
            Assert.assertEquals(builder.getSumOfNumbers().manipulationOfNumbers(arrayOfOperands), result);
        }


    }

