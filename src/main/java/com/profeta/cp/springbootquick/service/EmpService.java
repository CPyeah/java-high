package com.profeta.cp.springbootquick.service;

import com.profeta.cp.springbootquick.Entity.Emp;
import com.profeta.cp.springbootquick.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by CP on 2019/7/1 0001.
 */
@Service
public class EmpService {

    @Autowired
    EmpDao empDao;

    @Autowired
    RedisTemplate redisTemplate;


    @Cacheable(cacheNames = "Emp", key="'allEmps'")
    public List<Emp> getEmps() {
        System.out.println("从数据库中查询所有Emp");
        return empDao.getAllEmps();
    }

    @Cacheable(cacheNames = "Emp", key = "'emp_'+#id")
    public Emp getEmpById(Integer id) {
        System.out.println("get emp : " + id);
        return empDao.getEmpById(id);
    }

    @CachePut(cacheNames = "Emp", key = "'emp_'+#result.id")
    public Emp addEmp(Emp emp) {
        System.out.println("add emp : " + emp);
        empDao.addEmp(emp);
        return emp;
    }

    @CachePut(cacheNames = "Emp", key = "'emp_'+#result.id")
    public Emp updateEmp(Emp emp) {
        System.out.println("update emp : " + emp);
        empDao.updateEmpById(emp);
        return emp;
    }

    @CacheEvict(cacheNames = "Emp" , key="'emp_'+#id")
    public Integer delEmpById(Integer id) {
        System.out.println("delete emp : " + id);
        return empDao.delEmpById(id);
    }




}
