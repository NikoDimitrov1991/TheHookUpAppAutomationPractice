package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class ContextMenuPage {
    @FindBy(css = "a[href='/context_menu']")
    public WebElement context_menu;
    @FindBy(id = "hot-spot")
    public WebElement contextBox;

    public ContextMenuPage(TestBase testBase) {
        PageFactory.initElements(testBase.driver, this);
    }
}
