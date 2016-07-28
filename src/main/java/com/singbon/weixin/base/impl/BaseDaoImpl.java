package com.singbon.weixin.base.impl;

import com.singbon.weixin.util.PageView;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport {
    public String getClassName() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class) pt.getActualTypeArguments()[0];

        return clazz.getSimpleName().toString().toLowerCase();
    }

    public void add(T t) {
        getSqlSession().insert(getClassName() + ".add", t);
    }

    public void delete(String id) {
        getSqlSession().delete(getClassName() + ".deleteById", id);
    }

    public T getById(String id) {
        return (T) getSqlSession().selectOne(getClassName() + ".getById", id);
    }

    public T getByNo(String id) {
        return (T) getSqlSession().selectOne(getClassName() + ".getByNo", id);
    }

    public void modify(T t) {
        getSqlSession().update(getClassName() + ".update", t);
    }

    public List<T> query(PageView pageView, T t) {
        Map<Object, Object> map = new HashMap();
        map.put("paging", pageView);
        map.put("t", t);
        return getSqlSession().selectList(getClassName() + ".query", map);
    }

    public List<T> queryAll(T t) {
        return getSqlSession().selectList(getClassName() + ".queryAll", t);
    }
}






 

 

