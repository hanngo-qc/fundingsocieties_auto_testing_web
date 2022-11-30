package com.fundingsocieties.fundingsocietiestest;

import com.fundingsocieties.fundingsocietiestest.common.TestConstants;
import com.fundingsocieties.fundingsocietiestest.helper.ScrollHelper;
import com.fundingsocieties.fundingsocietiestest.pages.HomePage;
import com.fundingsocieties.fundingsocietiestest.pages.ProgressPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressPageTest extends BaseTest{
    public static final Logger logger = Logger.getLogger(ProgressPageTest.class);
    @Test(groups = {"Major"})
    public void accessProgressPage() {
        HomePage homePage = new HomePage(driver);
        ProgressPage progressPage = new ProgressPage(driver);

        logger.info("Access Home Page");
        Assert.assertEquals(homePage.getPageTitle(), TestConstants.HOME_PAGE_TITLE);
        homePage.clickNavStatistics();

        logger.info("Access Progress Page");
        progressPage.waitLogoFSDisplayed();
        Assert.assertEquals(progressPage.getPageTitle(), TestConstants.PROGRESS_PAGE_TITLE);
    }

    @Test(groups = {"Major"})
    public void getDetailFunded(){
        ProgressPage progressPage = new ProgressPage(driver);
        accessProgressPage();

        logger.info("Get detail Funded and Detail Value");
        for (int i = 0; i< progressPage.tabSize(); i++) {
            String fundedName = progressPage.getStatisticDetailTitle().get(i);
            String fundedValue;
            if (fundedName!= null){
                fundedValue = progressPage.getStatisticDetailValue().get(fundedName);
            } else {
                fundedValue = "is not existed";
            }
            System.out.println(fundedName.replace("\n", "")+": "+fundedValue);
        }

    }

    @Test(groups = {"Major"})
    public void verifyExistedTab (){
        ProgressPage progressPage = new ProgressPage(driver);
        accessProgressPage();

        logger.info("Get Tab Name");
        for (int i = 0; i< progressPage.getTabNameSize(); i++) {
            String tabName = progressPage.getTabName().get(i);
            if (tabName!= null) {
                System.out.println(tabName+" is existed");
            }
        }
    }

    @Test(groups = {"Major"})
    public void verifiedSMEFinancingDetail_TotalApproved (){
        ProgressPage progressPage = new ProgressPage(driver);
        ScrollHelper scrollHelper = new ScrollHelper(driver);
        accessProgressPage();

        logger.info("Selected General tab");
        int i = 0;
        int tabNameSize = progressPage.getTabNameSize();
        do {
           progressPage.selectTab(i);
           i++;
        } while (progressPage.getTabName().get(i) ==TestConstants.GENERAL_TAB && i < tabNameSize);
        scrollHelper.scrollToMiddlePage();
        //progressPage.selectedTotalApprovedBtn();
        String totalApproved = progressPage.getLatestHighPointChart();
        if (totalApproved != null){
            System.out.println("Total Approved is "+ totalApproved);
        }
    }

    @Test(groups = {"Major"})
    public void verifiedSMEFinancingDetail_AmountDisbursed (){
        ProgressPage progressPage = new ProgressPage(driver);
        ScrollHelper scrollHelper = new ScrollHelper(driver);
        accessProgressPage();

        logger.info("Selected General tab");
        int i = 0;
        int tabNameSize = progressPage.getTabNameSize();
        do {
            progressPage.selectTab(i);
            i++;
        } while (progressPage.getTabName().get(i) ==TestConstants.GENERAL_TAB && i < tabNameSize);
        scrollHelper.scrollToMiddlePage();
        progressPage.selectedAmountDisbursedBtn();
        String amountDisbursed = progressPage.getLatestHighPointChart();
        if (amountDisbursed != null){
            System.out.println("Amount disbursed is "+ amountDisbursed);
        }
    }

    @Test(groups = {"Major"})
    public void verifiedSMEFinancingDetail_DefaultRate (){
        ProgressPage progressPage = new ProgressPage(driver);
        ScrollHelper scrollHelper = new ScrollHelper(driver);
        accessProgressPage();

        logger.info("Selected General tab");
        int i = 0;
        int tabNameSize = progressPage.getTabNameSize();
        do {
            progressPage.selectTab(i);
            i++;
        } while (progressPage.getTabName().get(i) ==TestConstants.GENERAL_TAB && i < tabNameSize);
        scrollHelper.scrollToMiddlePage();
        progressPage.selectedDefaultRateBtn();
        String defaultRate =progressPage.getLatestHighPointChart();
        if (defaultRate != null){
            System.out.println("Default rate is"+defaultRate);
        }
    }

    @Test(groups = {"Major"})
    public void verifiedRepaymentDetail (){
        ProgressPage progressPage = new ProgressPage(driver);
        accessProgressPage();
        logger.info("Selected Repayment tab");
        int i = 0;
        int tabNameSize = progressPage.getTabNameSize();
        do {
            progressPage.selectTab(i);
            i++;
        } while (progressPage.getTabName().get(i) ==TestConstants.REPAYMENT_TAB && i < tabNameSize);
        logger.info("Selected Repayment detail value");
        for (int j = 0; j < progressPage.countRepaymentColumn(); j++){
            System.out.println(progressPage.getColumnValue().get(j));
        }

    }
}
