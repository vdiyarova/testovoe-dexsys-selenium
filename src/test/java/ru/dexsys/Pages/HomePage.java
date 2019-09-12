package ru.dexsys.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "tbSrch") // поле поиска
    private WebElement searchField;

    public void enterProductName(){ // ввод названия продукта
        searchField.sendKeys("samsung galaxy s10e 6/128");
    }  // ввод названи товара

    public void clickSearch(){ // клик enter
        searchField.sendKeys(Keys.ENTER);
    }  // кликаем enter в поле поиска
}

