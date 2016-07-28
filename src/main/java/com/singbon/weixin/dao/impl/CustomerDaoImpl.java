package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.CustomerDao;
import com.singbon.weixin.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {


    public void deleteLogicById(String id) {
        getSqlSession().update("customer.deleteLogicById", id);
    }

    public List<Customer> getByCardNo(String cardNo) {
        List<Customer> customerList = getSqlSession().selectList("customer.getByCardNo", cardNo);
        return customerList;
    }
}






 

 

