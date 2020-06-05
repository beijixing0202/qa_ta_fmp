package com.bill99.fmp.common.tools;

import com.bill99.fmp.common.utils.XMLParser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WebDriverImpl {
    @Autowired
    private XMLParser xmlParser;
    public static final Logger logger = Logger.getLogger(WebDriverImpl.class);
    private WebDriver driver;
    private String pagePath;


    public WebDriverImpl(WebDriver driver, String pagePath){
        this.driver = driver;
        this.pagePath = pagePath;
    }



    public WebElement findElement(String localValue){
        try{
            String elementT = getElementLocateWay(localValue);
//            System.out.println("解析结果："+elementT);
            String[] locateArr = elementT.split("\\^");
//            Reporter.log("切割结果："+locateArr[0]+","+locateArr[1]);
            return findElementByLocateWay(locateArr[0],locateArr[1]);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public  String getElementLocateWay(String  locateValue){
        Map<String, Map<String, String>> map =  xmlParser.parserXML(pagePath);
        try{
            Set<String> set = map.keySet();
            Iterator var3 = set.iterator();
            while (var3.hasNext()){
                String key = (String)var3.next();
                if (key.equals(locateValue)){
                    Map<String, String> childMap = (Map)map.get(key);
                    return childMap.get("locat");
                }
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        return null;

    }


    public  WebElement findElementByLocateWay(String locateWay, String locateValue) {
        WebElement elementL = null;
        byte var5 = -1;
        switch (locateWay.hashCode()) {
            case -1548231387:
                if (locateWay.equals("tagname")) {
                    var5 = 7;
                }
                break;
            case -8935421:
                if (locateWay.equals("classname")) {
                    var5 = 1;
                }
                break;
            case 3355:
                if (locateWay.equals("id")) {
                    var5 = 3;
                }
                break;
            case 98819:
                if (locateWay.equals("css")) {
                    var5 = 2;
                }
                break;
            case 3373707:
                if (locateWay.equals("name")) {
                    var5 = 5;
                }
                break;
            case 114256029:
                if (locateWay.equals("xpath")) {
                    var5 = 8;
                }
                break;
            case 228335784:
                if (locateWay.equals("partiallinktext")) {
                    var5 = 6;
                }
                break;
            case 1195141159:
                if (locateWay.equals("linktext")) {
                    var5 = 4;
                }
                break;
        }

        switch (var5) {
            case 1:
                elementL = this.driver.findElement(By.className(locateValue));
                break;
            case 2:
                elementL = this.driver.findElement(By.cssSelector(locateValue));
                break;
            case 3:
                elementL = this.driver.findElement(By.id(locateValue));
                break;
            case 4:
                elementL = this.driver.findElement(By.linkText(locateValue));
                break;
            case 5:
                elementL = this.driver.findElement(By.name(locateValue));
                break;
            case 6:
                elementL = this.driver.findElement(By.partialLinkText(locateValue));
                break;
            case 7:
                elementL = this.driver.findElement(By.tagName(locateValue));
                break;
            case 8:
                elementL = this.driver.findElement(By.xpath(locateValue));
                break;
            default:
                logger.error("定位方式：" + locateWay + "不被支持");
                Assert.fail("定位方式：" + locateWay + "不被支持");
        }

        return elementL;
    }

}
