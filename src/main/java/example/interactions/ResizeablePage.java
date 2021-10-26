package example.interactions;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizeablePage extends BasePage {
    public ResizeablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='resizable']/div[contains(@class, 'ui-icon')]")
    protected WebElement resizeHandle;

    public ResizeablePage resizeElementBy(int x, int y) {
        actions.dragAndDropBy(resizeHandle, x, y).build().perform();
        return this;
    }

//    sprawdź czy resize element jest ok - nie działa

    public int getCoordX() {
        return resizeHandle.getLocation().getX();
    }

    public int getCoordY() {
        return resizeHandle.getLocation().getY();
    }


}
