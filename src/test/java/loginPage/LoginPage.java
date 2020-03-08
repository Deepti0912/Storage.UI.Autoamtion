package loginPage;

import basePage.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private final String LOGIN_PAGE_URL = "https://account.box.com/login";
    private final String LOGIN_PAGE_TITLE = "Box | Login";
    Logger log;

    public LoginPage() {
        PageFactory.initElements(driver, this);
        log = Logger.getLogger("LoginPage");
    }

    @FindBy(xpath = "//input[@id='login-email']")
    @CacheLookup
    WebElement username_field;

    @FindBy(xpath = "//*[@id='login-submit']")
    @CacheLookup
    WebElement username_nextButton;

    @FindBy(xpath = "//input[@id='password-login']")
    @CacheLookup
    WebElement password_field;

    @FindBy(xpath = "//button[@id='login-submit-password']")
    @CacheLookup
    WebElement login_button;

    @FindBy(xpath = "//div[@class='form-error']")
    @CacheLookup
    WebElement invalidLogin_msg;

    public void goToLoginPage()
    {
        driver.get(LOGIN_PAGE_URL);
        wait.forLoading(5);

        String expectedLoginPageTitle = driver.getTitle();
        Assert.assertEquals(expectedLoginPageTitle,LOGIN_PAGE_TITLE);
    }

    public void setUsername(String username){
        username_field.clear();
        username_field.sendKeys(username);
        username_nextButton.click();
    }

    public void setPwd(String pwd){
        password_field.clear();
        password_field.sendKeys(pwd);
    }

    public void clickLogin()
    {
        login_button.click();
    }

    public void checkInvalidUser() {
        try {
            if (invalidLogin_msg.isDisplayed()) {
                Assert.assertTrue(invalidLogin_msg.isDisplayed());
            }
            else {
                log.error("User with invalid details could not be validated properly");
            }
        } catch (NoSuchElementException e) {
            log.error("User with invalid details could not be validated properly");
        }
    }
}
