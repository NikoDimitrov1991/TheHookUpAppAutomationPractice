package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddRemoveSteps {
    TestBase testBase;


    public AddRemoveSteps(TestBase testBase) {
        this.testBase = testBase;
    }

    @Given("User goes to AddRemove Elements page")
    public void user_goes_to_addRemove_elements_page() {
        this.testBase.driver.findElement(By.cssSelector("a[href='/add_remove_elements/']")).click();
        String currentUrl = testBase.driver.getCurrentUrl();
        assertEquals("URL does not match", "https://the-internet.herokuapp.com/add_removeelements/", currentUrl);
    }

    @When("user clicks on the Add Element button")
    public void user_clicks_on_the_add_element_button() {
        WebElement addElementButton = testBase.driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
    }

    @Then("a Delete button appears")
    public void a_delete_button_appears() {
        List<WebElement> deleteButtons = testBase.driver.findElements(By.className("added-manually"));
        assertTrue("Delete button is not displayed", deleteButtons.size() > 0);
    }

    @When("user clicks on the Delete button")
    public void user_clicks_on_the_delete_button() {
        WebElement deleteButton = testBase.driver.findElement(By.className("added-manually"));
        deleteButton.click();
    }

    @Then("the Delete button should disappear")
    public void the_delete_button_should_disappear() {
        List<WebElement> deleteButtons = testBase.driver.findElements(By.className("added-manually"));
        assertEquals("Delete button did not disappear", 0, deleteButtons.size());
    }
}
