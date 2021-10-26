package example.alerts;

import example.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertsPageTest extends BaseTest {

    private AlertsPage alertsPage;
    private String text = "fdfgfdg";


    @BeforeMethod
    public void before() {
        alertsPage = new AlertsPage(driver);
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void simpleAlertTest() {
        alertsPage.clickSimpleAlertButtonAndAcceptAlert();
        String textFromSimpleAlertLabel = alertsPage.getTextFromSimpleAlertLabel();

        assertEquals(textFromSimpleAlertLabel, "OK button pressed");


    }

    @Test
    public void shoulAcceptPromptAlertTest() {
        alertsPage.clickPromptPopupAlertAndAcceptAlert(text);

        String textFromPromptLabel = alertsPage.getTextFromPromptLabel();

        assertEquals(textFromPromptLabel, "Hello "+text+"! How are you today?");
    }

    @Test
    public void shoulCancelPromptAlertTest() {
        alertsPage.clickPromptPopupAlertAndCancel();
        String textFromPromptLabel = alertsPage.getTextFromPromptLabel();

        assertEquals(textFromPromptLabel, "User cancelled the prompt.");

    }

    @Test
    public void shouldCancelConfirmPopupAlert() {
        alertsPage.clickAndConfirmPopupAndAcceptAlert();
        String textFromConfirmAlert = alertsPage.getTextFromConfirmAlert();

        assertEquals(textFromConfirmAlert, "You pressed OK!");
    }

    @Test
    public void shouldAcceptDelayedAlertTest() {
        alertsPage.clickDelayedAlertButton();
        alertsPage.waitAndAcceptDelayedAlert();
        String textFromDelayedAlertLabel = alertsPage.getTextFromDelayedAlertLabel();

        assertEquals(textFromDelayedAlertLabel, "OK button pressed");
    }

    @Test
    public void shouldVerifyThatTextOnAlertIsCorrectTest() {
        alertsPage.clickDelayedAlertButton();
        String textFromDelayedAlert = alertsPage.getTextFromDelayedAlert();

        assertEquals(textFromDelayedAlert, "OK button pressed");
    }


}
