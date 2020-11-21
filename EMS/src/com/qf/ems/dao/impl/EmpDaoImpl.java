package com.qf.ems.dao.impl;

import com.qf.ems.dao.EmpDao;
import com.qf.ems.entity.Emp;
import com.qf.ems.entity.Page;
import com.qf.ems.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Emp> selectAll(Page page) {
        try {
            List<Emp> emps = queryRunner.query(
                    Dbutils.getConnection(),
                    "select * from emp limit ?, ?;",
                    new BeanListHandler<Emp>(Emp.class),
                    page.getStartRows(),
                    page.getPageSize()
            );
            return emps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            long count = queryRunner.query(
                    Dbutils.getConnection(),
                    "select count(*) from emp;",
                    new ScalarHandler<>()
            );
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(
                    Dbutils.getConnection(),
                    "delete from emp where id=?;",
                    id
            );
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public int insert(Emp emp) {
        try {
            int result =  queryRunner.update(
                    Dbutils.getConnection(),
                    "insert into emp(name,salary,age) values (?,?,?)",
                    emp.getName(),
                    emp.getSalary(),
                    emp.getAge()
            );
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(int id) {
        try {
            Emp emp = queryRunner.query(
                    Dbutils.getConnection(),
                    "select * from emp where id=?;",
                    new BeanHandler<Emp>(Emp.class),
                    id
            );
            return emp;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Emp emp) {
        try {
            int result = queryRunner.update(
                    Dbutils.getConnection(),
                    "update emp set name=?,salary=?,age=? where id=?;",
                    emp.getName(),
                    emp.getSalary(),
                    emp.getAge(),
                    emp.getId()
            );
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
