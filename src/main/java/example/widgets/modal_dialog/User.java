package example.widgets.modal_dialog;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Data

public class User {

    private String name;
    private String email;
    private String password;

    public User(WebElement row) {

        List<WebElement> columns = row.findElements(By.xpath("td"));

        this.name = columns.get(0).getText();
        this.email = columns.get(1).getText();
        this.password = columns.get(2).getText();
    }
}
