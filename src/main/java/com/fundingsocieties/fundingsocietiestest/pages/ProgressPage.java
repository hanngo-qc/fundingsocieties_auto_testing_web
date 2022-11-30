package com.fundingsocieties.fundingsocietiestest.pages;

import com.fundingsocieties.fundingsocietiestest.pageobject.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressPage extends PageObject {

    private static final String DETAIL_CAPTION_FINANCING_CSS_SELECTOR = "div>div[class='detailCaption']";
    private static final String DETAIL_VALUE_FINANCING_CSS_SELECTOR = "div>font";
    Actions action;

    @FindBy (css = "progress-page>div>div[class*='progressStatisticRow']")
    private WebElement progressStatisticRow;

    @FindBy(css = "div[class='row progressStatisticRow']>div>div[class='statisticDetailRow']")
    private WebElement statisticDetailRow;

    @FindBy(css = "div[class='row progressStatisticRow']>div>div[class='statisticDetailRow']>div[class*='detailNumber']")
    private List<WebElement> detailNumberElements;

    @FindBy(css= "div[class*='progressGraphicContainer']>div[class*='padding-null']>button[class*='tab-button']")
    private List<WebElement> progressTabElements;

    @FindBy(css = "label[for='toggle-approved']")
    private WebElement totalApprovedBtn;

    @FindBy(css = "label[for='toggle-disbursed']")
    private WebElement amountDisbursedBtn;

    @FindBy(css = "label[for='toggle-default']")
    private WebElement defaultRateBtn;

    @FindBy(css = "div[id*='highcharts']>svg>g>g>path[class*='highcharts-point']")
    private List<WebElement> highPointChartElements;

    @FindBy(css = "div[id*= 'highcharts']>svg>g[class*='highcharts-legend']>g>g>g[class*='highcharts-legend-item']")
    private List<WebElement> columnNameElements;

    @FindBy(css = "div[id*='highcharts']>svg>g[class='c']>g[class*='highcharts-column-series']")
    private List<WebElement> columnValueElements;

    public ProgressPage (WebDriver driver) {super(driver);}

    public void waitLogoFSDisplayed (){
        waitHelper.waitUntilElementDisplayed(progressStatisticRow);
    }

    public void switchToProgressWindow (){
        switchHelper.switchToWindow();
    }

    public String getPageTitle(){return driver.getTitle();}

    public int tabSize(){
        return detailNumberElements.size();
    }
    public Map<Integer, String>  getStatisticDetailTitle(){
        Map<Integer, String> detailName = new HashMap<>();
        waitHelper.waitUntilElementDisplayed(statisticDetailRow);
        for (int i = 0; i< tabSize(); i++) {
            String name = statisticDetailRow.findElements(By.cssSelector(DETAIL_CAPTION_FINANCING_CSS_SELECTOR)).get(i).getText();
            detailName.put(i, name);
        }
        return detailName;
    }

    public Map<String, String> getStatisticDetailValue(){
        Map<String, String> detailValue = new HashMap<>();
        waitHelper.waitUntilElementDisplayed(statisticDetailRow);
        for (int i = 0; i< tabSize(); i++) {
            String name = statisticDetailRow.findElements(By.cssSelector(DETAIL_CAPTION_FINANCING_CSS_SELECTOR)).get(i).getText();
            String value = statisticDetailRow.findElements(By.cssSelector(DETAIL_VALUE_FINANCING_CSS_SELECTOR)).get(i).getText();
            detailValue.put(name, value);
        }
        return detailValue;
    }

    public int getTabNameSize(){
        return progressTabElements.size();
    }

    public List<String> getTabName(){
        List<String> tabName = new ArrayList<>();
        for (int i = 0; i < progressTabElements.size(); i++ ){
            tabName.add(progressTabElements.get(i).getText());
        }
        return tabName;
    }

    public void  selectTab(int i){
            progressTabElements.get(i).click();
    }

    public void selectedTotalApprovedBtn(){
        elementHelper.click(totalApprovedBtn);
    }

    public void selectedAmountDisbursedBtn(){
        elementHelper.click(amountDisbursedBtn);
    }

    public void selectedDefaultRateBtn(){
        elementHelper.click(defaultRateBtn);
    }

    public String getLatestHighPointChart(){
        action = new Actions(driver);
        waitHelper.waitUntilElementDisplayed(highPointChartElements.get(highPointChartElements.size()-1));
        //action.moveToElement(highPointChartElements.get(highPointChartElements.size()-1));
        return elementHelper.getText(highPointChartElements.get(highPointChartElements.size()-1));
    }

    public List<String> getColumnName (){
        List<String> columnName = new ArrayList<>();
        for (int i = 0; i < columnNameElements.size(); i++){
            columnName.add(columnNameElements.get(i).getText());
        }
        return columnName;
    }

    public void turnOnOffColumn(int i){
        columnNameElements.get(i).click();
    }

    public int countRepaymentColumn (){
        return columnValueElements.size();
    }
    public List<String> getColumnValue (){
        List<String> columnValue = new ArrayList<>();
        action = new Actions(driver);
        for (int i = 0; i < countRepaymentColumn(); i++){
            action.moveToElement(columnValueElements.get(i));
            columnValue.add(columnValueElements.get(i).getText());
        }
        return columnValue;
    }

}
