package com.fundingsocieties.fundingsocietiestest.pages;

import com.fundingsocieties.fundingsocietiestest.helper.SwitchHelper;
import com.fundingsocieties.fundingsocietiestest.pageobject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(css = "header>div>nav>ul>li[class='nav-menu__item']>a[href='/progress']")
    private WebElement navStatistics;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickNavStatistics (){
        elementHelper.click(navStatistics);
    }

}
