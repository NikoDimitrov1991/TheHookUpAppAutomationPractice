package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemovePage {
    final WebDriver driver;
    // Locators
    final By addElementButton = By.xpath("//button[text()='Add Element']");
    final By deleteButton = By.className("added-manually");
    final By addRemoveLink = By.cssSelector("a[href='/add_remove_elements/']");

    // Constructor to initialize WebDriver
    public AddRemovePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddRemoveLink() {
        driver.findElement(addRemoveLink).click();
    }

    public void clickAddElementButton() {
        driver.findElement(addElementButton).click();
    }

    public boolean isDeleteButtonDisplayed() {
        return !driver.findElements(deleteButton).isEmpty();
    }

    public void clickDeleteButton() {
        if (isDeleteButtonDisplayed()) {
            driver.findElement(deleteButton).click();
        }
    }

    public boolean isDeleteButtonAbsent() {
        return driver.findElements(deleteButton).isEmpty();
    }
}

