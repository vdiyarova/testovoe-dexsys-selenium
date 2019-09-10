package ru.dexsys.Tests;

import org.junit.Test;
import ru.dexsys.Pages.BasketPage;
import ru.dexsys.Pages.ProductPage;
import ru.dexsys.Pages.HomePage;
import ru.dexsys.Pages.SearchResultsPage;

public class AddToBasketTest extends BaseTest {
    @Test
    public void addToBasketTest() {
        driver.get("https://www.wildberries.ru/"); //открываем страницу

        HomePage homePage = new HomePage(driver);
        homePage.enterProductName(); // вводим название товара
        homePage.clickSearch();  //кликаем на клваиатуре enter

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickToFirstResult();  // тапаем по первому результату

        ProductPage productPage = new ProductPage(driver);
        String productName = productPage.getProductName(); // запоминаем название только что открытого товара
        productPage.addToBasket(); // добавляем в корзину
        productPage.goToBasket();  // переходим к корзине

        BasketPage basketPage = new BasketPage(driver);
        String productNameAddedToBasket = basketPage.getProductName(); // запоминаем название товара в корзине

        if (productNameAddedToBasket.contains(productName)){ // сравниваем названия
            System.out.println("Товар успешно добавлен в корзину!");
        }
        else {
            System.out.println("Товар не добавлен!");
        }
    }
}
