 package com.singbon.weixin.entity;
 
 import java.io.Serializable;
 import java.util.Date;
 
 public class Order
   implements Serializable
 {
   private long id;
   private String orderNo;
   private Integer orderType;
   private String productNo;
   private String customerNo;
   private String employeeNo;
   private String employeeName;
   private Double payMoney;
   private String payType;
   private Date orderDate;
   private Double discount;
   private Integer score;
   private Double shouldMoney;
   private Boolean delFlag;

   public static enum OrderType
   {
     NORMAL_ORDER("正常单"),  DISCOUNT_ORDER("优惠单"),  FREE_ORDER("免单(霸王餐)");
     
     private String name;
     
     private OrderType(String name)
     {
       this.name = name;
     }
     
     public String getName()
     {
       return this.name;
     }
     
     public int getVal()
     {
       return ordinal();
     }
   }
   
   public static enum PayType
   {
     CARD_PAY("会员卡支付"),  CASH_PAY("现金支付"),  OTHER("其他方式");
     
     private String name;
     
     private PayType(String name)
     {
       this.name = name;
     }
     
     public String getName()
     {
       return this.name;
     }
     
     public int getVal()
     {
       return ordinal();
     }
   }
   
   public long getId()
   {
     return this.id;
   }
   
   public void setId(long id)
   {
     this.id = id;
   }
   
   public String getOrderNo()
   {
     return this.orderNo;
   }
   
   public void setOrderNo(String orderNo)
   {
     this.orderNo = orderNo;
   }
   
   public Integer getOrderType()
   {
     return this.orderType;
   }
   
   public void setOrderType(Integer orderType)
   {
     this.orderType = orderType;
   }
   
   public String getCustomerNo()
   {
     return this.customerNo;
   }
   
   public void setCustomerNo(String customerNo)
   {
     this.customerNo = customerNo;
   }
   
   public String getEmployeeNo()
   {
     return this.employeeNo;
   }
   
   public void setEmployeeNo(String employeeNo)
   {
     this.employeeNo = employeeNo;
   }
   
   public String getEmployeeName()
   {
     return this.employeeName;
   }
   
   public void setEmployeeName(String employeeName)
   {
     this.employeeName = employeeName;
   }
   
   public Double getPayMoney()
   {
     return this.payMoney;
   }
   
   public void setPayMoney(Double payMoney)
   {
     this.payMoney = payMoney;
   }
   
   public String getPayType()
   {
     return this.payType;
   }
   
   public void setPayType(String payType)
   {
     this.payType = payType;
   }
   
   public Date getOrderDate()
   {
     return this.orderDate;
   }
   
   public void setOrderDate(Date orderDate)
   {
     this.orderDate = orderDate;
   }
   
   public Double getDiscount()
   {
     return this.discount;
   }
   
   public void setDiscount(Double discount)
   {
     this.discount = discount;
   }
   
   public Integer getScore()
   {
     return this.score;
   }
   
   public void setScore(Integer score)
   {
     this.score = score;
   }
   
   public Double getShouldMoney()
   {
     return this.shouldMoney;
   }
   
   public void setShouldMoney(Double shouldMoney)
   {
     this.shouldMoney = shouldMoney;
   }
   
   public String getProductNo()
   {
     return this.productNo;
   }
   
   public void setProductNo(String productNo)
   {
     this.productNo = productNo;
   }

   public Boolean getDelFlag() {
     return delFlag;
   }

   public void setDelFlag(Boolean delFlag) {
     this.delFlag = delFlag;
   }
 }






 

 

