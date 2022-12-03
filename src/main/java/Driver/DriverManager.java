package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

public final class DriverManager {
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver()
    {
      return driver.get();
    }

    public static void setDriver()
    {
        if(Objects.nonNull(driver)) {
            driver.set(WebDriverManager.chromedriver().create());
        }

    }

    public static void unload()
    {
       driver.remove();
    }
}
