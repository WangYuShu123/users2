package com.wyk.controller;

import com.wyk.entity.Users;
import com.wyk.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (Users)表控制层
 *
 * @author wyk
 * @since 2020-02-29 11:31:52
 */
@Controller
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    @RequestMapping("/")
    public String init(Users users,
                       @RequestParam(value = "index" ,defaultValue = "1")
                               Integer index,HttpSession session){



        Page<Users> info=usersService.page(users,index,2);
//        Page<Users> info=usersService.page("王",index,2);
        session.setAttribute("info",info);
        session.setAttribute("likename",users.getName());
        session.setAttribute("i",info.getNumber()+1);
        session.setAttribute("c",info.getTotalPages());
        System.out.println("index"+index);
        return "index";
    }
    @RequestMapping("/page")
    public String page(  Users users, Integer i,HttpSession session){

        //表格内容
        Page<Users> info=usersService.page(users,i,2);
        //保存 类别
        session.setAttribute("info",info);

        session.setAttribute("i",i);
        return "index";
    }
}