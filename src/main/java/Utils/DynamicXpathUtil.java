package Utils;

import Pages.BasePage;

public final class DynamicXpathUtil extends BasePage{
    private DynamicXpathUtil()
    {

    }
    public static String getAddToCartButtonWebElem(String locator, String value)
    {
        return String.format(locator,value);
    }
    public static String getFormattedElement(String locator, String value)
    {
        return String.format(locator,value);
    }
}
