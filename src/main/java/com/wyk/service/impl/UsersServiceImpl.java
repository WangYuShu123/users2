package com.wyk.service.impl;

import com.wyk.entity.Users;
import com.wyk.dao.UsersDao;
import com.wyk.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.data.domain.Page;
/**
 * (Users)表服务实现类
 *
 * @author wyk
 * @since 2020-02-29 11:31:51
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public Users queryById(Integer id) {
        return this.usersDao.getOne(id);
    }

    @Override
    public List<Users> getall() {
        return this.usersDao.findAll();

    }

    @Override
    public Page<Users> page(Users users, int index, int roew) {
        return usersDao.findByNameContaining( users.getName()==null?"":users.getName(),PageRequest.of((index-1)
                ,roew));
    }


    @Override
    public Page<Users> queryAllByLimit(int offset, int limit) {
        return this.usersDao.findAll(PageRequest.of((offset-1)
,limit));
    }

    @Override
    public Users insert(Users users) {
       
        return this.usersDao.save(users);
    }


    @Override
    public Users update(Users users) {
       
        return this.usersDao.save(users);
    }

  
    @Override
    public boolean deleteById(Integer id) {
    
     try{
             this.usersDao.deleteById(id) ;
        }catch (Exception ex){
            return false;
        }
        return true;
      
    }
}