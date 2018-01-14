# mybatis_spring

### 项目说明：

本项目整合了spring和mybatis，所有配置文档化，用作自己的项目小仓库。

mybatis 整合了逆向工程，通过maven进行导入
整合了通用模板类，使得代码大量减少，后续将整合ssm全部框架
整合了分页功能
config.properties 包含了大部分设置 在这里修改你的数据库配置
pojo 和 mapper 包可以直接删除
配置好数据库连接后 在generatorConfig.xml中修改config（行6）的绝对路径和要自动生成的表名（行64）
在maven project中找到mybatis-generator，运行，即可生成。
在test中进行测试，熟悉mybatis的使用
