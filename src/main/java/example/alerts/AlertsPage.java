package example.alerts;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(id = "simple-alert-label")
    private WebElement simpleAlertLabel;

    @FindBy(id = "prompt-alert")
    private WebElement promptAlertButton;

    @FindBy(id = "prompt-label")
    private WebElement promptLabel;

    @FindBy(id = "confirm-alert")
    private WebElement confirmAlertButton;

    @FindBy(id = "confirm-label")
    private WebElement confirmLabel;

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedLabel;


    public void clickSimpleAlertButtonAndAcceptAlert() {
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
    }

    public String getTextFromSimpleAlertLabel() {
        return simpleAlertLabel.getText();
    }

    public void clickPromptPopupAlertAndAcceptAlert(String text) {
        promptAlertButton.click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public String getTextFromPromptLabel() {
        return promptLabel.getText();
    }

    public void clickPromptPopupAlertAndCancel() {
        promptAlertButton.click();
        driver.switchTo().alert().dismiss();
    }

    public void clickAndConfirmPopupAndAcceptAlert() {
        confirmAlertButton.click();
        driver.switchTo().alert().accept();
    }

    public void clickAndConfirmPopupAndCancelAlert() {
        confirmAlertButton.click();
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromConfirmAlert() {
        return confirmLabel.getText();

    }

    public void  clickDelayedAlertButton() {
        delayedAlertButton.click();
    }

    public void waitAndAcceptDelayedAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getTextFromDelayedAlertLabel() {
        return delayedLabel.getText();
    }

    public String getTextFromDelayedAlert() {
    wait.until(ExpectedConditions.alertIsPresent());
    return driver.switchTo().alert().getText();
    }

    public String getNameFromConfirmButton() {
        return confirmAlertButton.getText();
    }
}
