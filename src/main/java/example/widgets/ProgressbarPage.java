package example.widgets;

import example.BasePage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressbarPage extends BasePage {
    public ProgressbarPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@id='progressbar']/div[text()='Complete!']")
    protected WebElement completeLabel;

    public ProgressbarPage verifyThatProgressBarIsCompleted() {
        waitForVisibility(completeLabel);
        Assertions.assertThat(completeLabel.isDisplayed()).isTrue();
        return this;
    }
}
