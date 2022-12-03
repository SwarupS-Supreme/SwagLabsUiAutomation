package Listeners;

import Annotation.FrameworkAnnotation;
import Reports.FrameworkReportLogger;
import Reports.FrameworkReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public final class FrameworkListener implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite) {
        FrameworkReporter.initReport();
    }

    public void onFinish(ISuite suite) {
        FrameworkReporter.flushReports();
    }

    public void onTestStart(ITestResult result) {
        FrameworkReporter.createTest(result.getMethod().getMethodName());
        FrameworkReporter.addTestCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).testCategory());
        FrameworkReporter.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).authors());

    }

    public void onTestSuccess(ITestResult result) {
        FrameworkReportLogger.pass(result.getMethod().getMethodName() + " " + "is passed",true);
    }

    public void onTestFailure(ITestResult result) {
        FrameworkReportLogger.fail(result.getMethod().getMethodName() + " " + "is failed",true);
     }

    public void onTestSkipped(ITestResult result) {
        FrameworkReportLogger.skip(result.getMethod().getMethodName() + " " + "is skipped",false);
    }


}
