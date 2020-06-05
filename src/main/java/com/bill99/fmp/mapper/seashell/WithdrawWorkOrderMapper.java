package com.bill99.fmp.mapper.seashell;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface WithdrawWorkOrderMapper {
    Map<String,String> getSingleTraderOfOrderid(String orderseqid);
    String  getPlatId(String orderseqid);
    String getBatchId(String orderseqid);
}
