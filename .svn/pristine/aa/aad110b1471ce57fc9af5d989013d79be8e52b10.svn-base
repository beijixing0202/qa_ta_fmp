package com.bill99.fmp.service.impl;

import com.bill99.fmp.common.constant.Constant;
import com.bill99.fmp.common.enums.PageEnums;
import com.bill99.fmp.common.tools.WebDriverImpl;
import com.bill99.fmp.service.FscLogin;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.testng.Reporter;

@Service
public class FscLoginImpl implements FscLogin{
    String pagePath = PageEnums.login.getLocat();
    private String url = Constant.LOGINURL;
    private String userName = Constant.USERNAME;
    private String passWord = Constant.PASSWORD;

    @Override
    public WebDriver login(WebDriver driver) {
        driver.get(url);
        WebDriverImpl webDriver = new WebDriverImpl(driver,pagePath);
        try{
            webDriver.findElement("page.首页.账号").sendKeys(userName);
            webDriver.findElement("page.首页.密码").sendKeys(passWord);
            webDriver.findElement("page.首页.登录").click();
            webDriver.findElement("page.首页.出款").click();
            webDriver.findElement("page.首页.汇款").click();
            if(webDriver.findElement("page.首页.响应信息").getAttribute("innerHTML").contains("控制面板")){
                Reporter.log("登录成功");
            }else{
                Reporter.log("登录失败");
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return driver;
    }
}
