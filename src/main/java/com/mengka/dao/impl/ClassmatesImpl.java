package com.mengka.dao.impl;

import com.mengka.dao.ClassmatesDAO;
import com.mengka.model.ClassmatesDO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author heidou.f
 *         2016/5/11.
 */
@Service("classmatesDAO")
public class ClassmatesImpl extends SqlSessionDaoSupport implements ClassmatesDAO{



    @Override
    public ClassmatesDO selectById(long id) {
          return getSqlSession().selectOne("ClassmatesDAO.selectById", id);
    }

    @Override
    public List<ClassmatesDO> selectByName(String name) {
       return getSqlSession().selectList("ClassmatesDAO.selectByName",name);
    }

    @Override
    public List<ClassmatesDO> selectByAge(String age) {
        return getSqlSession().selectList("ClassmatesDAO.selectByAge",age);
    }

    @Override
    public void insert(ClassmatesDO classmatesDO) {
        getSqlSession().insert("ClassmatesDAO.insert",classmatesDO);
    }

    @Override
    public void update(ClassmatesDO classmatesDO) {
        getSqlSession().update("Classmates.update",classmatesDO);
    }

    @Override
    public void delete(ClassmatesDO classmatesDO) {
        getSqlSession().delete("Classmates.delete",classmatesDO);
    }

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
