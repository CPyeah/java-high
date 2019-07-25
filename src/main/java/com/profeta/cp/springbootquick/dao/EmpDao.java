package com.profeta.cp.springbootquick.dao;

import com.profeta.cp.springbootquick.Entity.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * create by CP on 2019/7/3 0003.
 */
@Mapper
@Component
public interface EmpDao {

    @Select("select * from emp")
    List<Emp> getAllEmps();

    @Select("select * from emp where id=#{id}")
    Emp getEmpById(Integer id);

    @Insert("insert into emp (name, d_id) values (#{name}, #{dId})")
    @Options(keyColumn="id",keyProperty="id",useGeneratedKeys=true)
    void addEmp(Emp emp);

    @Update("update emp set name=#{name}, d_id=#{dId} where id=#{id}")
    void updateEmpById(Emp emp);

    @Delete("delete from emp where id=#{id}")
    int delEmpById(Integer id);

}
