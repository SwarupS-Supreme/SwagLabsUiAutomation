package Pages;

import Driver.DriverManager;
import Enums.WaitEnum;
import Reports.FrameworkReportLogger;
import WaitFactory.ExplicitWaitDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

    protected final String getTitle() {
        String title = DriverManager.getDriver().getTitle();
        FrameworkReportLogger.pass("Web Page Title " + " " + title + " is successfully retrieved",true);
        return title;
    }

    protected final String getVisibleTextFromUi(By by, WaitEnum wait) {
        String textFromUI= ExplicitWaitDetails.waitForElement(by, wait).getText();
        FrameworkReportLogger.pass("Text from UI is " + " " + textFromUI + " and it is successfully retrieved",true);
        return textFromUI;
    }

    protected final void clickOnElement(By by, WaitEnum wait, String text) {
        ExplicitWaitDetails.waitForElement(by, wait).click();
        FrameworkReportLogger.pass(text + " " + "is clicked",true);

    }

    protected final void enterText(By by, String text, WaitEnum wait) {
        ExplicitWaitDetails.waitForElement(by, wait).sendKeys(text);
        FrameworkReportLogger.pass(text + " " + "is entered",true);

    }

    protected final List<WebElement> getListOfWebElement(By by) {
        return ExplicitWaitDetails.waitForListOfWebElements(by);
    }

    protected final void scrollToTopOfPage() {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.scrollTo(0, 0)");
    }

    protected final void scrollToBottomOfPage() {
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected final void selectByVisibleTextFromDropdown(By by, String value) {
        Select select = new Select(DriverManager.getDriver().findElement(by));
        select.selectByVisibleText(value);
    }

}
