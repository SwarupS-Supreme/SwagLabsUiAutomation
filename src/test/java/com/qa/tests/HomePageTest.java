package com.qa.tests;

import Annotation.FrameworkAnnotation;
import Enums.TestCategoryEnum;
import Pages.HomePage;
import Pages.LoginPage;
import Reports.FrameworkReporter;
import Utils.DataRetriever;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public final class HomePageTest extends BaseTest {

    private HomePageTest()
    {

    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class)
    public void verifyCartBadgeHasOneProduct(Map<String,String> map)
    {
        new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).
                clickOnLoginBtn().clickOnAddToCartIcon("1");
        String cartAmount = new HomePage().getItemsAddedAmount();
        assertThat(cartAmount).isEqualTo("1");
    }
    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class)
    public void verifyCartAmountIncreasedAfterAddingAnotherItem(Map<String,String> map)
    {
        String oldAmount=new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).
                clickOnLoginBtn().clickOnAddToCartIcon("1").getItemsAddedAmount();
        String updatedAmount = new HomePage().clickOnLastAddToCartIcon().getItemsAddedAmount();
        assertThat(Integer.parseInt(updatedAmount)).isEqualTo(Integer.parseInt(oldAmount)+1);
    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class)
    public void verifyPriceSortedFromLowToHigh(Map<String,String> map)
    {
        Boolean flag=new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).
                clickOnLoginBtn().clickOnLowToHighPrice().checkIfSortWorks();
        assertThat(flag).isTrue();
    }
}
