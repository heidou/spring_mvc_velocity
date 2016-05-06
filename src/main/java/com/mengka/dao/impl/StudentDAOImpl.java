package com.mengka.dao.impl;

import com.mengka.dao.StudentDAO;
import com.mengka.model.StudentDO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/5/6.
 */
@Service
public class StudentDAOImpl extends SqlSessionDaoSupport implements StudentDAO {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public StudentDO selectById(Long id) {
        return getSqlSession().selectOne("StudentDAO.selectById", id);
    }
}
