package com.qxsoft.repository;

import com.qxsoft.model.TbusersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jz128 on 2016/3/16.
 */
@Repository
public interface UserRepository extends JpaRepository<TbusersEntity,Integer>{
    
}
