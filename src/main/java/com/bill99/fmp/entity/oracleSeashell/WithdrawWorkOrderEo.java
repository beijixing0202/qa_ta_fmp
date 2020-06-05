package com.bill99.fmp.entity.oracleSeashell;

import java.util.Date;

public class WithdrawWorkOrderEo {
    /** 提现应用订单号（唯一主键） */
    private Long withdrawworkorderId;
    /** 订单序列号 */
    private Long orderSeqId;
    /** 提现会员号 */
    private Long memberCode;
    /** 提现的类型,1提现、4 API付款 7自动提现 */
    private Long withdrawType;
    /** 提现申请金额 */
    private Long amount;
    /** 姓名 */
    private String name;
    /** 开户行支行名称 */
    private String branchBankName;
    /** 开户银行名称标识 */
    private Long bankNameId;
    /** 省份代码，默认99999 */
    private Long province;
    /** 城市代码，默认99999999 */
    private Long city;
    /** 银行帐户 */
    private String bankAcctId;
    /** Email */
    private String email;
    /** 电话 */
    private String tel;
    /** 工单备注 */
    private String remark;
    /**
     * 工单状态
     *
     * @see WithdrawWorkOrderStatus
     */
    private Long status;
    /** 银行直连返回错误代码 */
    private String errorCode;
    /** 银行处理交易号 */
    private String bankDealId;
    /** 处理类型（1、手工；2、财务直联） */
    private Long processType;
    /** 收款人是否是个人（0、不是个人，即对公； 1、是个人，即对私） */
    private Long isIndividual;
    /** 出款渠道信息 */
    private Long sendBankNameId;
    /** 银行直连返回错误信息 */
    private String errorMsg;
    /** 交易号 */
    private String dealId;
    /** 操作员编号 */
    private String owner;
    /** 财务退款原因 */
    private String refuseReason;
    /** 出款批次号 */
    private Long batchId;
    /** 是否成功退款过，1：退款 */
    private Long isRefund;
    /** 是否是处理中（未处理,1:处理中） */
    private Long isProcess;
    /** 1：付款方付费；0：收款方付费 ，默认为0 */
    private Long transactor;
    /** 是否委托提现（ 0：未委托提现；1：已委托提现） */
    private Long isEntrustRefund;
    /** 用来标识该批次是手工还是直连（0：手工；1：直连） */
    private Long batchIdType;
    /** 付款方货种 */
    private String payerCurrencyCode;
    /** 收款方币种 */
    private String payeeCurrencyCode;
    /** 业务类型 */
    private String businessType;
    /** 资金来源 */
    private String fundOrigin;
    /** 乐观锁标记 */
    private Long syncToken;
    /** 附言，如果附言不为空，则给收款方发送通知 */
    private String fuYuan;
    /** 到银行的备注信息 */
    private String toBankRemark;
    /** 银行接口用途 */
    private String bankPurpose;
    /** 银行接口备注 */
    private String bankMemo;
    /** 出款级别 */
    private String stgyLevel;
    /** T+N出款时间 */
    private String tnValue;
    /** 提现会员名称 */
    private String memberName;
    /** 直连验证失败标识（1：直连验证失败） */
    private Long dpsverifyFail;
    /** 金融机构代码BC_BANK_CODE.BANK_CODE */
    private String bankCode;
    /** 金融机构名称BC_BANK_CODE.BANK_NAME或P_ORGANIZATION.DISPLAYNAME */
    private String bankName;
    /** 渠道ID */
    private Long channelId;
    /** 渠道类型（0：直连；1：网银） */
    private Long channelType;
    /** 接口ID */
    private String interfaceId;
    /** 账户类型（0：对公账号；1：借记卡；2：贷记卡；3：准贷记卡；4：存折） */
    private Long accountType;
    /** 结算计划ID（-1：自动财务直连） */
    private Long planId;
    /** 计划编制工单分类（0：非计划编制工单；1：路由异常工单；2：计划预处理工单；3：计划编制正常工单；4：计划编制紧急工单） */
    private Long planStatus;
    /** 命中规则类型（0：特殊规则；1：通用规则） */
    private Long ruleType;
    /** APP应用标识代码 */
    private String appCode;
    /** 银行账号长度 */
    private Long bankAcctLength;

