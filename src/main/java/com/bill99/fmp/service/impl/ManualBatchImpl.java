package com.bill99.fmp.service.impl;

import com.bill99.fmp.common.enums.PageEnums;
import com.bill99.fmp.common.tools.WebDriverImpl;
import com.bill99.fmp.mapper.seashell.WithdrawWorkOrderMapper;
import com.bill99.fmp.service.ManualBatch;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.Reporter;

@Service
public class ManualBatchImpl implements ManualBatch {
    @Autowired
    private WithdrawWorkOrderMapper withdrawWorkOrderMapper;

    String pagePath = PageEnums.manualBatch.getLocat();
    private String batchId = null;

    @Override
    public String uiBatchWithHand(WebDriver driver, String orderSeqId) {
        Reporter.log("==========出批次操作==============");
        WebDriverImpl webDriverImpl = new WebDriverImpl(driver,pagePath);
        try{

            webDriverImpl.findElement("page.出批次.手动出批次").click();
            driver.switchTo().frame(webDriverImpl.findElement("page.出批次.iframe"));
            webDriverImpl.findElement("page.出批次.交易号").sendKeys(orderSeqId);
            webDriverImpl.findElement("page.出批次.查询").click();
            webDriverImpl.findElement("page.出批次.checkbox").click();
            webDriverImpl.findElement("page.出批次.生成批次").click();
            webDriverImpl.findElement("page.出批次.批次名称").sendKeys("测试");
            webDriverImpl.findElement("page.出批次.批次确认").click();
            webDriverImpl.findElement("page.出批次.申请结果确认").click();
            batchId = withdrawWorkOrderMapper.getBatchId(orderSeqId);
            Reporter.log("批次号："+batchId);
            if(!batchId.equals("") && !batchId.equals(null)){
                Reporter.log("出批次成功",true);
            }else {
                Reporter.log("出批次操作失败",false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放iframe
            driver.switchTo().defaultContent();
            webDriverImpl.findElement("page.出批次.关闭手动出批次Tab页").click();
            return batchId;
        }
    }

}
