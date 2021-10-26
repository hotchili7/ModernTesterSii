package example.media_expert;

import example.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class RoweryMiejskiePage extends BasePage {
    public RoweryMiejskiePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//form[@name='paginate-form']/span[@class='is-next']/a[@data-event='LINK_CLICK']")
    protected List<WebElement> nextPageButton;

    @FindBy(xpath = "//div[@class='c-headline ']/p[contains(@class, 'is-tertiary') and normalize-space(text())='Rekomendacje klientów']")
    protected WebElement rekomendacjeKlientów;

    @FindBy(xpath = "//div[contains(@class, 'is-grid-col-1')]/div[@data-zone='OFFERBOX']")
    protected List<WebElement> productContainers;




    public RoweryMiejskiePage clickNextPageButton() {
        while  (nextPageButton.size() > 0) {
            getListOfBikes();
            nextPageButton.get(1).click();
        }
        return this;
    }




    public RoweryMiejskiePage moveToElementOnPage() {
        moveToElement(rekomendacjeKlientów);
        return this;
    }

    public List<RowerMiejski> getListOfBikes() {
        List<RowerMiejski> bikes = new ArrayList<>();
        waitForPageToBeLoaded();
        for (WebElement productContainer : productContainers) {
            bikes.add(new RowerMiejski(productContainer));
        }
        return bikes;
    }

    // znaleźć inny xpath na który będziemy czekać

   // public RoweryMiejskiePage clickNextPageButton1() {
   //     waitForVisibility(rekomendacjeKlientów);
   //     if (nextPageButton.size() > 0) {
   //         wait.until(ExpectedConditions.elementToBeClickable(rekomendacjeKlientów)).click();
  //      }
  //  }








}
