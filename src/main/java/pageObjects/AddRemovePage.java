package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {
    final WebDriver driver;
    @FindBy(css = "a[href='/add_remove_elements/']")
    private WebElement addRemoveLink;
    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;
    @FindBy(className = "added-manually")
    private WebElement deleteButton;

    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddRemoveLink() {
        addRemoveLink.click();
    }

    public void clickAddElementButton() {
        addElementButton.click();
    }

    public boolean isDeleteButtonDisplayed() {
        return deleteButton.isDisplayed();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public boolean isDeleteButtonAbsent() {
        return driver.findElements(By.className("added-manually")).isEmpty();
    }
}

