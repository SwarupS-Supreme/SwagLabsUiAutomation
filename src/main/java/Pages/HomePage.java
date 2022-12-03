package Pages;

import Enums.WaitEnum;
import Reports.FrameworkReportLogger;
import Utils.DynamicXpathUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Utils.DynamicXpathUtil.getFormattedElement;

public final class HomePage extends BasePage {

    private final By default_drpdwn = By.className("active_option");
    private final By productDrpDwn = By.xpath("//select");
    private final By add_to_cart_btn_list = By.xpath("//div[contains(@class,'inventory_list')]//button");
    private final By cart_btn = By.id("shopping_cart_container");
    private final By item_added_num = By.className("shopping_cart_badge");
    private final String add_to_cart_btn_list_dummy = "(//div[contains(@class,'inventory_list')]//button)[%s]";
    private final String productList = "//div[contains(@class,'inventory_item_name')][%s]";
    private final By inventoryItemPriceList = By.xpath("//div[@class='inventory_item_price']");

    public String getDefaultDropdownText() {
        return getVisibleTextFromUi(default_drpdwn, WaitEnum.VISIBILITY);
    }

    public HomePage clickOnAddToCartIcon(String addBtnNum) {
        String loc = DynamicXpathUtil.getAddToCartButtonWebElem(add_to_cart_btn_list_dummy, addBtnNum);
        By addToCartBtn = By.xpath(loc);
        clickOnElement(addToCartBtn, WaitEnum.CLICKABILITY,"Add To Cart Icon Button");
        scrollToTopOfPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomePage clickOnLastAddToCartIcon() {
        String loc = DynamicXpathUtil.getAddToCartButtonWebElem(add_to_cart_btn_list_dummy, String.valueOf(getListOfWebElement(add_to_cart_btn_list).size()));
        By addToCartBtn = By.xpath(loc);
        scrollToBottomOfPage();
        clickOnElement(addToCartBtn, WaitEnum.CLICKABILITY,"Last Add To Cart Icon");
        scrollToTopOfPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getItemsAddedAmount() {
        return getVisibleTextFromUi(item_added_num, WaitEnum.VISIBILITY);
    }

    public YourCartPage clickOnCartIcon() {
        clickOnElement(cart_btn, WaitEnum.CLICKABILITY,"Cart Icon Button");
        return new YourCartPage();
    }

    public String getFirstProductNameFromCartPage() {
        String firstProd = getFormattedElement(productList, "1");
        return getVisibleTextFromUi(By.xpath(firstProd), WaitEnum.VISIBILITY);
    }

    public HomePage clickOnLowToHighPrice() {
        selectByVisibleTextFromDropdown(productDrpDwn, "Price (low to high)");
        return this;
    }

    public boolean checkIfSortWorks() {
        List<WebElement> list=getListOfWebElement(inventoryItemPriceList);
        String text[] = {};
        String newArr[]={};
        String temp[]={};
        ArrayList<String> listOfPrice = new ArrayList<>(Arrays.asList(text));
        for (WebElement element : list) {
            listOfPrice.add(element.getText());
        }
        Arrays.toString(newArr);
        temp=newArr;
        Arrays.sort(temp);
        if(Arrays.equals(temp,newArr))
        {
            return true;
        }
       else
        {
            return false;
        }
    }
}
