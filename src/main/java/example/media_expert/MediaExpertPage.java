package example.media_expert;

import example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MediaExpertPage extends BasePage {
    public MediaExpertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'c-menu') and ./p[@class='c-menu_title']]/ul/li")
    protected List<WebElement> elementsOfCarousel;

    @FindBy(xpath = "//div[contains(@class, 'is-cookies')]/div[@data-component='cookieContent']/a[@data-settings-link='.is-cookies .c-alert_close']")
    protected WebElement cookiesCloseButton;

    @FindBy(xpath = "//div[contains(@class, 'is-cookies')]")
    protected List<WebElement> cookiesContainers;

//    xpath
//    //ul[contains(@class,'is-list0') and contains(@data-component, 'carousel')]/li
//    //div[contains(@class, 'c-menu') and ./p[@class='c-menu_title']]/ul/li/a

//    ./

//    //li[@data-component='emitCustomEvent']/div[contains(@class, 'is-level1') and ./p[normalize-space(text())='Telewizory i RTV']]

//    wszystkie oprócz jednego -LEGO
    //ul[@data-zone='MAINMENU']/li[@data-component='emitCustomEvent']/a[not(contains(@data-event-action, 'LEGO'))]

//    kafelki z nazwami ropoczynającymi sie na "A"

    //ul[@data-zone='MAINMENU']/li[@data-component='emitCustomEvent']/a[starts-with(@data-event-action, 'A')]
    @FindBy(xpath = "//ul[@data-zone='MAINMENU']/li[@data-component='emitCustomEvent']/a[@data-event-action='Rowery']")
    protected WebElement roweryButtonInMenu;

    @FindBy(xpath = "//div[contains(@class, 'is-level1') and ./p[normalize-space(text())='Rowery']]")
    protected WebElement roweryHeader;

    @FindBy(xpath = "//div[contains(@class, 'is-level1') and ./p[normalize-space(text())='Rowery']]/div/div/ul/div/li/a[@data-event-action='Rowery miejskie']")
    protected WebElement roweryMiejskieSubmenu;


    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (WebElement element : elementsOfCarousel) {
            names.add(element.findElement(By.xpath("a")).getText());
        }
        return names;
    }



    public RoweryMiejskiePage hoverOverRoweryButton() {
        actions.moveToElement(roweryButtonInMenu).build().perform();
        wait.until(ExpectedConditions.visibilityOf(roweryButtonInMenu));
        roweryMiejskieSubmenu.click();
        return new RoweryMiejskiePage(driver);
    }





}
