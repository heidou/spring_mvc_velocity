package com.mengka.dao;

import com.mengka.model.StudentDO;

/**
 * Created by Administrator on 2016/5/6.
 */
public interface StudentDAO {

    StudentDO selectById(Long id);
}
