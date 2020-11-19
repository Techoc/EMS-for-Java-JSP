package com.qf.ems.dao.impl;

import com.qf.ems.dao.EmpManagerDao;
import com.qf.ems.entity.EmpManager;
import com.qf.ems.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDaoImpl implements EmpManagerDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public EmpManager select(String username) {
        try {
            EmpManager empManager = queryRunner.query(
                    Dbutils.getConnection(),
                    "select * from empManager where username=?;",
                    new BeanHandler<EmpManager>(EmpManager.class),
                    username
            );
            return empManager;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
