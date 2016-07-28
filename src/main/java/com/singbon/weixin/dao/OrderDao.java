package com.singbon.weixin.dao;

import com.singbon.weixin.base.BaseDao;
import com.singbon.weixin.entity.Order;
import com.singbon.weixin.util.PageView;

import java.util.List;
import java.util.Map;

public interface OrderDao extends BaseDao<Order> {
    public List<Map<String, String>> queryMap(PageView paramPageView, Map<String, String> paramMap);
    public void deleteByCustomerNo(String customerNo);
}






 

 

