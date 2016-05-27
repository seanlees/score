package com.singbon.weixin.service;

import com.singbon.weixin.entity.RechargeInfo;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;

import java.util.List;

public abstract interface RechargeService {
    public abstract PageView query(PageView paramPageView, RechargeInfo paramCustomer);

    public abstract ResponseMessage add(RechargeInfo paramCustomer);


    public abstract void modify(RechargeInfo paramCustomer);

    public abstract RechargeInfo getById(String paramString);

    public abstract List<RechargeInfo> findAll(RechargeInfo paramCustomer);

}






 

 

