package example.widgets.modal_dialog;

import com.github.javafaker.Faker;
import example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModalPage extends BasePage {
    public ModalPage(WebDriver driver) {
        super(driver);
    }

    private Faker faker = new Faker();


    @FindBy(id = "create-user")
    protected WebElement createNewUserButton;

    @FindBy(xpath = "//tbody/tr")
    protected List<WebElement> rows;

    @FindBy(xpath = "//div[@tabindex='-1']")
    protected WebElement createNewUserWindow;

    @FindBy(id = "name")
    protected WebElement nameInput;

    @FindBy(id = "email")
    protected WebElement emailInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(xpath = "//button[text()= 'Create an account']")
    protected WebElement createAccountButton;





    public List<User> getListOfUser() {
        List<User> users = new ArrayList<>();

        for (WebElement row : rows) {
            users.add(new User(row));
        }
        return users;
    }

    public List<User> getUsers() {
        return rows.stream().map(row -> new User(row)).collect(Collectors.toList());
    }


    public ModalPage createNewUser(String name, String email, String password) {
        createNewUserButton.click();
        waitForVisibility(createNewUserWindow);

        nameInput.clear();
        emailInput.clear();
        passwordInput.clear();

        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        createAccountButton.click();



        return this;

    }

    public List<String> getNamesOfUsers() {
        List<String> names = new ArrayList<>();
        for (User user : getListOfUser()) {
            names.add(user.getName());
        }
        return names;
    }


    public Set<String> getUniqueNames() {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : getNamesOfUsers()) {
            uniqueNames.add(name);
        }

        return uniqueNames;
    }

}
