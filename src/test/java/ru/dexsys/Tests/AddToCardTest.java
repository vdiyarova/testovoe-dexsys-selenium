package ru.dexsys.Tests;

import org.junit.Test;
import ru.dexsys.Pages.BasketPage;
import ru.dexsys.Pages.ProductPage;
import ru.dexsys.Pages.HomePage;
import ru.dexsys.Pages.SearchResultsPage;

public class AddToCardTest extends BaseTest {
    @Test
    public void addToFavorieTest() {
        driver.get("https://www.wildberries.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.enterProductName();
        homePage.clickSearch();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickToFirstResult();
        ProductPage productPage = new ProductPage(driver);
        String productName = productPage.getProductName(); // запоминаем название только что открытого товара
        productPage.addToBasket();
        productPage.goToBasket();
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
