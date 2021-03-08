### 简易版论坛
参考视频：https://www.bilibili.com/video/BV1r4411r7au

网站原版：https://elasticsearch.cn/

修改数据库表运行以下命令：
   mvn flyway:migrate
需要重新生成mapper时
   先修改配置，再运行
   mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

