package example.table;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Mountain {
    public String rank;
    public String peak;
    public String mountainRange;
    public String state;
    public int height;

//    kontruktor przyjmuje jeden wiersz

    public Mountain(WebElement row){
        WebElement rank = row.findElement(By.xpath("th"));
        List<WebElement> partsOfRow = row.findElements(By.xpath("td"));

        this.rank = rank.getText();
        this.peak = partsOfRow.get(0).getText();
        this.mountainRange = partsOfRow.get(1).getText();
        this.state = partsOfRow.get(2).getText();
        this.height = Integer.parseInt(partsOfRow.get(3).getText());

    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPeak() {
        return peak;
    }

    public void setPeak(String peak) {
        this.peak = peak;
    }

    public String getMountainRange() {
        return mountainRange;
    }

    public void setMountainRange(String mountainRange) {
        this.mountainRange = mountainRange;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "rank='" + rank + '\'' +
                ", peak='" + peak + '\'' +
                ", mountainRange='" + mountainRange + '\'' +
                ", state='" + state + '\'' +
                ", height=" + height +
                '}';
    }
}
