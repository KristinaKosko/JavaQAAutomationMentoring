import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerInJava implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.print("Parameters of test are: ");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        for (Object i : iTestResult.getParameters()){
            System.out.print(i.toString() + "; ");
        }
        System.out.println("");
    }

    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Running " + iTestContext.getName() + " test using Listener written in Java!");
    }

    public void onFinish(ITestContext iTestContext) {

    }
}
