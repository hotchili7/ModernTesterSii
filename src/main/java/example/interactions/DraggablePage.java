package example.interactions;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends BasePage {
    public DraggablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    protected WebElement drag;


    public DraggablePage moveElement(int x, int y) {
        actions.dragAndDropBy(drag, x, y).build().perform();
        return this;
    }

}
