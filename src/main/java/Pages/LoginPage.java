package Pages;

import Driver.DriverManager;
import Enums.WaitEnum;
import Reports.FrameworkReportLogger;
import Reports.FrameworkReportManager;
import Reports.FrameworkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public final class LoginPage extends BasePage {
    private final By username_textbox = By.id("user-name");
    private final By password_txtbox = By.id("password");
    private final By login_btn = By.id("login-button");
    private final String loginid = "login-button";

    //    public LoginPage enterUsername()
//    {
//        enterText(username_textbox,"standard_user", WaitEnum.VISIBILITY);
//        return this;
//    }
//    public LoginPage enterPassword()
//    {
//        enterText(password_txtbox,"secret_sauce",WaitEnum.VISIBILITY);
//        return this;
//    }
    public LoginPage enterUsername(String username) {
        enterText(username_textbox, username, WaitEnum.VISIBILITY);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(password_txtbox, password, WaitEnum.VISIBILITY);
        return this;
    }

    public HomePage clickOnLoginBtn() {
        clickOnElement(login_btn, WaitEnum.CLICKABILITY, "Login Button");
        return new HomePage();
    }

    public String retrieveTitleFromUi() {
        return getTitle();
    }

    public String getLoginText() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        return (String) js.executeScript("return document.getElementById('" + loginid + "').value");
    }


}