    /** 申请时间 */
    private Date requestDate;
    /** 风控处理时间 */
    private Date processDate;
    /** 提交银行直连时间 */
    private Date postDate;
    /** 银行直连处理时间 */
    private Date receiveDate;
    /** 最后出款时间 */
    private Date lastToBankTime;
    /** 商户IP*/
    private String ip;

    private RmResultEo rmResultEo;

    /** 渠道ID集合 */
    private String channelIds;

    /** 银行卡开头**/
    private String bankAcctIdPrefix;

    public Long getWithdrawworkorderId() {
        return withdrawworkorderId;
    }

    public void setWithdrawworkorderId(Long withdrawworkorderId) {
        this.withdrawworkorderId = withdrawworkorderId;
    }

    public Long getOrderSeqId() {
        return orderSeqId;
    }

    public void setOrderSeqId(Long orderSeqId) {
        this.orderSeqId = orderSeqId;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public Long getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(Long withdrawType) {
        this.withdrawType = withdrawType;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchBankName() {
        return branchBankName;
    }

    public void setBranchBankName(String branchBankName) {
        this.branchBankName = branchBankName;
    }

    public Long getBankNameId() {
        return bankNameId;
    }

    public void setBankNameId(Long bankNameId) {
        this.bankNameId = bankNameId;
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getBankAcctId() {
        return bankAcctId;
    }

    public void setBankAcctId(String bankAcctId) {
        this.bankAcctId = bankAcctId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getBankDealId() {
        return bankDealId;
    }

    public void setBankDealId(String bankDealId) {
        this.bankDealId = bankDealId;
    }

    public Long getProcessType() {
        return processType;
    }

    public void setProcessType(Long processType) {
        this.processType = processType;
    }

    public Long getIsIndividual() {
        return isIndividual;
    }

    public void setIsIndividual(Long isIndividual) {
        this.isIndividual = isIndividual;
    }

    public Long getSendBankNameId() {
        return sendBankNameId;
    }

    public void setSendBankNameId(Long sendBankNameId) {
        this.sendBankNameId = sendBankNameId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Long getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Long isRefund) {
        this.isRefund = isRefund;
    }

    public Long getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(Long isProcess) {
        this.isProcess = isProcess;
    }

    public Long getTransactor() {
        return transactor;
    }

    public void setTransactor(Long transactor) {
        this.transactor = transactor;
    }

    public Long getIsEntrustRefund() {
        return isEntrustRefund;
    }

    public void setIsEntrustRefund(Long isEntrustRefund) {
        this.isEntrustRefund = isEntrustRefund;
    }

    public Long getBatchIdType() {
        return batchIdType;
    }

    public void setBatchIdType(Long batchIdType) {
        this.batchIdType = batchIdType;
    }

    public String getPayerCurrencyCode() {
        return payerCurrencyCode;
    }

    public void setPayerCurrencyCode(String payerCurrencyCode) {
        this.payerCurrencyCode = payerCurrencyCode;
    }

    public String getPayeeCurrencyCode() {
        return payeeCurrencyCode;
    }

    public void setPayeeCurrencyCode(String payeeCurrencyCode) {
        this.payeeCurrencyCode = payeeCurrencyCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getFundOrigin() {
        return fundOrigin;
    }

    public void setFundOrigin(String fundOrigin) {
        this.fundOrigin = fundOrigin;
    }

    public Long getSyncToken() {
        return syncToken;
    }

    public void setSyncToken(Long syncToken) {
        this.syncToken = syncToken;
    }

    public String getFuYuan() {
        return fuYuan;
    }

    public void setFuYuan(String fuYuan) {
        this.fuYuan = fuYuan;
    }

    public String getToBankRemark() {
        return toBankRemark;
    }

    public void setToBankRemark(String toBankRemark) {
        this.toBankRemark = toBankRemark;
    }

    public String getBankPurpose() {
        return bankPurpose;
    }

    public void setBankPurpose(String bankPurpose) {
        this.bankPurpose = bankPurpose;
    }

    public String getBankMemo() {
        return bankMemo;
    }

    public void setBankMemo(String bankMemo) {
        this.bankMemo = bankMemo;
    }

    public String getStgyLevel() {
        return stgyLevel;
    }

    public void setStgyLevel(String stgyLevel) {
        this.stgyLevel = stgyLevel;
    }

    public String getTnValue() {
        return tnValue;
    }

    public void setTnValue(String tnValue) {
        this.tnValue = tnValue;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getDpsverifyFail() {
        return dpsverifyFail;
    }

    public void setDpsverifyFail(Long dpsverifyFail) {
        this.dpsverifyFail = dpsverifyFail;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getChannelType() {
        return channelType;
    }

    public void setChannelType(Long channelType) {
        this.channelType = channelType;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public Long getAccountType() {
        return accountType;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Long planStatus) {
        this.planStatus = planStatus;
    }

    public Long getRuleType() {
        return ruleType;
    }

    public void setRuleType(Long ruleType) {
        this.ruleType = ruleType;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getBankAcctLength() {
        return bankAcctLength;
    }

    public void setBankAcctLength(Long bankAcctLength) {
        this.bankAcctLength = bankAcctLength;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getLastToBankTime() {
        return lastToBankTime;
    }

    public void setLastToBankTime(Date lastToBankTime) {
        this.lastToBankTime = lastToBankTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public RmResultEo getRmResultEo() {
        return rmResultEo;
    }

    public void setRmResultEo(RmResultEo rmResultEo) {
        this.rmResultEo = rmResultEo;
    }

    public String getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(String channelIds) {
        this.channelIds = channelIds;
    }

    public String getBankAcctIdPrefix() {
        return bankAcctIdPrefix;
    }

    public void setBankAcctIdPrefix(String bankAcctIdPrefix) {
        this.bankAcctIdPrefix = bankAcctIdPrefix;
    }

    @Override
    public String toString() {
        return "WithdrawWorkOrderEo{" +
                "withdrawworkorderId=" + withdrawworkorderId +
                ", orderSeqId=" + orderSeqId +
                ", memberCode=" + memberCode +
                ", withdrawType=" + withdrawType +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", branchBankName='" + branchBankName + '\'' +
                ", bankNameId=" + bankNameId +
                ", province=" + province +
                ", city=" + city +
                ", bankAcctId='" + bankAcctId + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", errorCode='" + errorCode + '\'' +
                ", bankDealId='" + bankDealId + '\'' +
                ", processType=" + processType +
                ", isIndividual=" + isIndividual +
                ", sendBankNameId=" + sendBankNameId +
                ", errorMsg='" + errorMsg + '\'' +
                ", dealId='" + dealId + '\'' +
                ", owner='" + owner + '\'' +
                ", refuseReason='" + refuseReason + '\'' +
                ", batchId=" + batchId +
                ", isRefund=" + isRefund +
                ", isProcess=" + isProcess +
                ", transactor=" + transactor +
                ", isEntrustRefund=" + isEntrustRefund +
                ", batchIdType=" + batchIdType +
                ", payerCurrencyCode='" + payerCurrencyCode + '\'' +
                ", payeeCurrencyCode='" + payeeCurrencyCode + '\'' +
                ", businessType='" + businessType + '\'' +
                ", fundOrigin='" + fundOrigin + '\'' +
                ", syncToken=" + syncToken +
                ", fuYuan='" + fuYuan + '\'' +
                ", toBankRemark='" + toBankRemark + '\'' +
                ", bankPurpose='" + bankPurpose + '\'' +
                ", bankMemo='" + bankMemo + '\'' +
                ", stgyLevel='" + stgyLevel + '\'' +
                ", tnValue='" + tnValue + '\'' +
                ", memberName='" + memberName + '\'' +
                ", dpsverifyFail=" + dpsverifyFail +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", channelId=" + channelId +
                ", channelType=" + channelType +
                ", interfaceId='" + interfaceId + '\'' +
                ", accountType=" + accountType +
                ", planId=" + planId +
                ", planStatus=" + planStatus +
                ", ruleType=" + ruleType +
                ", appCode='" + appCode + '\'' +
                ", bankAcctLength=" + bankAcctLength +
                ", requestDate=" + requestDate +
                ", processDate=" + processDate +
                ", postDate=" + postDate +
                ", receiveDate=" + receiveDate +
                ", lastToBankTime=" + lastToBankTime +
                ", ip='" + ip + '\'' +
                ", rmResultEo=" + rmResultEo +
                ", channelIds='" + channelIds + '\'' +
                ", bankAcctIdPrefix='" + bankAcctIdPrefix + '\'' +
                '}';
    }
}
