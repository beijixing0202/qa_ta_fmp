package com.bill99.fmp.test;

import com.bill99.fmp.common.tools.BasePageTest;
import com.bill99.fmp.common.utils.FscPay;
import com.bill99.fmp.service.FscLogin;
import com.bill99.fmp.service.ManualBatch;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class DirectChannel extends BasePageTest {


    @Autowired
    private FscPay fscPay;
    @Autowired
    private FscLogin fscLogin;
    @Autowired
    private ManualBatch manualBatch;
    private String OrderSeqId;
    private String  batchId;

    @BeforeTest
    public void beforeTest(){

    }


    @Test(dataProvider = "getData" ,description = "渠道直连")
    public void fscTest(Map<String, String> data) throws InterruptedException {
        Reporter.log("================= 开始"+data.get("comment")+"======================");
        OrderSeqId = fscPay.done(data);
        // 登录出款新平台
         driver = fscLogin.login(driver);
        //手动出批次操作
        batchId = manualBatch.uiBatchWithHand(driver,OrderSeqId);
        //批次管理
        driver.findElement(By.xpath("//*[@id=\"nav\"]/div[4]/div[2]/ul/li[1]/ul/li[2]/div")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#tabs iframe")));
        driver.findElement(By.id("batchCode")).sendKeys(batchId);
        driver.findElement(By.cssSelector("div input#queryBtn:nth-child(1)")).click();

        Thread.sleep(3000);


    }


    @AfterTest
    public void afterTest(){
        if (driver != null){
            driver.quit();
        }
    }


    @Test(dataProvider = "getData")
    public void test3(Map<String,String> data){
        fscPay.done(data);
        /*       //System.setProperty("webdriver.chrome.driver", "E:\\自动化脚本\\qa_ta_acs_fsc\\src\\main\\resources\\browserDriver\\chromedriver.exe");
        WebDriver dr = new ChromeDriver();
//        System.setProperty("phantomjs.binary.path", "E:\\自动化脚本\\qa_ta_acs_fsc\\src\\main\\resources\\browserDriver\\phantomjs.exe");
//        WebDriver dr = new PhantomJSDriver();
        dr.get("http://www.baidu.com");
        Thread.sleep(3000);
        String text = dr.findElement(By.id("su")).getAttribute("value");
        System.out.print(text);
        dr.quit();*/

    }

}