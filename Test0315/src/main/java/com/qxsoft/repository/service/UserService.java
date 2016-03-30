package com.qxsoft.repository.service;

import com.qxsoft.model.TbaddressEntity;
import com.qxsoft.model.TbusersEntity;

import java.util.List;

/**
 * Created by jz128 on 2016/3/18.
 */
public interface UserService {
    /**
     * 用户登陆验证
     * @param tbusersEntity
     * @return
     */
    TbusersEntity userLogIn(TbusersEntity tbusersEntity);
    /**
     * 注册时确认用户名是否已被注册,true:可用,false:已注册
     * @param susername
     * @return
     */
    boolean getUserNameRepeat(String susername);
    /**
     * 用户注册
     * @param tbusersEntity
     * @return
     */
    boolean userRegist(TbusersEntity tbusersEntity,TbaddressEntity adrs);
    /**
     * 获取所有用户信息
     * @return
     */
    List<TbusersEntity> findAllUsers();
}
