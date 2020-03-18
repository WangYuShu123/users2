package com.wyk.dao;

import com.wyk.entity.Users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (Users)表数据库访问层
 *
 * @author zry
 * @since 2020-02-29 11:31:51
 */
public interface UsersDao extends JpaRepository<Users ,Integer>{

    Page<Users> findByNameContaining(String name , Pageable pageable);
  
}