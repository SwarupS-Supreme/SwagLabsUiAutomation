package Reports;
import Enums.PropertyEnum;
import Utils.FrameworkScreenshot;
import Utils.PropertyUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class FrameworkReportLogger {
    private FrameworkReportLogger() {

    }

    public static void pass(String message) {
        FrameworkReportManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        FrameworkReportManager.getExtentTest().fail(message);

    }

    public static void skip(String message) {
        FrameworkReportManager.getExtentTest().skip(message);
    }

    public static void pass(String message,Boolean isScreenshot) {
        if(isScreenshot && PropertyUtils.get(PropertyEnum.PASSEDSTEPSCREENSHOT.toString().toLowerCase()).equalsIgnoreCase("yes")) {
            FrameworkReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(FrameworkScreenshot.getScreenshot()).build());
        }
        else
        {
            pass(message);
        }
    }

    public static void fail(String message,Boolean isScreenshot) {
        if(isScreenshot && PropertyUtils.get(PropertyEnum.FAILEDSTEPSCREENSHOT.toString().toLowerCase()).equalsIgnoreCase("yes")) {
            FrameworkReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(FrameworkScreenshot.getScreenshot()).build());
        }
        else
        {
            fail(message);
        }
    }

    public static void skip(String message,Boolean isScreenshot) {
        if(isScreenshot && PropertyUtils.get(PropertyEnum.SKIPSTEPSCREENSHOT.toString().toLowerCase()).equalsIgnoreCase("yes")) {
            FrameworkReportManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(FrameworkScreenshot.getScreenshot()).build());
        }
        else
        {
            skip(message);
        }
    }


}
