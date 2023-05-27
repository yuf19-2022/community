package com.yuf19_2022.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMyBatisImpl implements IAlphaDao {
    @Override
    public String select() {
        return "MyBatis";
    }
}
