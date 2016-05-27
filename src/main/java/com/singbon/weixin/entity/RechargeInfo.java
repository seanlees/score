package com.singbon.weixin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by haofeng on 2016-05-26.
 */
public class RechargeInfo implements Serializable {

    private Long id;
    /**
     * 充值金额
     */
    private Double rechargeMoney;
    /**
     * 充值卡号
     */
    private String cardNo;
    /**
     * 充值会员名称
     */
    private String customerName;
    /**
     * 充值操作人员
     */
    private String rechargeOperator;
    /**
     * 赠送积分
     */
    private Integer score;

    private Date rechargeDate;
    /**
     * 赠送金额
     */
    private Integer freeMoney;

    private Date beginDate;
    private Date endDate;
    private String customerNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRechargeOperator() {
        return rechargeOperator;
    }

    public void setRechargeOperator(String rechargeOperator) {
        this.rechargeOperator = rechargeOperator;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(Integer freeMoney) {
        this.freeMoney = freeMoney;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
}
