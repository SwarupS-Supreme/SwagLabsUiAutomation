package WaitFactory;

import Driver.DriverManager;
import Enums.WaitEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class ExplicitWaitDetails {

    private ExplicitWaitDetails()
    {

    }

    public static WebElement waitForElement(By by, WaitEnum waitStrategy)
    {
        WebElement element=null;
        if(WaitEnum.VISIBILITY == waitStrategy) {
            element = new WebDriverWait(DriverManager.getDriver()
                    , Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(WaitEnum.CLICKABILITY == waitStrategy) {
            element = new WebDriverWait(DriverManager.getDriver()
                    , Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(WaitEnum.PRESENCE == waitStrategy) {
            element = new WebDriverWait(DriverManager.getDriver()
                    , Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }

        else
        {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }

    public static List<WebElement> waitForListOfWebElements(By by)
    {

       return new WebDriverWait(DriverManager.getDriver()
                , Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(DriverManager.getDriver().findElements(by)));
    }
}
