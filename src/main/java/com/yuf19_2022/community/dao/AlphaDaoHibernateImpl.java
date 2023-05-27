package com.yuf19_2022.community.dao;

import org.springframework.stereotype.Repository;

//默认类名为首字母小写即alphaDaoHibernateImpl
@Repository(value = "alphaDaoHibernateImpl")
public class AlphaDaoHibernateImpl implements IAlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
