package loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    private LoginPage loginPage;
    public LoginPageSteps()
    {
        this.loginPage = new LoginPage();
    }

    @Given("User navigates to the Box website")
    public void user_navigates_to_the_Box_website() {
        loginPage.goToLoginPage();
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPwd(password);
        loginPage.clickLogin();
    }

    @Then("User logs is unable to login to the site")
    public void user_logs_is_unable_to_login_to_the_site() {
        loginPage.checkInvalidUser();
    }
}
