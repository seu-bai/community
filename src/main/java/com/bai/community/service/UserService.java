package com.bai.community.service;

import com.bai.community.mapper.UserMapper;
import com.bai.community.model.User;
import com.bai.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Bai
 * Description: community
 * Created in 2021/03/06 15:55
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()==0){
            //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            //更新
            User updateUser=users.get(0);
            User dbUser=new User();
            dbUser.setGmtModified(user.getGmtCreate());
            dbUser.setName(user.getName());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(updateUser.getId());
            userMapper.updateByExampleSelective(dbUser,example);
        }
    }
}
