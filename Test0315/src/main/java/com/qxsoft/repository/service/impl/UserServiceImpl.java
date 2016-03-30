package com.qxsoft.repository.service.impl;

import com.qxsoft.model.TbaddressEntity;
import com.qxsoft.model.TbusersEntity;
import com.qxsoft.repository.dao.UserDao;
import com.qxsoft.repository.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jz128 on 2016/3/18.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name="userDaoImpl")
    UserDao userDao;

    /**
     * 用户登陆验证
     * @param tbusersEntity
     * @return
     */
    public TbusersEntity userLogIn(TbusersEntity tbusersEntity) {
        return userDao.userLogIn(tbusersEntity);
    }
    /**
     * 注册时确认用户名是否已被注册,true:可用,false:已注册
     * @param susername
     * @return
     */
    public boolean getUserNameRepeat(String susername){
        return userDao.getUserNameRepeat(susername);
    }
    /**
     * 用户注册
     * @param tbusersEntity
     * @return
     */
    public boolean userRegist(TbusersEntity tbusersEntity,TbaddressEntity adrs){
        return userDao.userRegist(tbusersEntity, adrs);
    }
    /**
     * 获取所有用户信息
     * @return
     */
    public List<TbusersEntity> findAllUsers() {
        return userDao.findAllUsers();
    }
}
