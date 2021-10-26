package example.widgets.modal_dialog;

import com.github.javafaker.Faker;
import example.BaseTest;
import example.widgets.modal_dialog.ModalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ModalPageTest extends BaseTest {

    private ModalPage modalPage;
    private Faker faker = new Faker();
    private String name = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String password = faker.animal().name();



    @BeforeMethod
    public void before() {
        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");
        modalPage = new ModalPage(driver);

    }

    @Test
    public void test() {
        System.out.println(modalPage.getListOfUser());
        System.out.println(modalPage.getUsers());
    }

    @Test
    public void test1() {
        modalPage.createNewUser("Igo", "igo@iho.pl", "qwert");
        modalPage.createNewUser("Igofd", "igfgo@iho.pl", "qwert");
        modalPage.createNewUser("Igofd", "igogf@iho.pl", "qwert");
        modalPage.createNewUser("Igofeed", "igfgo@iho.pl", "qwert");

        System.out.println(modalPage.getListOfUser().size());

//        modalPage.createNewUser(name, email, password);
//        System.out.println(modalPage.getListOfUser().size());

        Assert.assertEquals( modalPage.getListOfUser().size(), 5);
        Assert.assertEquals(modalPage.getListOfUser().get(modalPage.getListOfUser().size()-1).getName(), "Igofeed");
        Assert.assertNotEquals(modalPage.getNamesOfUsers().size(), modalPage.getUniqueNames().size());

    }







}
