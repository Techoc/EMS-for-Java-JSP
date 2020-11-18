package com.qf.ems.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;

public class Dbutils {
    private static DruidDataSource ds;
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
}
