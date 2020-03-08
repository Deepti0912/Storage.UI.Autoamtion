package homePage;

import basePage.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.Random;

public class HomePage extends BasePage {

    private final String LOGIN_PAGE_TITLE = "All Files | Powered by Box";
    private final String UPLOAD_FILE_PATH = "C:\\temp\\test.png";

    private Logger log;
    public HomePage(){
        PageFactory.initElements(driver, this);
        log = Logger.getLogger("HomePage");
    }

    @FindBy(xpath = "//*[text()='New']")
    @CacheLookup
    WebElement new_Menu;

    @FindBy(xpath = "//*[text()='Folder']")
    @CacheLookup
    WebElement new_Folder;

    //create folder pop up box
    @FindBy(xpath = "//input[@name='folder-name']")
    @CacheLookup
    WebElement newFolder_input;

    @FindBy(xpath = "//*[text()='Create']")
    @CacheLookup
    WebElement newFolder_CreateButton;

    @FindBy(xpath = "//div[@data-item-index='0']")
    @CacheLookup
    WebElement folderName_Icon;

    @FindBy(xpath = "//*[text()='Upload']")
    @CacheLookup
    WebElement upload_Btn;

    @FindBy(xpath = "//*[text()='File']")
    @CacheLookup
    WebElement file_Menu;

    public void checkValidLogin(){
        String expectedHomePageTitle = driver.getTitle();
        Assert.assertEquals(expectedHomePageTitle,LOGIN_PAGE_TITLE);
    }

    public String createNewFolder()  {
        new_Menu.click();

        wait.forElementToBeDisplayed(10, new_Folder, "new_Folder");
        new_Folder.click();

        Random objGenerator = new Random();
        int randomNumber = objGenerator.nextInt(100);
        String folderName = "Test" + Integer.toString(randomNumber);
        newFolder_input.sendKeys(folderName);

        newFolder_CreateButton.click();

        return folderName;
    }

    public void verifyNewFolderCreated(String folderName){
        try {
            driver.findElements(By.xpath("//*[@title='" + folderName + "']"));
        }
        catch (NoSuchElementException e)
        {
            log.error("Unable to create new folder " + folderName);
        }
    }

    public void uploadFile() throws AWTException {
        Actions actions = new Actions(driver);
        actions.doubleClick(folderName_Icon).perform();

        upload_Btn.click();
        file_Menu.click();

        Robot robot = new Robot();
        robot.setAutoDelay(2000);
        StringSelection file = new StringSelection(UPLOAD_FILE_PATH);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file,null);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
