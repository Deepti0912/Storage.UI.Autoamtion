package homePage;

import io.cucumber.java.en.Then;

import java.awt.*;

public class HomePageSteps {

    private HomePage homePage;
    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Then("User logs in successfully to the site")
    public void user_logs_in_successfully_to_the_site() {
        homePage.checkValidLogin();
    }

    @Then("User is able to create a new folder")
    public void user_is_able_to_create_a_new_folder() {
        String folderName = homePage.createNewFolder();
        homePage.verifyNewFolderCreated(folderName);
    }

    @Then("User is able to upload a file in the folder")
    public void user_is_able_to_upload_a_file_in_the_folder() throws AWTException {
        homePage.uploadFile();
    }

}
