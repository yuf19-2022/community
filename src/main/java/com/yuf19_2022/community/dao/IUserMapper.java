package com.yuf19_2022.community.dao;

import com.yuf19_2022.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {

    User selectById(int id);

    User selectByName(String name);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeaderUrl(int id, String headerUrl);

    int updatePassword(int id, String password);
}
