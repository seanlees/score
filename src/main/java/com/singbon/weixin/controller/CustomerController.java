package com.singbon.weixin.controller;

import com.singbon.weixin.base.BaseController;
import com.singbon.weixin.entity.Customer;
import com.singbon.weixin.service.CustomerService;
import com.singbon.weixin.util.Common;
import com.singbon.weixin.util.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"/background/customer/"})
public class CustomerController
        extends BaseController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping({"addUI"})
    public String addUI() {
        return "/background/customer/add";
    }

    @RequestMapping({"query"})
    public String query(Model model, Customer customer, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(15, 1);
        } else {
            pageView = new PageView(15, Integer.parseInt(pageNow));
        }
        pageView = this.customerService.query(pageView, customer);
        model.addAttribute("pageView", pageView);
        return "/background/customer/list";
    }

    @RequestMapping({"add"})
    public String add(Model model, Customer customer) {
        if (this.customerService.cardNoExists(customer.getCardNo())) {
            model.addAttribute("message", "会员卡号在系统中已经存在，不能重复建卡！");
            return "/background/error";
        }
        Date currentDate = new Date();
        customer.setBirthDay(currentDate);
        customer.setRegDate(currentDate);
        customer.setCardCreateDate(currentDate);
        if (!StringUtils.hasText(customer.getCardPwd())) {
            customer.setCardPwd("888888");
        }
        long randNum = System.currentTimeMillis() + (int) (Math.random() * 1000.0D);
        customer.setCustomerNo(randNum + "");


        this.customerService.add(customer);
        return "redirect:query.html";
    }

    @RequestMapping(value = {"async/all"}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public List<Customer> getCustomers() {
        return this.customerService.findAll(null);
    }

    @RequestMapping({"deleteById"})
    public String deleteById(Model model, String customerId) {
        this.customerService.deleteLogicById(customerId);
        return "redirect:query.html";
    }

    @RequestMapping({"getById"})
    public String getById(Model model, String customerId, int typeKey) {
        Customer customer = this.customerService.getById(customerId);
        model.addAttribute("customer", customer);
        if (typeKey == 1) {
            return "/background/customer/edit";
        }
        return "/background/customer/show";
    }

    @RequestMapping({"update"})
    public String updateResources(Model model, @ModelAttribute Customer customer) {
        this.customerService.modify(customer);
        return "redirect:query.html";
    }
}






 