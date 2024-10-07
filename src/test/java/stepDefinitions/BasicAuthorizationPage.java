package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.AssertJUnit.assertTrue;

public class BasicAuthorizationPage {
    final TestBase testBase;
    private Properties prop;

    public BasicAuthorizationPage(TestBase testBase) {
        this.testBase = testBase;
    }

    public void loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        prop.load(fis);
    }

    @Given("User navigates to the Basic Auth page with valid credentials")
    public void user_navigates_to_the_basic_auth_page() throws IOException {
        loadProperties();
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        testBase.driver.get(url);
    }

    @Then("User should see a confirmation message")
    public void user_should_see_a_confirmation_message() {
        String pageSource = testBase.driver.getPageSource();
        assert pageSource != null;
        assertTrue("Login failed or confirmation message not found", pageSource.contains("Congratulations! You must have the proper credentials."));
    }
}

