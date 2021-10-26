package example.interactions;

import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "draggable")
    protected WebElement drag;

    @FindBy(id = "droppable")
    protected WebElement drop;

    @FindBy(xpath = "//div[@id='droppable']/p")
    protected WebElement droppedMessage;

    public DroppablePage dragElementAndDrop() {
        actions.dragAndDrop(drag, drop).build().perform();
        return this;
    }

    public String getTextFromDroppedMessage() {
        wait.until(ExpectedConditions.visibilityOf(droppedMessage));
        return droppedMessage.getText();
    }

}
