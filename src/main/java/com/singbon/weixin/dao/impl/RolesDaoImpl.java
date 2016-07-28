package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.RolesDao;
import com.singbon.weixin.entity.Roles;
import com.singbon.weixin.entity.UserRoles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("rolesDao")
public class RolesDaoImpl extends BaseDaoImpl<Roles> implements RolesDao {
    public List<Roles> findAll() {
        return getSqlSession().selectList("roles.findAll");
    }

    public void saveUserRole(UserRoles userRoles) {
        getSqlSession().insert("roles.saveUserRole", userRoles);
    }

    public void deleteUserRole(String userId) {
        getSqlSession().delete("roles.deleteUserRole", userId);
    }
}






 

 

