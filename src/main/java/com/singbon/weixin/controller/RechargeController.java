package com.singbon.weixin.controller;

import com.singbon.weixin.base.BaseController;
import com.singbon.weixin.entity.RechargeInfo;
import com.singbon.weixin.service.RechargeService;
import com.singbon.weixin.util.Common;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/background/recharge/"})
public class RechargeController
        extends BaseController {
    @Autowired
    private RechargeService rechargeService;

    @RequestMapping({"addUI"})
    public String addUI() {
        return "/background/recharge/add";
    }

    @RequestMapping({"query"})
    public String query(Model model, RechargeInfo rechargeInfo, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(15, 1);
        } else {
            pageView = new PageView(15, Integer.parseInt(pageNow));
        }
        pageView = this.rechargeService.query(pageView, rechargeInfo);
        model.addAttribute("pageView", pageView);
        return "/background/recharge/list";
    }

    @RequestMapping({"add"})
    public String add(Model model, RechargeInfo rechargeInfo) {

        if (!StringUtils.hasText(rechargeInfo.getCardNo())) {
            model.addAttribute("message", "会员卡号不能为空！");
            return "/background/error";
        }

        if (!StringUtils.hasText(rechargeInfo.getCustomerName())) {
            model.addAttribute("message", "会员姓名不能为空！");
            return "/background/error";
        }

        if (rechargeInfo.getRechargeMoney() <= 0) {
            model.addAttribute("message", "充值金额不能为空！");
            return "/background/error";
        }

        if (!StringUtils.hasText(rechargeInfo.getRechargeOperator())) {
            model.addAttribute("message", "充值操作人不能为空！");
            return "/background/error";
        }

        ResponseMessage response = this.rechargeService.add(rechargeInfo);

        if (!response.isResult()) {
            model.addAttribute("message", response.getMessage());
            return "/background/error";
        }

        return "redirect:query.html";
    }

}






 