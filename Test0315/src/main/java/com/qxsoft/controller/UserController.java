package com.qxsoft.controller;

import com.alibaba.fastjson.JSON;
import com.qxsoft.model.TbaddressEntity;
import com.qxsoft.model.TbusersEntity;
import com.qxsoft.repository.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jz128 on 2016/3/15.
 */
@Controller
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/toregist",method = RequestMethod.GET)
    public String toReigist(){
        return "regist";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces="application/json; charset=UTF-8")
    @ResponseBody
    public int userLogin(String tbusers, HttpSession session){
        TbusersEntity user = JSON.parseObject(tbusers,TbusersEntity.class);
        user = userService.userLogIn(user);
        int num=-1;
        if(user!=null){
            num=user.getIrolelevel();
            session.setAttribute("user",user);
        }
        return num;
    }

    @RequestMapping(value = "/repeatName",method = RequestMethod.POST,produces="application/json; charset=UTF-8")
    public @ResponseBody String userRepeatName(String susername){
        if (userService.getUserNameRepeat(susername)){
            return "{\"result\":\"此用户名可用\"}";
        }else {
            return "{\"result\":\"此用户名重复,不可注册\"}";
        }
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST,produces="application/json; charset=UTF-8")
    public @ResponseBody String userRegist(String tbusers,String tbaddress) {
        TbusersEntity tbusersEntity= JSON.parseObject(tbusers,TbusersEntity.class);
        TbaddressEntity tbaddressEntity=JSON.parseObject(tbaddress,TbaddressEntity.class);
        if (userService.userRegist(tbusersEntity,tbaddressEntity)){
            return "{\"result\":\"用户注册成功\"}";
        }else {
            return "{\"result\":\"用户注册失败\"}";
        }
    }

    @RequestMapping(value = "/regist2",method = RequestMethod.POST,produces="application/json; charset=UTF-8")
    public @ResponseBody String userRegist2(String objList) {
        List<TbusersEntity> uList= JSON.parseArray(objList,TbusersEntity.class);
        /*TbaddressEntity tbaddressEntity=JSON.parseObject(tbaddress,TbaddressEntity.class);*/
        for(TbusersEntity tbusersEntity:uList) {
            System.out.println("用户名:==============" + tbusersEntity.getSusername());
        }
        if (1==2){
            return "{\"result\":\"用户注册成功\"}";
        }else {
            return "{\"result\":\"用户注册失败\"}";
        }
    }

}
