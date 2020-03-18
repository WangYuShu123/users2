package com.wyk.service;

import com.wyk.entity.Users;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Users)表服务接口
 *
 * @author zry
 * @since 2020-02-29 11:31:51
 */
public interface UsersService {
    Users queryById(Integer id);
    Page<Users> queryAllByLimit(int offset, int limit);
    Users insert(Users users);
    Users update(Users users);
    boolean deleteById(Integer id);
     List<Users> getall();
     Page<Users> page(Users users,int index,int roew);
}