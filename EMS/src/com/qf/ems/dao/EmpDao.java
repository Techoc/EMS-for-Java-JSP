package com.qf.ems.dao;

import com.qf.ems.entity.Emp;
import com.qf.ems.entity.Page;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll(Page page);

    public long selectCount();

    public int delete(int id);
}
