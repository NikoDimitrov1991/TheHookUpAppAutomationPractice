package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddRemovePage;
import utils.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddRemoveSteps {
    final TestBase testBase;
    final AddRemovePage addRemovePage;


    public AddRemoveSteps(TestBase testBase) {
        this.testBase = testBase;
        this.addRemovePage = new AddRemovePage(testBase.driver);
    }

    @Given("User goes to AddRemove Elements page")
    public void user_goes_to_addRemove_elements_page() {
        addRemovePage.clickAddRemoveLink();
        String currentUrl = testBase.driver.getCurrentUrl();
        assertEquals("URL does not match", "https://the-internet.herokuapp.com/add_remove_elements/", currentUrl);
    }

    @When("user clicks on the Add Element button")
    public void user_clicks_on_the_add_element_button() {
        addRemovePage.clickAddElementButton();
    }

    @Then("a Delete button appears")
    public void a_delete_button_appears() {
        assertTrue("Delete button is not displayed", addRemovePage.isDeleteButtonDisplayed());
    }

    @When("user clicks on the Delete button")
    public void user_clicks_on_the_delete_button() {
        addRemovePage.clickDeleteButton();
    }

    @Then("the Delete button should disappear")
    public void the_delete_button_should_disappear() {
        assertTrue("Delete button did not disappear", addRemovePage.isDeleteButtonAbsent());
    }
}
