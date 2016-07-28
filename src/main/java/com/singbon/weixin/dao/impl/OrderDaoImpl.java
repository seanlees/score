package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.OrderDao;
import com.singbon.weixin.entity.Order;
import com.singbon.weixin.util.PageView;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {
    public List<Map<String, String>> queryMap(PageView pageView, Map<String, String> t) {
        Map<Object, Object> map = new HashMap();
        map.put("paging", pageView);
        map.put("t", t);
        return getSqlSession().selectList(getClassName() + ".query", map);
    }

    @Override
    public void deleteByCustomerNo(String customerNo) {
        getSqlSession().update("order.deleteByCustomerNo", customerNo);
    }

}






 

 

