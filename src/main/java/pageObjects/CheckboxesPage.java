package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class CheckboxesPage {
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement checkbox1;
    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement checkbox2;
    @FindBy(css = "   a[href='/checkboxes']")
    public WebElement checkboxes_page;




    public CheckboxesPage(TestBase testBase) {
        PageFactory.initElements(testBase.driver, this);
    }
}

