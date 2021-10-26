package example.media_expert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class RowerMiejski {

    private String nazwa;
    private String rama;
    private String liczbaBiegow;
    private String przerzutkaPrzednia;
    private String przerzutkaTylna;
    private String rozmiarRamy;
    private String rozmiarKola;
    private String przeznaczenie;
    private BigDecimal cena;

    public RowerMiejski(WebElement productContainer) {
        List<WebElement> atrybuty = productContainer.findElements(By.xpath("div/div/div[contains(@class, 'is-productData')]/div/table/tbody/tr/td[@class='is-value']"));
        this.nazwa = productContainer.findElement(By.xpath("div/div/h2/a")).getText();
        this.rama = atrybuty.get(0).getText();
        this.liczbaBiegow = atrybuty.get(1).getText();
        this.przerzutkaPrzednia = atrybuty.get(2).getText();
        this.przerzutkaTylna = atrybuty.get(3).getText();
        this.rozmiarRamy = atrybuty.get(4).getText();
        this.rozmiarKola = atrybuty.get(5).getText();
        this.przeznaczenie = atrybuty.get(6).getText();
        this.cena = new BigDecimal(productContainer.findElement(By.xpath("div[contains(@class, 'is-col2')]/div[contains(@class, 'is-price')]/div[@data-label='Cena regularna']/div/div"))
                .getAttribute("data-price")).divide(new BigDecimal("100"));


    }

    @Override
    public String toString() {
        return "RowerMiejski{" +
                "nazwa='" + nazwa + '\'' +
                ", rama='" + rama + '\'' +
                ", liczbaBiegow='" + liczbaBiegow + '\'' +
                ", przerzutkaPrzednia='" + przerzutkaPrzednia + '\'' +
                ", przerzutkaTylna='" + przerzutkaTylna + '\'' +
                ", rozmiarRamy='" + rozmiarRamy + '\'' +
                ", rozmiarKola='" + rozmiarKola + '\'' +
                ", przeznaczenie='" + przeznaczenie + '\'' +
                ", cena=" + cena +
                '}';
    }
}

