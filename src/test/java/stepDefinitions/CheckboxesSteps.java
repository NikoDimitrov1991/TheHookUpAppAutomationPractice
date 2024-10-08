package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckboxesPage;
import utils.TestBase;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckboxesSteps {
    final TestBase testBase;
    final CheckboxesPage checkboxesPage;

    public CheckboxesSteps(TestBase testBase) {
        this.testBase = testBase;
        this.checkboxesPage = new CheckboxesPage(testBase);
    }

    @Given("User navigates to the Checkboxes page")
    public void userNavigatesToTheCheckboxesPage() {
        checkboxesPage.checkboxes_page.click();
    }

    @When("User verifies the initial status of the checkboxes")
    public void user_verifies_the_initial_status_of_the_checkboxes() {
        boolean isCheckbox1Selected = checkboxesPage.checkbox1.isSelected();
        boolean isCheckbox2Selected = checkboxesPage.checkbox2.isSelected();

        // Providing more user-friendly feedback
        if (isCheckbox1Selected) {
            System.out.println("Checkbox1 is selected");
        } else {
            System.out.println("Checkbox1 is not selected");
        }

        if (isCheckbox2Selected) {
            System.out.println("Checkbox2 is selected");
        } else {
            System.out.println("Checkbox2 is not selected");
        }
    }

    @Then("User selects the first checkbox if not already selected")
    public void user_selects_the_first_checkbox_if_not_already_selected() {
        if (!checkboxesPage.checkbox1.isSelected()) {
            checkboxesPage.checkbox1.click();
            assertTrue("Checkbox 1 was not selected after clicking", checkboxesPage.checkbox1.isSelected());
        }
    }

    @Then("User unselects the second checkbox if already selected")
    public void user_unselects_the_second_checkbox_if_already_selected() {
        if (checkboxesPage.checkbox2.isSelected()) {
            checkboxesPage.checkbox2.click();
            assertFalse("Checkbox 2 was not unselected after clicking", checkboxesPage.checkbox2.isSelected());
        }
    }


}
