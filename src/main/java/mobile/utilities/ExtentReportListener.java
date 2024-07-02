package mobile.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener{
	
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void initializeExtentReport(String path) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentTest createTest(String testName) {
        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);
        return extentTest;
    }


    public static void flushExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }

@Override
public void onStart(ITestContext context) {
    // Not required as we initialize in @BeforeClass of tests
}

@Override
public void onTestSuccess(ITestResult result) {
    test.get().log(Status.PASS, "Test Passed");
}

@Override
public void onTestFailure(ITestResult result) {
    test.get().log(Status.FAIL, "Test Failed");
    test.get().log(Status.FAIL, result.getThrowable());
}

@Override
public void onTestSkipped(ITestResult result) {
    test.get().log(Status.SKIP, "Test Skipped");
}

@Override
public void onFinish(ITestContext context) {
    flushExtentReports();
}

}
