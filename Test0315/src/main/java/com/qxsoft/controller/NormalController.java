package com.qxsoft.controller;

import com.qxsoft.model.TbusersEntity;
import com.qxsoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jz128 on 2016/3/15.
 */
@Controller
public class NormalController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        List<TbusersEntity> userList=userRepository.findAll();
        modelMap.put("userList",userList);
        return "index";
    }
}
