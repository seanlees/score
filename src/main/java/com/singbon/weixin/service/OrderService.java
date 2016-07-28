package com.singbon.weixin.service;

import com.singbon.weixin.entity.Order;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public PageView query(PageView paramPageView, Order paramOrder);

    public PageView query(PageView paramPageView, Map<String, String> paramMap);

    public ResponseMessage add(Order paramOrder);

    public void modify(Order paramOrder);

    public Order getById(String paramString);

    public List<Order> findAll(Order paramOrder);

    public void deleteByCustomerNo(String customerNo);
}






 

 

