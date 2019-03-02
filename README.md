# easyrest

#### 介绍

easyrest 是一个由数据驱动自动化接口测试框架，
可以自动执行并生成报告。
自动化测试技术交流QQ群：31043004
###近期更新（暂未发布）
- 1、接口Session 和Cookies 自动延续 到下一个接口可用 只需登录一次
- 2、后期如更换账号清除Session 和Cookies 配置ExecutionData.cleanCoockie=true
###计划增加功能
-  1、支持${Request.Headers.参数名}引用变量。
-  2、支持Xml验证、正则表达式验证方式。
-  3、支持测试数据记录到Mysql 可配置是否写入。
### 能力有限 水平一般 欢迎批评指正 PR
maven坐标
```
<dependency>
    <groupId>com.github.379753498</groupId>
    <artifactId>EasyRest</artifactId>
    <version>1.3.0</version>
</dependency>
```


#### 测试报告效果
![报告效果图1](https://images.gitee.com/uploads/images/2018/1223/205752_f9b01490_963880.png "ps1.png")
![报告效果图2](https://images.gitee.com/uploads/images/2018/1223/205828_71952b83_963880.png "ps2.png")
![报告效果图3](https://images.gitee.com/uploads/images/2018/1223/205844_812c4707_963880.png "ps3.png")
![报告效果图4](https://images.gitee.com/uploads/images/2018/1223/205901_d9795a69_963880.png "ps4.png")
#### 软件架构

软件架构说明
![架构图](https://images.gitee.com/uploads/images/2018/1222/005032_565f5cfc_963880.png "core.png")



#### 安装教程

若您想将功能集成到您的项目中，可引用maven依赖使用核心jar以便于快速使用该框架，

- 其中与SpirngBoot整合项目在https://gitee.com/testdevops/easyrest/tree/master/SpringBootDemo
- 其中与Spirng整合项目在https://gitee.com/testdevops/easyrest/tree/master/SpringDemo
- 其中与普通Maven项目在https://gitee.com/testdevops/easyrest/tree/master/MavenProjectDemo
  ``

```
<dependency>
    <groupId>com.github.379753498</groupId>
    <artifactId>EasyRest</artifactId>
    <version>1.3.0</version>
</dependency>
```

若您想详细了解框架如何运行的细节您可以这样做

1. 配置Java1.8、maven3.5.4环境、ecplise Idea 需安装插件 lombok、TestNg插件
2. 下载代码
3. 修改src/main/resources/ExcelData.xlsx中数据
4. 执行src/test/java/com/testpro/easyrest/EasyrestApplicationTests.java即可运行
5. 若想查看Alure报告 首先解压easyrest/src/test/resources/allure-2.7.0.zip到D:\盘根目录(随意哪里)
   - 环境变量Path中加入D:\allure-2.7.0\allure-2.7.0\bin;
   - 参考运行方式2执行  mvn test命令后
   - CMD命令行切换至项目根目录执行allure serve target/allure-results 此时浏览器就会自动打开执行后的报告；例如项目路径F:\WORKDEV\easyrest
   - 也可以在idea中的Terminal中执行allure serve target/allure-results 

#### 使用说明

1. ExcelData.excel填写规范

   - 用例名称：{字符串、无长度限制，非必填项}
   - 用例描述：{字符串、无长度限制，推荐填写}
   - 地址：{字符串、有长度限制取决于Get规范，必须填写}

    支持写法1、填写全url路径 例如http://www.baidu.com/hello

    支持写法2、填写请求路径/hello，此种写法需要在src/main/resources/application.properties中补充属性easyrest.restassured.baseurl=http://www.baidu.com

   - 头信息:{Json字符串、无长度限制，非必填项}
   - 参数：{Json字符串、有长度限制取决于Get规范，非必填项}
   - 方法：{字符串、暂只支持get/post，必填项}
   - 返回值类型:{字符串、json，必填项}
   - 返回值校验:{Json字符串、无长度限制，非必填项}
   - jsonPath校验：{Json字符串、无长度限制，非必填项}

    此处Key需满足jsonpath语法 https://testerhome.com/topics/6672

   - 字符包含校验:{字符串、无长度限制，非必填项，分隔符为英文 , }

2. 运行方式

   - 执行src/test/java/com/testpro/easyrest/EasyrestApplicationTests.java即可运行
   - 执行maven 命令 mvn test（不懂如何执行请及时百度）

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
新增需求：
接口依赖问题 B接口依赖A接口返回的某项数据进行依赖
解决思路： 设计依赖接口数据关系及数据格式 自动进行封装填充A response 返回值到B request 对应位置中去
实现考虑使用拦截器