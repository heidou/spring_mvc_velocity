package com.mengka.dao.impl;

import com.mengka.dao.ClassmatesDAO;
import com.mengka.model.ClassmatesDO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author heidou.f
 *         2016/5/11.
 */
@Service
public class ClassmatesDAOImpl extends SqlSessionDaoSupport implements ClassmatesDAO {
    @Resource
    public void setSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public ClassmatesDO selectById(Long id) {
        return getSqlSession().selectOne("ClassmatesDAO.selectById", id);
    }

    @Override
    public void insert(ClassmatesDO classmatesDO) {
        getSqlSession().insert("ClassmatesDAO.insert",classmatesDO);
    }

    @Override
    public void update(ClassmatesDO classmatesDO) {
       getSqlSession().update("ClassmatesDAO.update",classmatesDO);
    }

    @Override
    public void delete(ClassmatesDO classmatesDO) {
         getSqlSession().update("ClassmatesDAO.delete",classmatesDO);
    }
}
