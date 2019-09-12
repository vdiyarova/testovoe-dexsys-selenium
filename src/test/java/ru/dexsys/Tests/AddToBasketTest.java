package ru.dexsys.Tests;

import org.junit.Assert;
import org.junit.Test;
import ru.dexsys.Pages.BasketPage;
import ru.dexsys.Pages.ProductPage;
import ru.dexsys.Pages.HomePage;
import ru.dexsys.Pages.SearchResultsPage;

public class AddToBasketTest extends BaseTest {
    @Test
    public void addToBasketTest() {
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
        int expectedItemsCount = 1;  // ожидаемое количество позиций в корзине
        int itemsCount = basketPage.getCountItemsBaskets();  // фактическое количество позиций в корзине
        Assert.assertEquals(expectedItemsCount, itemsCount);  // проверяем, что в корзине оказался один товар
        String productNameAddedToBasket = basketPage.getProductName(); // запоминаем название товара в корзине
        boolean result = productNameAddedToBasket.contains(productName);  // проверяем содержится ли в корзине товар с таким названием
        Assert.assertTrue("Товар не добавлен в корзину!", result);
    }
}
