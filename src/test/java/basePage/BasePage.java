package basePage;

import driverSetup.Setup;
import driverSetup.Wait;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    protected Wait wait;

    public BasePage()
    {
        driver = Setup.driver;
        wait = new Wait(driver);
    }
}

