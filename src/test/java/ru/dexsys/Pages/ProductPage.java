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

    @FindBy(xpath = "//button[text()='В корзину']") // кнопка В корзину
    private WebElement addToBasketButton;

    @FindBy(css = "span.name")  // название товара
    private WebElement productName;

    @FindBy(css = "a.c-btn-main.j-go-to-basket")
    private WebElement basket;  // кнопка Корзина

    public String getProductName(){
        return productName.getText();
    } // получаем название товара

    public void addToBasket(){
        addToBasketButton.click();
    }  // добавление в корзину

    public void goToBasket(){
        basket.click();
    }  // переход к корзине
}
