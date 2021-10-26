package example.window;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "newBrowserWindow")
    protected WebElement newBrowserWindow;

    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/a[contains(text(), 'Basic')]")
    protected WebElement basicButton;

    @FindBy(id = "newMessageWindow")
    private WebElement newMessageWindow;

    @FindBy(xpath = "//body")
    private WebElement bodyOfNewMessageWindow;
//    //body[contains(text(),'sharing')]

    @FindBy(id = "newBrowserTab")
    private WebElement newTabWindow;

    public WindowPage clickBrowserWindow() {
        newBrowserWindow.click();
        return this;
    }

    public WindowPage switchToNewWindow() {
        String winBefore = driver.getWindowHandle();

        clickBrowserWindow();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        actions.moveToElement(basicButton).build().perform();
        driver.close();

        driver.switchTo().window(winBefore);

        return this;
    }

//    zrobić coś  z drugim oknem ??

    public WindowPage clickNewMessageWindow() {
        newMessageWindow.click();
        return this;
    }

    public WindowPage switchToNewMessageWindow() {
        String winBefore = driver.getWindowHandle();

        clickNewMessageWindow();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        actions.moveToElement(bodyOfNewMessageWindow).build().perform();
        bodyOfNewMessageWindow.getAttribute("value");
//        jak pobrać tekst z okna ????????
        driver.close();

        driver.switchTo().window(winBefore);

        return this;
    }



    public WindowPage clickNewBrowserAndSwitchToNewTab() {
        newTabWindow.click();
        switchToByIndex(1);
        return this;
    }

    public WindowPage switchToByIndex(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }


    public WindowPage closeNewTabAndBackToHomePage() {
        driver.close();
        switchToByIndex(0);
        return this;
    }



}
