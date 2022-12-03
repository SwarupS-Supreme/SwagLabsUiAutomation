package Driver;

import Enums.PropertyEnum;
import Utils.PropertyUtils;

import java.util.Locale;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        DriverManager.setDriver();
//        DriverManager.getDriver().get(PropertyUtils.get("url"));
        DriverManager.getDriver().get(PropertyUtils.get(PropertyEnum.URL.toString().toLowerCase()));
        DriverManager.getDriver().manage().window().maximize();

    }

    public static void closeDriver() {
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}
