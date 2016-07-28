package com.singbon.weixin.service;

import com.singbon.weixin.entity.RechargeInfo;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;

import java.util.List;

public interface RechargeService {
    public PageView query(PageView paramPageView, RechargeInfo paramCustomer);

    public ResponseMessage add(RechargeInfo paramCustomer);

    public void modify(RechargeInfo paramCustomer);

    public RechargeInfo getById(String paramString);

    public List<RechargeInfo> findAll(RechargeInfo paramCustomer);

    public void deleteByCardNo(String cardNo);
}






 

 

