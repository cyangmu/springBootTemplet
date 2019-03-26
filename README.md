# springboot+mybatis-plus 分页展示

1. mybatis-plus生成main方法在utils包

2. mybatisx是IDEA的快速开发插件
[Mybatis-plus官网](http://baomidou.oschina.io/mybatis-plus-doc/#/)
   1. 官方安装： File -> Settings -> Plugins -> Browse Repositories.. 输入 mybatisx 安装下载
   2. 支持java xml 调回跳转，mapper 方法自动生成 xml

原始分页数据返回样式：
```
{
    "total": 59,
    "size": 10,
    "current": 1,
    "records": [
        {
            "id": 11,
            "code": "250",
            "businessType": 0,
            "activityType": 0,
            "businessName": "",
            "businessTel": null,
            "attentionCount": 1,
            "cancelCount": 1,
            "winningCount": 0,
            "showStatus": 1,
            "gmtCreate": "2017-10-12T16:00:00.000+0000",
            "gmtModify": "2017-11-08T16:00:00.000+0000"
        }
    ],
    "pages": 6
}
可自定义分页返回样式
```

----------


## 各层命名规范：
1. Service / DAO 层方法命名规约   
   1. 获取单个对象的方法用 get 做前缀。
   2. 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。
   3. 获取统计值的方法用 count 做前缀。
   4. 插入的方法用 save/insert 做前缀。
   5. 删除的方法用 remove/delete 做前缀。
   6. 修改的方法用 update 做前缀。
2. 领域模型命名规约
   1. 数据对象： xxxDO ， xxx 即为数据表名。
   2. 数据传输对象： xxxDTO ， xxx 为业务领域相关的名称。
   3. 展示对象： xxxVO ， xxx 一般为网页名称。
   4. POJO 是 DO / DTO / BO / VO 的统称，禁止命名成 xxxPOJO 。




## Restful风格命名规范：
HTTP动词 | 接口作用 | 安全性(是否改变状态) | 幂等性(请求1~N次)
:---|:---|:---|:---
GET      |获取     |✔   |✔
POST     |创建     |✘   |✘
PUT      |更新     |✘   |✔
PATCH    |部分更新  |✘   |✔
DELETE   |删除     |✘   |✔

