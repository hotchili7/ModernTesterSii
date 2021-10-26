package example.interactions;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class SelectablePage extends BasePage {
    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@id='feedback']/span[@id='select-result']")
    protected WebElement result;


    public static final String ROW_NUMBER = "//ol[@id='selectable']/li[text()='Item %s']";

    public SelectablePage selectRowByNumber(String number) {
        driver.findElement(By.xpath(String.format(ROW_NUMBER, number))).click();
        return this;
    }

//    SPRAWDZIĆ KOLOR ZAZNACZEONEGO ELEMENTU


    public String getTextFromResult() {
        return result.getText().replace("#", "");
    }


    public SelectablePage selectMultiple(List<String> numbers) {
        for (String number : numbers) {
            actions.keyDown(Keys.LEFT_CONTROL).build().perform();
            driver.findElement(By.xpath(String.format(ROW_NUMBER, number))).click();

        }
        return this;
    }


    public List<String> getNumbersFromString(String str) {
        return Arrays.asList(str.split(" "));
    }

}
