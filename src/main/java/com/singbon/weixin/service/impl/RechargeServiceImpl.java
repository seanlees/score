package com.singbon.weixin.service.impl;

import com.singbon.weixin.dao.CustomerDao;
import com.singbon.weixin.dao.RechargeDao;
import com.singbon.weixin.entity.Customer;
import com.singbon.weixin.entity.RechargeInfo;
import com.singbon.weixin.service.RechargeService;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeDao rechargeDao;

    @Autowired
    private CustomerDao customerDao;

    public PageView query(PageView pageView, RechargeInfo rechargeInfo) {
        List<RechargeInfo> list = this.rechargeDao.query(pageView, rechargeInfo);
        pageView.setRecords(list);
        return pageView;
    }

    public ResponseMessage add(RechargeInfo rechargeInfo) {

        List<Customer> customers = customerDao.getByCardNo(rechargeInfo.getCardNo());

        if (customers.size() < 0) {
            return ResponseMessage.fail().message("卡号不存在!");
        }

        if (customers.size() > 1) {
            return ResponseMessage.fail().message("卡号异常,查询到多个人对应一个卡号，请联系李浩锋!");
        }

        Customer customer = customers.get(0);
        customer.setCardMoney(customer.getCardMoney() + rechargeInfo.getRechargeMoney());

        if (rechargeInfo.getScore() != null) {
            //充值增加积分
            if (rechargeInfo.getScore().intValue() > 0) {
                customer.setScore(customer.getScore().intValue() + rechargeInfo.getScore().intValue());
            }
        }

        if (rechargeInfo.getFreeMoney() != null) {
            //充值赠送金额
            if (rechargeInfo.getFreeMoney() > 0) {
                customer.setCardMoney(customer.getCardMoney() + rechargeInfo.getFreeMoney());
            }
        }

        this.rechargeDao.add(rechargeInfo);
        this.customerDao.modify(customer);

        return ResponseMessage.success().message("success");
    }

    public void delete(String id) {
        this.rechargeDao.delete(id);
    }

    public void modify(RechargeInfo customer) {
        this.rechargeDao.modify(customer);
    }

    public RechargeInfo getById(String id) {
        return (RechargeInfo) this.rechargeDao.getById(id);
    }

    public List<RechargeInfo> findAll(RechargeInfo customer) {
        return this.rechargeDao.queryAll(null);
    }
}






 

 

