package com.bill99.fmp.service.impl;

import billqa.tools.fo.apiclient.BankRequestBean;
import billqa.tools.fo.apiclient.BankResponseBean;
import billqa.tools.fo.apiclient.BatchPayServiceLocator;
import com.bill99.fmp.service.BankPayService;
import com.bill99.seashell.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BankPayServiceImpl implements BankPayService {

    @Autowired
    private BatchPayServiceLocator batchPayServiceLocator;
    public String key = "SQUAMIWMWMAT6ZYL";

    public BatchPayServiceLocator getBatchPayServiceLocator() {
        return batchPayServiceLocator;
    }

    public void setBatchPayServiceLocator(
            BatchPayServiceLocator batchPayServiceLocator) {
        this.batchPayServiceLocator = batchPayServiceLocator;
    }

    @Override
    public BankResponseBean[] bankPay(BankRequestBean[] requestBeans,
                                      String MemberCode, String ip, int count) throws RemoteException,
            ServiceException {
        BankResponseBean[] results = new BankResponseBean[count];
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String orderId = "TA_"
                    + new SimpleDateFormat("yyyyMMddHHmmssSSS")
                    .format(new Date());
            requestBeans[0].setOrderId(orderId);

            StringBuffer combinestr = getMacKey(requestBeans, orderId);
            String mac = MD5Util.md5Hex(combinestr.toString()).toUpperCase();
            requestBeans[0].setMac(mac);
            // BatchPayServiceLocator myPort = new BatchPayServiceLocator();
            results[i] = batchPayServiceLocator.getBatchPayWS().bankPay(
                    requestBeans, MemberCode, ip)[0];
        }
        return results;
    }

    /**
     * @param requestBeans
     * @param orderId
     * @return
     */
    public StringBuffer getMacKey(BankRequestBean[] requestBeans, String orderId) {
        StringBuffer combinestr = new StringBuffer();
        combinestr.append(requestBeans[0].getBankCardNumber());
        combinestr.append(String.valueOf(requestBeans[0].getAmount()));
        combinestr.append(orderId);
        combinestr.append(key);
        return combinestr;
    }
}
