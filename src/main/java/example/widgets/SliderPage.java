package example.widgets;

import example.BasePage;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.*;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy (xpath = "//div[@id='slider']/div[@id='custom-handle']")
    protected WebElement slider;

    public int getCurrentPosition() {
        return Integer.parseInt(slider.getText());
    }

    public SliderPage moveToPosition(int expectedPosition) {
        int currentPosition = getCurrentPosition();
        int positionDifference = currentPosition - expectedPosition;

        while (getCurrentPosition() != expectedPosition) {
            if (positionDifference > 0) {
                for (int i = 0; i < positionDifference; i++) {
                    slider.click();
                    actions.sendKeys(Keys.ARROW_LEFT).click().build().perform();
                }
            } else if (positionDifference < 0 ) {
                for (int i = 0; i < positionDifference * (-1); i++) {
                    slider.click();
                    actions.sendKeys(Keys.ARROW_RIGHT).click().build().perform();

                }
        }
        }
        return this;
    }


    public SliderPage verifyThat (int expectedPosition) {
        moveToPosition(expectedPosition);

        assertThat(getCurrentPosition() == expectedPosition).isTrue();
        return this;
    }


}
