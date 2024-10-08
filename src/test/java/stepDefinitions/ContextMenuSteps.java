package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import pageObjects.ContextMenuPage;
import utils.TestBase;

import static org.testng.AssertJUnit.assertEquals;

public class ContextMenuSteps {
    final TestBase testBase;
    final ContextMenuPage contextMenuPage;

    public ContextMenuSteps(TestBase testBase) {
        this.testBase = testBase;
        this.contextMenuPage = new ContextMenuPage(testBase);
    }

    @Given("User navigates to the Context Menu page")
    public void user_navigates_to_the_context_menu_page() {
        contextMenuPage.context_menu.click();
    }

    @When("User right-clicks on the box")
    public void user_right_clicks_on_the_box() {
        Actions actions = new Actions(testBase.driver);
        actions.contextClick(contextMenuPage.contextBox).perform();
    }

    @Then("A JavaScript alert should appear with the message {string}")
    public void a_javascript_alert_should_appear_a_proper_message(String expectedMessage) {
        Alert alert = testBase.driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        assertEquals("Alert message is incorrect", expectedMessage, actualAlertMessage);
        alert.accept();
    }


}
