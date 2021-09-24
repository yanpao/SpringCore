# Wismap Server Rest Api Documentation
> 应用研发部    
> Version：0.0.1

## BaseManager 
> Version:1.0.6-snapshot

## `/userstatus` 登录前获取相关信息
#### `/csrf` **获取CSRF Token**
URL:`host:port/userstatus/csrf`  
Method:`GET`  
Description:根据当前客户端cookies返回Csrf Token,需开启Csrf防护功能  
Auth Required：No  
Permissions Required: No  
Parameters:-  
Success Responses:  
````json
{
    "code": 200,
    "message": "可正常登录",
    "data": "0af52c94-3a9b-4001-b2bb-760eb785ce07",
    "timestamp": 1632462358827
}
````
***
## `/kaptcha` 验证码 
> 提供图片验证码相关功能
#### `/code` **获取图片验证码**
URL:`/kaptcha/code`   
Method:`GET`  
Description:根据当前客户端cookies返回图片验证码，需开启验证码功能  
Auth Required：No  
Permissions Required: No  
Parameters:-  
Success Responses:[图片]
---
#### `/valid` **验证图片验证码**
URL:`/kaptcha/valid`   
Method:`GET`  
Description:验证用户输入的验证码是否正确  
Auth Required：No  
Permissions Required: No  
Parameters:

|Name|Type|Required|Description|
|----|----|----|----|
|code|String|true|用户输入的验证码|
Success Responses:  
````json
{
    "code": 200,
    "message": "操作成功!",
    "data": "验证码正确",
    "timestamp": 1632463712111
}
````
***
## Web App Security
> Version:0.0.1-Debug  
## `/users` 用户 
#### `/my` **获取当前登录用户信息**
URL:`/users/my`   
Method:`GET`  
Description:获取当前登录用户信息  
Auth Required：Yes  
Permissions Required: Yes  
Parameters:-
Success Responses:
````json
{
  "code": 200,
  "message": "操作成功!",
  "data": {
    "id": 1,
    "loginname": "lihanzhang",
    "localusername": "李翰章",
    "mobile": "13260648575",
    "email": "lihanzhang@outlook.com",
    "genTime": 1614686948297,
    "lastLoginTime": 1632466672360,
    "loginCount": 475,
    "img": null,
    "failCount": 0,
    "accountNonExpiredTime": null,
    "credentialsNonExpiredTime": 1646222958000,
    "enable": true
  },
  "timestamp": 1632466680980
}
````
---
#### `/my/apis` **当前用户可访问的API**
URL:`/users/my/apis`   
Method:`GET`  
Description:返回根据角色、职位、行政区划授予的用户可以访问的API  
Auth Required：Yse  
Permissions Required: Yes  
Parameters:-  
Success Responses:
````json
{
  "code": 200,
  "message": "操作成功!",
  "data": [
    {
      "id": "0244e0ea-4463-4c55-ac42-c83b23509cec",
      "url": "/users/{username}",
      "method": "DELETE",
      "apiName": null,
      "description": null,
      "sort": null,
      "resource": "/users/{username}"
    },
    {
      "id": "05d4b3ca-7bb9-4577-aaa5-87dca4ae047f",
      "url": "/users/{username}",
      "method": "GET",
      "apiName": null,
      "description": null,
      "sort": null,
      "resource": "/users/{username}"
    },
    ……
  ],
  "timestamp": 1632467397870
}
````
***
#### `/,/{username}` **查询用户**
URL:`/users/`或`/users/{username}`   
Method:`GET`  
Description:查询全部或者符合条件的用户，支持模糊查询  
Auth Required：Yes  
Permissions Required: Yes  
Parameters:

|Name|Type|Required|Description|
|----|----|----|----|
|username|String|false|用户名|
|limit|Integer|true|每页数量|
|offset|Integer|true|分页起点|
Success Responses:
````json
{
  "code": 200,
  "message": "操作成功!",
  "data": {
    "count": 13,
    "limit": 2,
    "offset": 0,
    "data": [
      {
        "id": 1,
        "loginname": "lihanzhang",
        "localusername": "李翰章",
        "mobile": "13260648575",
        "email": "lihanzhang@outlook.com",
        "genTime": 1614686948297,
        "lastLoginTime": 1632468601154,
        "loginCount": 477,
        "img": null,
        "failCount": 0,
        "accountNonExpiredTime": null,
        "credentialsNonExpiredTime": 1646222958000,
        "enable": true
      },
      ……
    ]
  },
  "timestamp": 1632468942204
}
````
***
#### `/` **新增用户**
URL:`/users`   
Method:`POST`  
Description:新增一个用户  
Auth Required：Yes  
Permissions Required: Yes  
Parameters:

|Name|Type|Required|Description|
|----|----|----|----|
|userDetails|Json|true|用户信息
Body:
````json
{
  "loginname": "zhourunfa",
  "password": "111111",
  "localusername": "周润发",
  "mobile": "13255555555",
  "email": "adasdadad@fdasd.com",
  "genTime": 1625623567568,
  "lastLoginTime": null,
  "loginCount": 0,
  "img": null,
  "failCount": 0,
  "accountNonExpiredTime": null,
  "credentialsNonExpiredTime": null,
  "enable": true
}
````
<span id="UserValidation">Validation:</span>
* loginname : 
  - NotNull
  - '^[A-Za-z0-9]+$'
  - 4-32位
* password : 
  - NotNull
  - '^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$'  
* localusername : 
  - NotNull
  - '^[\u4E00-\u9FA5A-Za-z0-9]+$'
  - 2-10位
* mobile : 
    - Null 
    - '^[0-9-]+$'
    - 8-13位
* email : 
    - 电子邮件格式检查    
    
Success Responses:
````json
{
  "code": 200,
  "message": "操作成功!",
  "data": {
    "id": 82,
    "loginname": "lishazi222",
    "localusername": "李翰章",
    "mobile": "13260648575",
    "email": "lihanzhang@outlook.com",
    "genTime": 1632472389445,
    "lastLoginTime": null,
    "loginCount": 0,
    "img": null,
    "failCount": 0,
    "accountNonExpiredTime": 1646222958000,
    "credentialsNonExpiredTime": null,
    "enable": true
  },
  "timestamp": 1632472389611
}
````
---
#### `/` **修改用户信息**
URL:`/users`   
Method:`PUT`  
Description:修改用户信息，使用put方法，没有输入的字段不会被置空  
Auth Required：Yes  
Permissions Required: Yes  
Parameters:

|Name|Type|Required|Description|
|----|----|----|----|
|userDetails|Json|true|用户信息
Body:
    [用户信息验证](#UserValidation)  
Success Responses:
````json
{
    "code": 200,
    "message": "操作成功!",
    "data": "验证码正确",
    "timestamp": 1632463712111
}
````

