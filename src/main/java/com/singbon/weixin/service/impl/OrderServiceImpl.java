package com.singbon.weixin.service.impl;

import com.singbon.weixin.dao.CustomerDao;
import com.singbon.weixin.dao.OrderDao;
import com.singbon.weixin.entity.Customer;
import com.singbon.weixin.entity.Order;
import com.singbon.weixin.service.OrderService;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerDao customerDao;

    public PageView query(PageView pageView, Order order) {
        List<Order> list = this.orderDao.query(pageView, order);
        pageView.setRecords(list);
        return pageView;
    }

    public PageView query(PageView pageView, Map<String, String> param) {
        List<Map<String, String>> list = this.orderDao.queryMap(pageView, param);
        pageView.setRecords(list);
        return pageView;
    }

    public ResponseMessage add(Order order) {
        Customer c = this.customerDao.getByNo(order.getCustomerNo());

        double discount = order.getDiscount().doubleValue();
        if ((discount > 0.0D) && (discount < 1.0D)) {
            order.setPayMoney(Double.valueOf(order.getShouldMoney().doubleValue() * discount));
        } else {
            order.setPayMoney(order.getShouldMoney());
        }
        if ((Order.PayType.CARD_PAY.ordinal() + "").equals(order.getPayType())) {
            double money = c.getCardMoney().doubleValue() - order.getPayMoney().doubleValue();
            if (money < 0.0D) {
                return ResponseMessage.fail().message("会员卡内余额不足!");
            }
            c.setCardMoney(money);
        }
        if (order.getScore().intValue() > 0) {
            c.setScore(Integer.valueOf(c.getScore().intValue() + order.getScore().intValue()));
        }
        this.customerDao.modify(c);
        this.orderDao.add(order);

        return ResponseMessage.success();
    }

    public void modify(Order order) {
        this.orderDao.modify(order);
    }

    public Order getById(String id) {
        return (Order) this.orderDao.getById(id);
    }

    public List<Order> findAll(Order order) {
        return null;
    }

    @Override
    public void deleteByCustomerNo(String customerNo) {
        this.orderDao.deleteByCustomerNo(customerNo);
    }
}






 

 

