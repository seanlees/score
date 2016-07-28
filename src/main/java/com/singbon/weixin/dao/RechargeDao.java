package com.singbon.weixin.dao;

import com.singbon.weixin.base.BaseDao;
import com.singbon.weixin.entity.RechargeInfo;

public interface RechargeDao extends BaseDao<RechargeInfo> {
    public void deleteByCardNo(String cardNo);
}






 

 

