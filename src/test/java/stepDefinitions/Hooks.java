package stepDefinitions;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestBase;

import java.io.File;
import java.io.IOException;


public class Hooks {

    TestBase testBase;

    public Hooks(TestBase testBase) {
        this.testBase = testBase;
    }

    @Before
    public void setUp() throws Exception {
        testBase.WebDriverManager();
    }

    @After
    public void tearDown() {
        testBase.tearDown();
    }

    @AfterStep
    public void addScreenShot(Scenario scenario) throws IOException {
        WebDriver driver = testBase.WebDriverManager();
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image/png");
        }
    }
}



