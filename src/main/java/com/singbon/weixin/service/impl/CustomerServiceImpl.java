package com.singbon.weixin.service.impl;

import com.singbon.weixin.dao.CustomerDao;
import com.singbon.weixin.dao.OrderDao;
import com.singbon.weixin.dao.RechargeDao;
import com.singbon.weixin.entity.Customer;
import com.singbon.weixin.service.CustomerService;
import com.singbon.weixin.util.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RechargeDao rechargeDao;

    public PageView query(PageView pageView, Customer customer) {
        List<Customer> list = this.customerDao.query(pageView, customer);
        pageView.setRecords(list);
        return pageView;
    }

    public void add(Customer customer) {
        this.customerDao.add(customer);
    }

    public void delete(String id) {
        this.customerDao.delete(id);
    }

    public void deleteLogicById(String id) {
        Customer customer = getById(id);
        orderDao.deleteByCustomerNo(customer.getCardNo());
        rechargeDao.deleteByCardNo(customer.getCardNo());
        this.customerDao.deleteLogicById(id);
    }

    public void modify(Customer customer) {
        this.customerDao.modify(customer);
    }

    public Customer getById(String id) {
        return (Customer) this.customerDao.getById(id);
    }

    public Customer getByNo(String no) {
        return (Customer) this.customerDao.getByNo(no);
    }

    public boolean cardNoExists(String no) {
        return this.customerDao.getByCardNo(no).size() > 0;
    }

    public List<Customer> findAll(Customer customer) {
        return this.customerDao.queryAll(null);
    }
}






 

 

