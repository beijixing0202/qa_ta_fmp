package com.bill99.fmp.entity.mysql;

import java.util.Date;

public class RefundOrderEo {
    /** 唯一主键 */
    private Long refundId;
    /** 批次任务id */
    private Long taskId;
    /** 交易号 */
    private Long orderSeqId;
    /** 操作类型:1:单笔退款,2:批量退款 */
    private Long operateType;
    /** 退款失败原因 */
    private String failReason;
    /** 状态:1:待退款,2:已退款,3:退款异常,4:退款失败,5:退款中,6:退款异常(第一步记账),7:退款异常(第二步记账),8:退款异常(第三步记账),9:退款异常(修改退款订单记录) */
    private Long status;
    /** 备用字段 */
    private String memo;
    /** 创建时间 */
    private Date crt_time;
    /** 更新时间 */
    private Date upd_time;


    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getOrderSeqId() {
        return orderSeqId;
    }

    public void setOrderSeqId(Long orderSeqId) {
        this.orderSeqId = orderSeqId;
    }

    public Long getOperateType() {
        return operateType;
    }

    public void setOperateType(Long operateType) {
        this.operateType = operateType;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCrt_time() {
        return crt_time;
    }

    public void setCrt_time(Date crt_time) {
        this.crt_time = crt_time;
    }

    public Date getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(Date upd_time) {
        this.upd_time = upd_time;
    }

    @Override
    public String toString() {
        return "RefundOrderEo{" +
                "refundId=" + refundId +
                ", taskId=" + taskId +
                ", orderSeqId=" + orderSeqId +
                ", operateType=" + operateType +
                ", failReason='" + failReason + '\'' +
                ", status=" + status +
                ", memo='" + memo + '\'' +
                ", crt_time=" + crt_time +
                ", upd_time=" + upd_time +
                '}';
    }
}
