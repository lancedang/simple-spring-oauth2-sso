## simple-spring-oauth2-sso
这是一个简单的演示项目，使用spring security搭建oauth2服务器，并为两个应用实现sso单点登录。附加一个使用http basic认证的演示项目。

## 环境准备

本项目的构建和运行需要JDK7和Maven3。

## 项目结构

整个项目目录结构如下，

```
- pom.xml 整个Maven项目的pom文件，这是演示项目的根目录
+ auth-server
  - pom.xml
  + src
    + main/java/com/pphh/demo
      - AuthServer.java  OAuth2授权服务器
      - AuthServerConfig.java
+ demo1
  - pom.xml
  + src
    + main/java/com/pphh/demo
      - Demo1Application.java  演示1，演示单点登录
+ demo2
  - pom.xml
  + src
    + main/java/com/pphh/demo
      - Demo2Application.java  演示2，演示单点登录
+ demo-basic
  - pom.xml
  + src
    + main/java/com/pphh/demo
      - DemoBasicApplication.java  演示3，演示http basic登录
      - BasicSecurityConfig.java
```

整个项目包含4个子项目，每个子项目都是一个spring boot应用。

## 项目构建

执行如下命令，对项目编译打包，
``` bash
mvn clean package
```

## 演示步骤
1. 分别启动启动Auth-Server, Demo1, Demo2和DemoBasic四个应用程序
   - Auth-Server：提供OAuth2授权服务，启动后在端口9000
   - Demo1：演示应用1，启动后在端口9100
   - Demo2：演示应用2，启动后在端口9200
   - DemoBasic：演示应用3，启动后在端口9300

   注意的是，演示1和演示2在运行时依赖Auth-Server的接口服务，所以需要先启动授权服务器，否则会报无法获取sign-key的错误消息。

   ```
   org.springframework.web.client.ResourceAccessException:
   I/O error on GET request for "http://127.0.0.1:9000/oauth/token_key":
   Connection refused: connect;
   ```

   演示应用3可以独立运行。

2. 演示单点登录 - 演示1
   - 打开浏览器，访问应用地址：http://localhost:9100/demo1
   - 浏览器跳转到http://127.0.0.1:9000/oauth/authorize页面，请求登录和授权
   - 在授权服务器页面，输入用户名sso和密码123456。然后点击"Authorize"按钮，确认授权。
   - 浏览器跳转回演示应用1，这时已经登录成功。
   - 查看hello接口 - http://127.0.0.1:9100/demo1/hello
   - 查看当前登录用户信息 - http://127.0.0.1:9100/demo1/me

3. 演示单点登录 - 演示2
   - 打开浏览器，访问应用地址：http://localhost:9200/demo2
   - 浏览器跳转到http://127.0.0.1:9000/oauth/authorize页面，请求授权
   - 在授权服务器页面，点击"Authorize"按钮，确认授权。
   - 浏览器跳转回演示应用2，这时已经登录成功。
   - 查看hello接口 - http://127.0.0.1:9200/demo2/hello
   - 查看当前登录用户信息 - http://127.0.0.1:9200/demo2/me
   - 可以看到，在演示2中，并不需要用户再次输入用户名和密码。这是因为在演示1中，已经在授权服务器登录过。

3. 演示简单的http basic登录
   - 打开浏览器，访问应用地址：http://localhost:9300/demo3
   - 浏览器跳转到http://localhost:9300/demo3/login页面，请求用户登录。
   - 输入用户名sso和密码123456，点击登录。
   - 浏览器跳转回演示应用3的首页，这时已经登录成功。
   - 查看hello接口 - http://127.0.0.1:9300/demo3/hello
   - 查看当前登录用户信息 - http://127.0.0.1:9300/demo3/me

## 开源许可协议 License
Apache License 2.0