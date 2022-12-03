package Utils;

import Driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class FrameworkScreenshot {

    private FrameworkScreenshot() {
    }

    public static String getScreenshot()
    {
        TakesScreenshot scrShot =((TakesScreenshot) DriverManager.getDriver());
        return scrShot.getScreenshotAs(OutputType.BASE64);

    }
}
