package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.RechargeDao;
import com.singbon.weixin.entity.RechargeInfo;
import org.springframework.stereotype.Repository;

@Repository("rechargeDao")
public class RechargeDaoImpl extends BaseDaoImpl<RechargeInfo> implements RechargeDao {

    @Override
    public void deleteByCardNo(String cardNo) {
        getSqlSession().update("rechargeinfo.deleteByCardNo", cardNo);
    }
}






 

 

