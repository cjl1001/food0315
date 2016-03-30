package com.qxsoft.repository.dao.impl;

import com.qxsoft.model.TbaddressEntity;
import com.qxsoft.model.TbusersEntity;
import com.qxsoft.repository.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by jz128 on 2016/3/18.
 */
@SuppressWarnings({"unchecked", "rawtypes"})//去除警告
@Repository("userDaoImpl")
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;

    /**
     * 用户登陆验证
     *
     * @param tbusersEntity
     * @return
     */
    public TbusersEntity userLogIn(TbusersEntity tbusersEntity) {
        String hql = "from TbusersEntity us where us.susername=? and us.spassword=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, tbusersEntity.getSusername());
        query.setString(1, tbusersEntity.getSpassword());
        List<TbusersEntity> list = (List<TbusersEntity>) query.list();
        TbusersEntity user = null;
        if (list != null && list.size() == 1) {
            user = list.get(0);
        }
        return user;
    }

    /**
     * 注册时确认用户名是否已被注册,true:可用,false:已注册
     *
     * @param susername
     * @return
     */
    public boolean getUserNameRepeat(String susername) {
        boolean flag = true;
        String hql = "select count(*) from TbusersEntity us where us.susername=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, susername);
        int num = Integer.parseInt(query.uniqueResult().toString());
        if (num > 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * 用户注册(同时在TbaddressEntity表中添加一条数据)
     *
     * @param tbusersEntity
     * @return
     */
    @Transactional
    public boolean userRegist(TbusersEntity tbusersEntity,TbaddressEntity adrs) {
        boolean flag = true;
        try {
            tbusersEntity.setDcreatdate(new Date());
            tbusersEntity.setIuserpoint(0);
            tbusersEntity.setMcostmoney(0d);
            sessionFactory.getCurrentSession().save(tbusersEntity);
            Criteria crt=sessionFactory.getCurrentSession().createCriteria(TbusersEntity.class);
            crt.add(Restrictions.eq("susername",tbusersEntity.getSusername()));
            crt.add(Restrictions.eq("spassword",tbusersEntity.getSpassword()));
            List<TbusersEntity> ulist=crt.list();
            if(ulist==null || ulist.size()==0){
                throw new RuntimeException();
            }else {
                TbusersEntity user = ulist.get(0);
                adrs.setUserByUid(user);
                sessionFactory.getCurrentSession().save(adrs);
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取所有用户信息
     *
     * @return
     */
    public List<TbusersEntity> findAllUsers() {
        String hql = "from TbusersEntity";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return (List<TbusersEntity>) query.list();
    }
}
