package ru.dexsys.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "dtlist-inner-brand-name")
    private WebElement firstResult;

    public void clickToFirstResult(){
        firstResult.click();
    }

}
