package com.profeta.cp.springbootquick.controller;

import com.profeta.cp.springbootquick.Entity.Emp;
import com.profeta.cp.springbootquick.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * create by CP on 2019/7/1 0001.
 */
@Controller
@ResponseBody
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("getemps")
    public List<Emp> getEmps() {
        return empService.getEmps();
    }

    @GetMapping("emp/{id}")
    public Emp getEmpById(@PathVariable("id") Integer id) {
        return empService.getEmpById(id);
    }

    @GetMapping("/addemp")
    public Emp addEmp(Emp emp) {
        return empService.addEmp(emp);
    }

    @GetMapping("/updateemp")
    public Emp updateEmp(Emp emp) {
        return empService.updateEmp(emp);
    }

    @GetMapping("/delemp/{id}")
    public Integer delEmpById(@PathVariable("id") Integer id) {
        return empService.delEmpById(id);
    }
}
