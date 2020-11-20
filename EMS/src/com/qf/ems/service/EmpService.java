package com.qf.ems.service;

import com.qf.ems.entity.Emp;
import com.qf.ems.entity.Page;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmpByPage(Page page);

    public int deleteEmp(int id);
}
