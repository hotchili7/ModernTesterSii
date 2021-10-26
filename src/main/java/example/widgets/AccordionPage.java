package example.widgets;

import example.BasePage;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class AccordionPage extends BasePage {
    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    public static final String ELEMENT_ON_INDEX_XPATH = "//div[@class='content ']/div/h3[text()='Section %s']";

    public static final String TEXT_FROM_SECTION_ON_INDEX_XPATH = "//h3[text()='Section %s' and contains(@class,'ui-accordion-header-active')]//following-sibling::div[contains(@class, 'ui-accordion-content-active')]/p";



    @FindBy(xpath = "//div[@id='accordion' and ./ h3[text()='Section 3']]/div[contains(@class, 'ui-accordion-content-active')]/ul/li")
    protected List<String> thridElementsList;

    @FindBy(xpath = "//h3[text()='Section %s' and contains(@class,'ui-accordion-header-active')]//following-sibling::div[contains(@class, 'ui-accordion-content-active')]/p")
    protected List<String> listOfPFrom4Section;

    public AccordionPage clickOnElementOnIndex(String index) {
        driver.findElement(By.xpath(String.format(ELEMENT_ON_INDEX_XPATH, index))).click();
        return this;
    }


    public String getTextFromSectionOnIndex(String index) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath(String.format(TEXT_FROM_SECTION_ON_INDEX_XPATH, index))).getText();

    }

 //   public List<String> getItemsFromThridSection() {
  //      List<String> items = new ArrayList<>();
  //      for (String s : thridElementsList) {
  //          items.add(s.getText());
  //      }
  //      return items;
  //  }


    public String getTextFromFourthSection(String index) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath(String.format(TEXT_FROM_SECTION_ON_INDEX_XPATH, index))).getText();
    }

    // ----------- ASSERT J ------------

    public AccordionPage verifyTextInGivenSection(String index, String text) {
        log.info("Verify text from {} section", index);
        assertThat(getTextFromSectionOnIndex(index).equals(text)).isTrue();
        return this;
    }


}
