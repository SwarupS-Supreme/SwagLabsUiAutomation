package com.qa.tests;

import Annotation.FrameworkAnnotation;
import Enums.TestCategoryEnum;
import Pages.LoginPage;
import Utils.DataRetriever;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest() {
    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.SMOKE})
    @Test
    public void verifyTitle() {
        assertThat(new LoginPage().retrieveTitleFromUi()).isEqualTo("Swag Labs");

    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.SANITY})
    @Test
    public void verifyLoginTextIsCapitalized() {
        assertThat(new LoginPage().getLoginText()).isEqualTo("Login");

    }

//    @Test
//    public void verifyDefaultDropdownIsAZ() {
//        String dropdownText = new LoginPage().enterUsername().enterPassword()
//                .clickOnLoginBtn().getDefaultDropdownText();
//        assertThat(dropdownText).isEqualTo("NAME (A TO Z)");
//    }

    @FrameworkAnnotation(authors = {"Swarup"}, testCategory = {TestCategoryEnum.SANITY})
    @Test(dataProvider = "getData",dataProviderClass = DataRetriever.class )
    public void verifyDefaultDropdownIsAZ(Map<String,String> map) {
        System.out.print("Map data =  "+map);
        String dropdownText = new LoginPage().enterUsername(map.get("Username")).enterPassword(map.get("Password"))
                .clickOnLoginBtn().getDefaultDropdownText();
        assertThat(dropdownText).isEqualTo("NAME (A TO Z)");
    }


}
