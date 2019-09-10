package ru.dexsys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    WebDriver webDriver;

    public BasketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "span.item-title-good")
    private WebElement productName;

    public String getProductName(){
        return productName.getText();
    }
}
