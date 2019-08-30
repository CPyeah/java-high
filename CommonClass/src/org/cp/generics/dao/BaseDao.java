package org.cp.generics.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * create by CP on 2019/8/30 0030.
 */
public class BaseDao<T> {

    public List<T>  getAll(String tableName) {
        return new ArrayList<T>();
    }

    public T getById(Long id, String tableName) {
        return (T) new Object();
    }

    public void add(T item, String tableName) {

    }



}
