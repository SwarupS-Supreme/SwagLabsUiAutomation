package com.qa.tests;

import Annotation.FrameworkAnnotation;
import Enums.TestCategoryEnum;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.YourCartPage;
import Reports.FrameworkReporter;
import Utils.DataRetriever;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class CartTest extends BaseTest {

    private CartTest() {

    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class)
    public void verifyRemoveButtonIsWorking(Map<String,String> map) {
        String firstRemoveButton = "1";
        String updatedAmount = new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).
                clickOnLoginBtn().
                clickOnAddToCartIcon("1").clickOnAddToCartIcon("2").
                clickOnCartIcon().clickOnRemoveButtonOnCartPage(firstRemoveButton).getCartAmount();
        assertThat(Integer.parseInt(updatedAmount)).isEqualTo(1);
    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.REGRESSION})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class)
    public void verifyAddedProdIsAvailable(Map<String,String> map) {
        String firstProdName = new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password")).
                clickOnLoginBtn().
                clickOnAddToCartIcon("1").getFirstProductNameFromCartPage();
        String prodNameCartPg = new HomePage().clickOnCartIcon().getFirstProductNameFromCartPage();
        assertThat(firstProdName).isEqualTo(prodNameCartPg);
    }
}
