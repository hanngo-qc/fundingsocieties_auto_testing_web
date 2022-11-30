package com.fundingsocieties.fundingsocietiestest.helper;

import org.openqa.selenium.WebDriver;

public class SwitchHelper {
    private WebDriver driver;

    public SwitchHelper(WebDriver driver) { this.driver = driver; }

    public String switchToWindow (){
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        return winHandleBefore;
    }
}
