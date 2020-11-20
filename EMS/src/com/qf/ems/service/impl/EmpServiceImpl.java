package com.qf.ems.service.impl;

import com.qf.ems.dao.EmpDao;
import com.qf.ems.dao.impl.EmpDaoImpl;
import com.qf.ems.entity.Emp;
import com.qf.ems.entity.Page;
import com.qf.ems.service.EmpService;
import com.qf.ems.utils.Dbutils;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public List<Emp> showAllEmpByPage(Page page) {
        List<Emp> emps = null;
        try {
            Dbutils.begin();
            long count = empDao.selectCount();
            page.setTotalCounts((int) count);    //复制总条数，计算总页数
            emps = empDao.selectAll(page);
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollBack();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int deleteEmp(int id) {
        int result = 0;
        try {
            Dbutils.begin();
            result = empDao.delete(id);
            Dbutils.commit();
        } catch (Exception e) {
            Dbutils.rollBack();
            e.printStackTrace();
        }
        return 0;
    }
}
