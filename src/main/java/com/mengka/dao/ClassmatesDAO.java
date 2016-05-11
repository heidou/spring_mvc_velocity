package com.mengka.dao;

import com.mengka.model.ClassmatesDO;

import java.util.List;

/**
 * @author heidou.f
 *         2016/5/11.
 */
public interface ClassmatesDAO{
    ClassmatesDO selectById(long id);

    List<ClassmatesDO> selectByName(String name);

    List<ClassmatesDO> selectByAge(String age);

    void insert(ClassmatesDO classmatesDO);
    void update(ClassmatesDO classmatesDO);
    void delete(ClassmatesDO classmatesDO);
}
