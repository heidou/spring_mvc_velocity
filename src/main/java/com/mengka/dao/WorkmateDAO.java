package com.mengka.dao;

import com.mengka.model.WorkmateDO;

/**
 * @author heidou.f
 *         2016/5/10.
 */
public interface WorkmateDAO {
    WorkmateDO selectByIe(long id);
    void insert(WorkmateDO workmateDO);
    void update(WorkmateDO workmateDO);
    void delect(WorkmateDO workmateDO);
}
