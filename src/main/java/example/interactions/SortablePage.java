package example.interactions;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortablePage extends BasePage {
    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public static final String ELEMENT_ON_INDEX_XPATH = "//div[@class='content ']/ul/li[text()='Item %s']";

    public SortablePage clickOnElementOnIndexAndMove(String from, String to) {
        waitForPageToBeLoaded();
        driver.findElement(By.xpath(String.format(ELEMENT_ON_INDEX_XPATH, from))).click();
        actions.clickAndHold(driver.findElement(By.xpath(String.format(ELEMENT_ON_INDEX_XPATH, from)))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath(String.format(ELEMENT_ON_INDEX_XPATH, to)))).build().perform();
        actions.release(driver.findElement(By.xpath(String.format(ELEMENT_ON_INDEX_XPATH, from)))).build().perform();



        return this;
    }




}
