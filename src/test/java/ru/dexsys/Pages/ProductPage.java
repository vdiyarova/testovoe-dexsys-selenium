package ru.dexsys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver webDriver;

    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[text()='В корзину']")
    private WebElement addToBasketButton;

    @FindBy(css = "span.name")
    private WebElement productName;

    public String getProductName(){
        return productName.getText();
    }

    public void addToBasket(){
        addToBasketButton.click();
    }

    @FindBy(css = "a.c-btn-main.j-go-to-basket")
    private WebElement basket;

    public void goToBasket(){
        basket.click();
    }
}
