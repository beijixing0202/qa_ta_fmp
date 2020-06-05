package com.bill99.fmp.common.utils;

import billqa.tools.fo.apiclient.BankRequestBean;
import billqa.tools.fo.apiclient.BankResponseBean;
import com.bill99.fmp.common.constant.Constant;
import com.bill99.fmp.mapper.seashell.WithdrawWorkOrderMapper;
import com.bill99.fmp.service.BankPayService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.testng.Reporter;

import java.util.Map;

public class FscPay {

    @Autowired
    private WithdrawWorkOrderMapper withdrawWorkOrderMapper;

    @Autowired
    private StringUtil stringUtil;

    @Autowired
    @Qualifier("bankPayServiceImpl")
    private BankPayService bankPayService;

    public String done(Map<String, String> datadriven) {

        Reporter.start("--------------------------开始<准备FSC测试数据>---------------------------");
        String OrderSeqId="";
        try{
            String membercode = Constant.MEMBERCODE;
            String ip = "1.1.1.1";
            Reporter.log("会员编号：" + membercode);
            BankRequestBean[] requestBeans = new BankRequestBean[1];
            BankRequestBean requestBean = new BankRequestBean();
            BeanUtils.populate(requestBean, datadriven);
            requestBeans[0] = requestBean;
            //int count = Integer.valueOf(datadriven.get("count"));
            int count = 1;
            BankResponseBean[] responseBeans = new BankResponseBean[1];

            Reporter.log("FO开始发送交易......"+"发送数量：<"+count+">");

            responseBeans = bankPayService.bankPay(requestBeans, membercode,
                    ip, count);
            String[] OrderSeqIds = new String[count];
            String payInfo = "";
            OrderSeqIds[0] = responseBeans[0].getDealId();
            OrderSeqId = OrderSeqIds[0];
            if (!responseBeans[0].getFailureCause().equals("0000")) {
                Reporter.log(
                        "交易发送失败，失败返回码："
                                + responseBeans[0].getFailureCause(), false);
            } else {
                Reporter.log("交易发送成功，OrderSeqId为:" + OrderSeqIds[0], true);
                Reporter.log("手续费为" + responseBeans[0].getDealCharge());

            }
           // payInfo = withdrawWorkOrderMapper.getSingleTraderOfOrderid(OrderSeqIds[0]);
            Map<String,String> map = withdrawWorkOrderMapper.getSingleTraderOfOrderid(OrderSeqIds[0]);
            payInfo = stringUtil.dictToString(map);
            Reporter.log("从数据库获取交易数据相关信息：" + payInfo,
                    StringUtils.hasLength(payInfo));
        }catch(Exception e){
            e.printStackTrace();
            Reporter.log("Exception：准备FSC测试数据发生异常",false);
        }
        Reporter.end("--------------------------结束<准备FSC测试数据>---------------------------");
        return OrderSeqId;
    }
}
