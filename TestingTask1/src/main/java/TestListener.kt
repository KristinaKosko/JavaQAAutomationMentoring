import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

public class TestListener : ITestListener{
    override fun onTestSkipped(p0: ITestResult?) {
    }

    override fun onTestSuccess(p0: ITestResult?) {
        if (p0 != null) {
            for (i in p0.parameters) {
                print(i.toString() + "; ")
            }
        }
        println("")
    }

    override fun onTestFailure(p0: ITestResult?) {
    }

    override fun onTestFailedButWithinSuccessPercentage(p0: ITestResult?) {
    }

    override fun onTestStart(p0: ITestResult?) {
        println("Parameters of test are: ")
    }

    override fun onStart(p0: ITestContext?) {
        if (p0 != null) {
            println("Running " + p0.getName() + " test using Listener written in Kotlin!")
        }
    }

    override fun onFinish(p0: ITestContext?) {
    }

}