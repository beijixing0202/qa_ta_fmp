package com.bill99.fmp.common.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasePageTest extends BaseTest {
    public WebDriver driver = new ChromeDriver();
    public BasePageTest(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
