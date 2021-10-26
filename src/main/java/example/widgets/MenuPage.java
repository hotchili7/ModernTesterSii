package example.widgets;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//ul[@id='menu']/li[not(contains(@class, 'ui-state-disabled'))]/div")
    protected List<WebElement> activeCategories;

    @FindBy(xpath = "//ul[@id='menu']/li/div")
    protected List<WebElement> allCategoriesMenu;

    public static final String CATEGORY_WITH_DROPDOWN_XPATH = "//ul[@id='menu']/li[./div[text()='%s']]";
    public static final String SUBCATEGORY_DROPDOWN_XPATH = CATEGORY_WITH_DROPDOWN_XPATH + "/ul/li/div";
    public static final String SUB_SUBCATEGORY_DROPDOWN_XPATH = CATEGORY_WITH_DROPDOWN_XPATH + "/ul/li/ul/li";




    public List<String> getActiveCategories() {
        return activeCategories.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public List<String> getAllCAtegories() {
       return allCategoriesMenu.stream().map(element -> element.getText()).collect(Collectors.toList());
    }


    public MenuPage openCategoryDropdown(String categoryName) {
        actions.moveToElement(driver.findElement(By.xpath(String.format(CATEGORY_WITH_DROPDOWN_XPATH,categoryName))))
                .build().perform();
        return this;
    }

    public List<String> getSubcategoryNames(String categoryName) {
//        waitForVisibility("//ul[@id='menu']/li[./div[text()='Electronics']]/ul");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(By.xpath(String.format(SUBCATEGORY_DROPDOWN_XPATH, categoryName))).stream()
                .map(element -> element.getText()).collect(Collectors.toList());
    }


//    public List<String> getSubSubCatogoeryNames(){
//        return driver;
//    }



}
