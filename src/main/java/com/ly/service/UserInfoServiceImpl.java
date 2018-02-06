package com.ly.service;

import com.ly.bean.UserInfo;
import com.ly.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryOne(UserInfo record) {
        return null;
    }

    @Override
    public List<UserInfo> queryAll(UserInfo record) {
        return null;
    }

    @Override
    public int queryCount(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(UserInfo record) {
        return 0;
    }

    @Override
    public int addSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public int delete(UserInfo record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return 0;
    }

    @Override
    public int queryCountByExample(UserInfo example) {
        return 0;
    }

    @Override
    public List<UserInfo> queryByExample(UserInfo example) {
        return null;
    }

    @Override
    public UserInfo queryByAccount(String account) {
        Example ex = new Example(UserInfo.class);
        ex.createCriteria().andCondition(" user_account='"+account+"'")
        .andCondition(" is_use="+1);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(ex);
        if(userInfos != null && userInfos.size() > 0){
            return userInfos.get(0);
        }
        return null;
    }

    @Override
    public UserInfo queryByAccountAndPassword(String account, String password) {
        Example ex = new Example(UserInfo.class);
        ex.createCriteria().andCondition(" user_account= '"+account+"'")
                .andCondition(" is_use="+1)
        .andCondition(" password='"+password+"'");
        List<UserInfo> userInfos = userInfoMapper.selectByExample(ex);
        if(userInfos != null && userInfos.size() > 0){
            return userInfos.get(0);
        }
        return null;
    }
}
