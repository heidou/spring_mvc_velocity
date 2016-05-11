package com.mengka.dao.impl;

import com.mengka.dao.StudentDAO;
import com.mengka.dao.WorkmateDAO;
import com.mengka.model.WorkmateDO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author heidou.f
 *         2016/5/10.
 */
@Service
public class WorkmateDAOImpl extends SqlSessionDaoSupport implements WorkmateDAO {

    @Override
    public WorkmateDO selectByIe(long id) {
        return getSqlSession().selectOne("WorkmateDAO.selectById", id);
    }

    @Override
    public void insert(WorkmateDO workmateDO) {
       getSqlSession().insert("WorkmateDAO.insert",workmateDO);
    }

    @Override
    public void update(WorkmateDO workmateDO) {
       getSqlSession().update("WorkmateDAO.update",workmateDO);
    }

    @Override
    public void delete(WorkmateDO workmateDO) {
      getSqlSession().delete("WorkmateDAO.delete",workmateDO);
    }
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
