package example;

import example.media_expert.RoweryMiejskiePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @FindBy(xpath = "//div[contains(@class, 'is-cookies')]/div[@data-component='cookieContent']/a[@data-settings-link='.is-cookies .c-alert_close']")
    protected WebElement cookiesCloseButton;

    @FindBy(xpath = "//div[contains(@class, 'is-cookies')]")
    protected List<WebElement> cookiesContainers;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void moveToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(String elementXPath) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXPath))));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForClickable(String elementXPath) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elementXPath))));
    }

    public void waitForVisibilityOrClickable(WebElement element) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForVisibilityOrClickable(String elementXPath) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXPath))),
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elementXPath)))
        ));
    }


    public void closeCookies() {
        waitForClickable(cookiesCloseButton);
        if (cookiesContainers.size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(cookiesCloseButton)).click();
        }
    }


    public void waitForPageToBeLoaded() {
        wait.until(webDriver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete"));
    }





}
