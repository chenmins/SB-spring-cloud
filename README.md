### 1.eureka模块-服务注册中心
### 2.oauth2模块-认证授权服务
    *以加入自定义的响应式 登陆,授权界面 移动端,PC端已完成适配
### 3.gateway模块-网关(主要用于路由转发)
### 3.crm模块-基础服务
    * 1.用户管理
    * 2.部门管理
    * 3.菜单管理
    * 4.角色管理
    * 5.权限管理
    * 6.图表生成
        目前只支持 折线图 柱状图生成 后续会加入更多的图形功能
    * 7 服务配置
### 4.common模块
    *主要用于存放实体类,dao层模板,service层模板
### 5.modules
* Admin-Server 监控服务
* config 服务配置中心(配置信息存放在MySQL数据库中 表名称:properties)
### 功能列表


* 系统与前端的数据交互主要采用Restful Api 的方式实现 

### spring boot 版本
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.8.RELEASE</version>
![授权码登陆界面](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(4).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(5).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(6).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(2).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(1).jpg)
![](http://www.cnblogs.com/images/cnblogs_com/yangqifang/1412844/o_a1%20(3).jpg)
### 部署
* 1.安装mysql8数据库 将项目中的webdb.sql脚本文件导入到数据库中 PS:mysql其他版本没试过 我电脑上使用的是mysql 8.0.12版本
* 2.修改oauth2认证授权服务中的数据库连接地址密码
* 3.修改CRM服务中的数据库连接地址与密码 CRM服务使用的是OAUTH2协议中的password认证授权模式可以在application-test.yml文件中修改
* 4.如果发现找不到common包下的类 可以在common模块的文件目录中执行命令:mvn clean install
* 5.运行步骤 1.运行eureka注册中心 2.启动oauth2认证授权服务 3.启动CRM基础服务 4.启动gateway网关