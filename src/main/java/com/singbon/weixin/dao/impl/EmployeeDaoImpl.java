package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.EmployeeDao;
import com.singbon.weixin.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {
    public List<Employee> queryByName(String employeeName) {
        return getSqlSession().selectList("employee.queryByName", employeeName);
    }
}






 

 

