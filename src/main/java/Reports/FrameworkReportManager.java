package Reports;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class FrameworkReportManager {
    private static ThreadLocal<ExtentTest> extentTestThl= new ThreadLocal<>();

    private FrameworkReportManager() {
    }

    public static ExtentTest getExtentTest()
    {
        return extentTestThl.get();
    }

    public static void setExtentTest(ExtentTest test)
    {
        if(Objects.nonNull(test)) {
            extentTestThl.set(test);
        }

    }

    public static void unload()
    {
        extentTestThl.remove();
    }
}
