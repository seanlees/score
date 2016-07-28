package com.singbon.weixin.dao.impl;

import com.singbon.weixin.base.impl.BaseDaoImpl;
import com.singbon.weixin.dao.ResourcesDao;
import com.singbon.weixin.entity.ResourceRoles;
import com.singbon.weixin.entity.Resources;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resourcesDao")
public class ResourcesDaoImpl
        extends BaseDaoImpl<Resources>
        implements ResourcesDao {
    public List<Resources> findAll() {
        return getSqlSession().selectList("resources.findAll");
    }

    public List<Resources> getUserResources(String userId) {
        return getSqlSession().selectList("resources.getUserResources", userId);
    }

    public List<Resources> getResourcesByUserName(String username) {
        return getSqlSession().selectList("resources.getResourcesByUserName", username);
    }

    public List<Resources> getRoleResources(String roleId) {
        return getSqlSession().selectList("resources.getRoleResources", roleId);
    }

    public void saveRoleRescours(ResourceRoles resourceRoles) {
        getSqlSession().insert("resources.saveRoleRescours", resourceRoles);
    }

    public void deleteRoleRescours(String roleId) {
        getSqlSession().delete("resources.deleteRoleRescours", roleId);
    }
}






 

 

