package ru.dexsys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage {

    private WebDriver webDriver;

    public BasketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "span.item-title-good")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='item-in-basket']")
    private List<WebElement> basketContents;

    public int getCountItemsBaskets(){
        return basketContents.size();
    }

    public String getProductName(){
        return productName.getText();
    }
}
