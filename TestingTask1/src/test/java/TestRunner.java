import com.sun.org.apache.xerces.internal.xs.StringList;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args){
        TestNG testNG = new TestNG();
        // testNG.addListener(new TestListener());
        XmlSuite suite = new XmlSuite();
        suite.setName("SuiteOfTestsToRun");
        List<String> files = new ArrayList<String>();
        files.addAll(new ArrayList<String>(){{
            add("./src/test/resources/testng.xml");
        }});
        suite.setSuiteFiles(files);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.run();
    }
}
