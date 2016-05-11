package com.mengka.dao;

import com.mengka.model.ClassmatesDO;

/**
 * @author heidou.f
 *         2016/5/11.
 */
public interface ClassmatesDAO{
    ClassmatesDO selectById(Long id);
    void insert(ClassmatesDO classmatesDO);
    void update(ClassmatesDO classmatesDO);
    void delete(ClassmatesDO classmatesDO);
}
