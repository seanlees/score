
package com.singbon.weixin.controller;

import com.singbon.weixin.entity.Resources;
import com.singbon.weixin.entity.Roles;
import com.singbon.weixin.service.ResourcesService;
import com.singbon.weixin.service.UserService;
import com.singbon.weixin.util.Common;
import com.singbon.weixin.util.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping({"/background/resources/"})
public class ResourcesController {
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private UserService userService;

    @RequestMapping({"addUI"})
    public String addUI(Model model) {
        List<Resources> resources = this.resourcesService.findAll();
        model.addAttribute("resources", resources);
        return "/background/resources/add";
    }

    @RequestMapping({"add"})
    public String add(Model model, Resources resources) {
        this.resourcesService.add(resources);
        return "redirect:query.html";
    }

    @RequestMapping({"query"})
    public String query(Model model, Resources resources, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = this.resourcesService.query(pageView, resources);
        model.addAttribute("pageView", pageView);
        return "/background/resources/list";
    }

    @RequestMapping({"deleteById"})
    public String deleteById(Model model, String resourcesId) {
        this.resourcesService.delete(resourcesId);
        return "redirect:query.html";
    }

    @RequestMapping({"getById"})
    public String getById(Model model, String resourcesId, int typeKey) {
        Resources resources = this.resourcesService.getById(resourcesId);
        model.addAttribute("resources", resources);
        List<Resources> resLists = this.resourcesService.findAll();
        model.addAttribute("resLists", resLists);
        if (typeKey == 1) {
            return "/background/resources/edit";
        }
        return "/background/resources/show";
    }

    @RequestMapping({"update"})
    public String updateResources(Model model, Resources resources) {
        this.resourcesService.modify(resources);
        return "redirect:query.html";
    }

    @RequestMapping({"deleteAll"})
    public String deleteAll(String[] check, Model model) {
        for (String id : check) {
            this.resourcesService.delete(id);
        }
        return "redirect:query.html";
    }

    @RequestMapping({"permissioUser"})
    public String permissioUser(Model model, String userId) {
        List<Resources> resources = this.resourcesService.getUserResources(userId);
        List<Resources> allRes = this.resourcesService.findAll();
        StringBuffer sb = new StringBuffer();
        sb.append("var data = [];");
        for (Resources r : allRes) {
            boolean flag = false;
            for (Resources ur : resources) {
                if (ur.getId().equals(r.getId())) {
                    sb.append("data.push({ fid: '" + r
                            .getId() + "', pfid: '" + r
                            .getParentId() + "', fname: '" + r
                            .getName() + "',ischecked: true});");

                    flag = true;
                }
            }
            if (!flag) {
                sb.append("data.push({ fid: '" + r
                        .getId() + "', pfid: '" + r
                        .getParentId() + "', fname: '" + r
                        .getName() + "'});");
            }
        }
        Roles roles = this.userService.findbyUserRole(userId);
        if (roles != null) {
            model.addAttribute("roleId", roles.getId());
        }
        model.addAttribute("resources", sb);
        return "/background/resources/permissioUser";
    }

    @RequestMapping({"permissioRole"})
    public String permissioRole(Model model, String roleId) {
        List<Resources> resources = this.resourcesService.getRoleResources(roleId);
        List<Resources> allRes = this.resourcesService.findAll();
        StringBuffer sb = new StringBuffer();
        sb.append("var data = [];");
        for (Resources r : allRes) {
            boolean flag = false;
            for (Resources ur : resources) {
                if (ur.getId().equals(r.getId())) {
                    sb.append("data.push({ fid: '" + r
                            .getId() + "', pfid: '" + r
                            .getParentId() + "', fname: '" + r
                            .getName() + "',ischecked: true});");

                    flag = true;
                }
            }
            if (!flag) {
                sb.append("data.push({ fid: '" + r
                        .getId() + "', pfid: '" + r
                        .getParentId() + "', fname: '" + r
                        .getName() + "'});");
            }
        }
        model.addAttribute("roleId", roleId);
        model.addAttribute("resources", sb);
        return "/background/resources/permissioUser";
    }

    @ResponseBody
    @RequestMapping({"saveRoleRescours"})
    public String saveRoleRescours(String roleId, String rescId) {
        String errorCode = "1000";
        List<String> list = Common.removeSameItem(Arrays.asList(rescId.split(",")));
        try {
            this.resourcesService.saveRoleRescours(roleId, list);
        } catch (Exception e) {
            e.printStackTrace();
            errorCode = "1001";
        }
        return errorCode;
    }
}






 