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

## Web开发总结
在Web开发流程中，遵守以下开发顺序
- DAO
    - table
    - entity
    - DAO接口
    - DAO实现
    - Service
    - Service接口
    - Service实现（调用DAO实现类，并控制事务）
- Controller(处理请求的Servlet)
    - [收集请求中的数据]
    - 调用业务功能（Service实现类）
    - [在相应合适的作用域中存储数据]
    - 流程跳转（forward|sendRedirect)-->*.jsp
- JSP
    - [在作用域中获取数据]
    - 使用EL+JSTL将数据嵌套在HTML标签中
- Filter
    - EncodingFilter
    - CheckFilter