package com.fundingsocieties.fundingsocietiestest;

import com.fundingsocieties.fundingsocietiestest.common.TestConstants;
import com.fundingsocieties.fundingsocietiestest.pages.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    public static final Logger logger = Logger.getLogger(HomePageTest.class);
    @Test(groups = {"Major"})
    public void accessHomePage(){
        HomePage homePage = new HomePage(driver);
        logger.info("Access HomePage");
        Assert.assertEquals(homePage.getPageTitle(), TestConstants.HOME_PAGE_TITLE);
        homePage.clickNavStatistics();
    }
}
