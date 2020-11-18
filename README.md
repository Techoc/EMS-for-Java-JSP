# EMS-for-Java-JSP

来自千锋的综合jsp项目，视频地址：https://www.bilibili.com/video/BV1sK4y187jt

> 数据库名 ems

> 表名 emp
```sql
CREATE TABLE emp(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(20) NOT NULL,
salary DOUBLE NOT NULL,
age INT NOT NULL
)CHARSET=utf8;
```
> empmanager
```sql
CREATE TABLE empManager(
username VARCHAR(20)NOT NULL,
PASSWORD VARCHAR(20) NOT NULL
)CHARSET=utf8;
```