package Pages;

import Enums.WaitEnum;
import Reports.FrameworkReportLogger;
import Reports.FrameworkReportManager;
import Reports.FrameworkReporter;
import org.openqa.selenium.By;

import static Utils.DynamicXpathUtil.getFormattedElement;

public final class YourCartPage extends BasePage {

    private final String removeBtn = "//button[text()='Remove'][%s]";
    private final By cartBadge = By.className("shopping_cart_badge");
    private final String addedProductList = "//div[contains(@class,'inventory_item_name')][%s]";
    private final By continueShoppingBtn = By.id("continue-shopping");

    public YourCartPage clickOnRemoveButtonOnCartPage(String removeBtnNum) {
        clickOnElement(By.xpath(getFormattedElement(removeBtn, removeBtnNum)), WaitEnum.CLICKABILITY,"Remove Button On Cart Page");
        return this;
    }

    public String getCartAmount() {
        return getVisibleTextFromUi(cartBadge, WaitEnum.VISIBILITY);
    }

    public String getFirstProductNameFromCartPage() {
        String firstProd = getFormattedElement(addedProductList, "1");
        return getVisibleTextFromUi(By.xpath(firstProd), WaitEnum.VISIBILITY);
    }

    public HomePage clickOnContinueShopping() {
        clickOnElement(continueShoppingBtn, WaitEnum.CLICKABILITY,"Continue Shopping Button");
        return new HomePage();
    }
}
