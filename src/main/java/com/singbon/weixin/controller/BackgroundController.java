package com.singbon.weixin.controller;

import com.singbon.weixin.dao.UserDao;
import com.singbon.weixin.entity.Resources;
import com.singbon.weixin.entity.User;
import com.singbon.weixin.entity.UserLoginList;
import com.singbon.weixin.service.ResourcesService;
import com.singbon.weixin.service.UserLoginListService;
import com.singbon.weixin.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping({"/background/"})
public class BackgroundController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLoginListService userLoginListService;
    @Autowired
    private ResourcesService resourcesService;
    @Autowired
    private AuthenticationManager myAuthenticationManager;

    @RequestMapping({"login"})
    public String login(Model model, HttpServletRequest request) {
        Object o = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (null != o) {
            request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
        }
        return "/background/framework/login";
    }

    @RequestMapping({"sessionTimeToLogin"})
    public void sessionTimeToLogin(Model model, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Object o = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (null != o) {
            request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
        }
        PrintWriter out = response.getWriter();
        String requestUrl = request.getRequestURI();
        if ((request.getHeader("x-requested-with") != null) &&
                (request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))) {
            response.setHeader("sessionstatus", "timeout");
            out.print("{timeout:true}");
        } else {
            out.print("<script type='text/javascript'>top.location.href='/background/login.html';</script>");
        }
        out.flush();
        out.close();
    }

    @RequestMapping({"loginCheck"})
    public String loginCheck(String username, String password, HttpServletRequest request) {
        try {
            if (!request.getMethod().equals("POST")) {
                request.setAttribute("error", "支持POST方法提交！");
            }
            if ((Common.isEmpty(username)) || (Common.isEmpty(password))) {
                request.setAttribute("error", "用户名或密码不能为空！");
                return "/background/framework/login";
            }
            User users = this.userDao.querySingleUser(username);
            if ((users == null) || (!users.getUserPassword().equals(password))) {
                request.setAttribute("error", "用户或密码不正确！");
                return "/background/framework/login";
            }
            Authentication authentication = this.myAuthenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(username, password));


            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            HttpSession session = request.getSession(true);
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

            request.getSession().setAttribute("userSession", users);

            UserLoginList userLoginList = new UserLoginList();
            userLoginList.setUserId(users.getUserId());
            userLoginList.setLoginIp(Common.toIpAddr(request));
            this.userLoginListService.add(userLoginList);
        } catch (AuthenticationException ae) {
            request.setAttribute("error", "登录异常，请联系管理员！");
            return "/background/framework/login";
        }
        return "redirect:index.html";
    }

    @RequestMapping({"index"})
    public String index(Model model) {
        return "/background/framework/main";
    }

    @RequestMapping({"top"})
    public String top(Model model) {
        return "/background/framework/top";
    }

    @RequestMapping({"left"})
    public String left(Model model, HttpServletRequest request) {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();


            String username = request.getUserPrincipal().getName();

            List<Resources> resources = this.resourcesService.getResourcesByUserName(username);
            model.addAttribute("resources", resources);
        } catch (Exception e) {
            request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
        }
        return "/background/framework/left";
    }

    @RequestMapping({"tab"})
    public String tab(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userSession");
        model.addAttribute("admin", user);
        return "/background/framework/tab/tab";
    }

    @RequestMapping({"center"})
    public String center(Model model) {
        return "/background/framework/center";
    }
}
