package com.singbon.weixin.controller;

import com.singbon.weixin.base.BaseController;
import com.singbon.weixin.entity.Order;
import com.singbon.weixin.entity.Product;
import com.singbon.weixin.service.OrderService;
import com.singbon.weixin.service.ProductService;
import com.singbon.weixin.util.Common;
import com.singbon.weixin.util.PageView;
import com.singbon.weixin.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"/background/order/"})
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @RequestMapping({"addUI"})
    public String addUI(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        return "/background/order/add";
    }

    @RequestMapping({"query"})
    public String query(Model model, @RequestParam MultiValueMap<String, String> param, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(15, 1);
        } else {
            pageView = new PageView(15, Integer.parseInt(pageNow));
        }
        pageView = this.orderService.query(pageView, param.toSingleValueMap());
        model.addAttribute("pageView", pageView);
        return "/background/order/list";
    }

    @RequestMapping({"add"})
    public String add(Model model, Order order) {
        long randNum = System.currentTimeMillis() + (int) (Math.random() * 1000.0D);
        order.setOrderNo(randNum + "");
        order.setOrderDate(new Date());


        ResponseMessage rm = this.orderService.add(order);
        if (rm.isResult()) {
            return "redirect:query.html";
        }
        model.addAttribute("message", rm.getMessage());
        return "/background/error";
    }

    @RequestMapping({"getById"})
    public String getById(Model model, String orderId, int typeKey) {
        Order data = this.orderService.getById(orderId);
        model.addAttribute("order", data);
        if (typeKey == 1) {
            return "/background/order/edit";
        }
        return "/background/order/show";
    }

    @RequestMapping({"update"})
    public String updateResources(Model model, Order order) {
        this.orderService.modify(order);
        return "redirect:query.html";
    }
}






 