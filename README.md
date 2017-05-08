# jdbc_test

jdbc之对面的女孩看过来

简介：JDBC 技术是Java开发必备的知识，并且是学习 Hibernate 和 Mybatis 的基础，
通过实例贯穿的方式，给大家一点一点的剖析 JDBC 技术，使大家由浅入深的了解 JDBC 技术的全貌，
什么是 JDBC ，怎么使用 JDBC ，为进一步学习集成框架打下良好的基础。


mysql数据库创建语句


```
CREATE TABLE god (
id int(11) NOT NULL AUTO_INCREMENT,
user_name varchar(255) NOT NULL,
sex varchar(255) DEFAULT NULL,
age int(11) DEFAULT NULL,
birthday date DEFAULT NULL,
email varchar(255) DEFAULT NULL,
mobile varchar(255) DEFAULT NULL,
create_user varchar(255) DEFAULT NULL,
create_date date DEFAULT NULL,
update_user varchar(255) DEFAULT NULL,
update_date date DEFAULT NULL,
isdel int(11) DEFAULT NULL,
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

```



