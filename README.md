人脸识别系统
**备注：**

**数据库密码为：123456root**

**连接地址: cdb-67p38xpq.cd.tencentcdb.com:10004**

**数据库名为:frecognition**

## 一、数据库设计(frecognition)

#### 用户表(user)

|      字段名      |   数据类型   |       字段说明       |       备注       |
| :--------------: | :----------: | :------------------: | :--------------: |
|     user_id      |   int(10)    |       用户表ID       | 主键,自增,无符号 |
|    user_name     | varchar(100) |       用户姓名       |                  |
|    user_card     | varchar(40)  |     用户身份证号     |                  |
|    user_phone    | varchar(40)  |       用户电话       |                  |
|   user_account   | varchar(40)  |       用户账号       |                  |
|  user_password   | varchar(40)  |       用户密码       |                  |
|    user_role     |  varchar(4)  |       用户角色       |                  |
| user_recognition |   int(10)    | 用户人脸识别属性表ID |                  |

#### 图片存储表(picture_storage)

(将图片文件和视频流文件分开存储，且适当的增加用户ID的数据冗余，方便快速检索)

|       字段名       |   数据类型   |    字段说明    | 备注 |
| :----------------: | :----------: | :------------: | :--: |
| picture_storage_id |   int(10)    |  图片存储表ID  | 主键 |
|      user_id       |   int(10)    |     用户ID     |      |
|    picture_url     | varchar(100) |    图片URL     |      |
|      base_url      | varchar(100) | 文件服务器路径 |      |
|    picture_name    | varchar(100) |     图片名     |      |
|   picture_style    | varchar(100) |    文件类型    |      |
|     creat_time     |   datatime   |    创建时间    |      |
|    picture_size    | varchar(100) |    文件大小    |      |

#### 文件(视频文件)存储表(file_storage)

|     字段名      |   数据类型   |    字段说明     | 备注 |
| :-------------: | :----------: | :-------------: | :--: |
| file_storage_id |   int(10)    |  文件存储表ID   | 主键 |
|     user_id     |   int(10)    |     用户ID      |      |
|    file_url     | varchar(100) | 文件存储路径URL |      |
|    base_url     | varchar(100) | 文件服务器路径  |      |
|    file_name    | varchar(100) |     文件名      |      |
|   file_style    | varchar(100) |    文件类型     |      |
|   creat_time    |   datetime   |    创建时间     |      |
|    file_size    | varchar(100) |    文件大小     |      |

#### 图片/文件上传记录(upload_record)

|      字段名      | 数据类型 |       字段说明        |     备注      |
| :--------------: | :------: | :-------------------: | :-----------: |
|  file_upload_id  | int(10)  | 图片/文件上创建记录ID |     主键      |
| file_storage_id  | int(10)  |       存储表ID        |               |
|     user_id      | int(10)  |        用户ID         |               |
| file_upload_time | datatime |   图片/文件上传时间   |               |
|    file_style    |  int(2)  |     上传文件类型      | 0:图片;1:文件 |

#### 用户人脸识别属性（recognition）

|        字段名        |   数据类型   |       字段说明        |     备注     |
| :------------------: | :----------: | :-------------------: | :----------: |
|       user_id        |   int(10)    |        用户ID         |              |
| user_recognition_id  |   int(10)    |  用户人脸识别属性ID   |              |
|   recognition_url    | varchar(100) | 用户人脸图片url(默认) |              |
| recognition_url_list | varchar(400) |    用户人脸图片ID     | List格式存储 |
|     other_param      |   int(10)    |   用户人脸属性表ID    |              |
|     create_time      |   datatime   |     图片上传时间      |              |


## 二、技术选型

|        类型        |  技术名称  | 参考网站 | 备注 |
| :----------------: | :--------: | :------: | :--: |
| 数据库操作自动生成 | tx.mybatis |          |      |
|  常用的java工具类  |   Hutool   |          |      |
|   前端文件上传类   |            |          |      |

```java
 通用mapper的使用(添加条件操作)
     
 Example userExample=new Example(User.class);
 Example.Criteria userCriteria = userExample.createCriteria();
 userCriteria.andEqualTo("userName",userName);
 User result=userMapper.selectOneByExample(userExample);
```

