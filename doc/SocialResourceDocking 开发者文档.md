---
title: SocialResourceDocking
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.20"

---

# SocialResourceDocking

Base URLs:

* <a href="http://127.0.0.1:8080">开发环境: http://127.0.0.1:8080</a>

* <a href="http://test-cn.your-api-server.com">测试环境: http://test-cn.your-api-server.com</a>

* <a href="http://prod-cn.your-api-server.com">正式环境: http://prod-cn.your-api-server.com</a>

# Authentication

# UserController

## GET userGetCurrent

GET /user/current

> 获取用户信息

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|cookie|string| 是 |Token|
|Timestamp|header|string| 是 |毫秒时间戳|

> 返回示例

> 200 Response

```json
{
  "output": "string",
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "username": "string",
    "nickname": "string",
    "email": "string",
    "telCountryArea": 0,
    "tel": "string",
    "verify": true,
    "password": "string",
    "oldPassword": "string",
    "ram": 0,
    "createdAt": "string",
    "updatedAt": "string",
    "ban": true,
    "permission": "string",
    "contactQq": "string",
    "contactWechat": "string",
    "contactOrganization": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» output|string|true|none|英文输出|进行检查|
|» code|integer|true|none|错误代码|业务类型错误代码|
|» message|string|true|none|中文解释|none|
|» data|[UserDO](#schemauserdo)|false|none|输出数据|none|
|»» id|integer|true|none|主键|none|
|»» username|string|true|none|用户名|none|
|»» nickname|string|false|none|昵称|none|
|»» email|string|true|none|邮箱|none|
|»» telCountryArea|integer|false|none|国区|none|
|»» tel|string|false|none|电话|none|
|»» verify|boolean|false|none|账号验证|none|
|»» password|string|false|none|密码|none|
|»» oldPassword|string|false|none|旧密码|none|
|»» ram|integer|true|none|子用户|不为空则为子用户|
|»» createdAt|string|true|none|创建时间|none|
|»» updatedAt|string|true|none|修改时间|none|
|»» ban|boolean|true|none|是否被封禁|none|
|»» permission|string|true|none|所属权限|none|
|»» contactQq|string|true|none|联系方式|QQ|
|»» contactWechat|string|true|none|联系方式|Wechat|
|»» contactOrganization|string|true|none|联系方式|组织、企业、学校|

## PATCH userAddPermission

PATCH /user/permission/add

> 添加用户权限

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE userDelPermission

DELETE /user/permission/remoeve

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# TokenController

## GET tokenGetCurrent

GET /token/current

> 获取令牌对应信息

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# AuthController

## GET userSignIn

GET /user/sign/in

> 用户登陆

> Body 请求参数

```json
{
  "user": "labore tempor",
  "password": "eiusmod"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Timestamp|header|string| 是 ||毫秒时间戳|
|body|body|[AuthLoginEntity](#schemaauthloginentity)| 否 | 登陆模型|none|

> 返回示例

> 200 Response

```json
{
  "output": "string",
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "username": "string",
    "nickname": "string",
    "email": "string",
    "telCountryArea": 0,
    "tel": "string",
    "verify": true,
    "password": "string",
    "oldPassword": "string",
    "ram": 0,
    "createdAt": "string",
    "updatedAt": "string",
    "ban": true,
    "permission": "string",
    "contactQq": "string",
    "contactWechat": "string",
    "contactOrganization": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» output|string|true|none|英文输出|进行检查|
|» code|integer|true|none|错误代码|业务类型错误代码|
|» message|string|true|none|中文解释|none|
|» data|[UserDO](#schemauserdo)|false|none|输出数据|none|
|»» id|integer|true|none|主键|none|
|»» username|string|true|none|用户名|none|
|»» nickname|string|false|none|昵称|none|
|»» email|string|true|none|邮箱|none|
|»» telCountryArea|integer|false|none|国区|none|
|»» tel|string|false|none|电话|none|
|»» verify|boolean|false|none|账号验证|none|
|»» password|string|false|none|密码|none|
|»» oldPassword|string|false|none|旧密码|none|
|»» ram|integer|true|none|子用户|不为空则为子用户|
|»» createdAt|string|true|none|创建时间|none|
|»» updatedAt|string|true|none|修改时间|none|
|»» ban|boolean|true|none|是否被封禁|none|
|»» permission|string|true|none|所属权限|none|
|»» contactQq|string|true|none|联系方式|QQ|
|»» contactWechat|string|true|none|联系方式|Wechat|
|»» contactOrganization|string|true|none|联系方式|组织、企业、学校|

## POST userSignUp

POST /user/sign/up

> 用户注册

> Body 请求参数

```json
{
  "username": "string",
  "email": "string",
  "tel_country": 0,
  "telephone": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|Timestamp|header|string| 是 ||毫秒时间戳|
|body|body|[AuthRegisterEntity](#schemaauthregisterentity)| 否 | 注册模型|none|

> 返回示例

> 200 Response

```json
{
  "output": "string",
  "code": 0,
  "message": "string",
  "data": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|[ResponseData](#schemaresponsedata)|

## PATCH userRamSignPassword

PATCH /user/ram/sign/password

> RAM子用户密码重置

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PATCH userSignPasswordChange

PATCH /user/sign/password/change

> 用户修改密码

> Body 请求参数

```json
{
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|中文名|说明|
|---|---|---|---|---|---|
|token|cookie|string| 是 ||Token|
|timestamp|header|string| 是 ||毫秒时间戳|
|body|body|[AuthChangePasswordEntity](#schemaauthchangepasswordentity)| 否 | 改密模型|none|

> 返回示例

> 200 Response

```json
{
  "output": "string",
  "code": 0,
  "message": "string",
  "data": {
    "id": 0,
    "username": "string",
    "nickname": "string",
    "email": "string",
    "telCountryArea": 0,
    "tel": "string",
    "verify": true,
    "password": "string",
    "oldPassword": "string",
    "ram": 0,
    "createdAt": "string",
    "updatedAt": "string",
    "ban": true,
    "permission": "string",
    "contactQq": "string",
    "contactWechat": "string",
    "contactOrganization": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» output|string|true|none|英文输出|进行检查|
|» code|integer|true|none|错误代码|业务类型错误代码|
|» message|string|true|none|中文解释|none|
|» data|[UserDO](#schemauserdo)|false|none|输出数据|none|
|»» id|integer|true|none|主键|none|
|»» username|string|true|none|用户名|none|
|»» nickname|string|false|none|昵称|none|
|»» email|string|true|none|邮箱|none|
|»» telCountryArea|integer|false|none|国区|none|
|»» tel|string|false|none|电话|none|
|»» verify|boolean|false|none|账号验证|none|
|»» password|string|false|none|密码|none|
|»» oldPassword|string|false|none|旧密码|none|
|»» ram|integer|true|none|子用户|不为空则为子用户|
|»» createdAt|string|true|none|创建时间|none|
|»» updatedAt|string|true|none|修改时间|none|
|»» ban|boolean|true|none|是否被封禁|none|
|»» permission|string|true|none|所属权限|none|
|»» contactQq|string|true|none|联系方式|QQ|
|»» contactWechat|string|true|none|联系方式|Wechat|
|»» contactOrganization|string|true|none|联系方式|组织、企业、学校|

## PATCH userSignPasswordForget

PATCH /user/sign/password/forget

> 忘记密码

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET userSignVerification

GET /user/sign/verification

> 账户校验

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET userRamSignIn

GET /user/ram/sign/in

> RAM用户登陆

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST userRamSignUp

POST /user/ram/sign/up

> 注册单个RAM用户

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE userDelete

DELETE /user/delete

> 注销用户

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE userRamDelete

DELETE /user/ram/delete

> RAM子用户注销

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST userAdminSignIn

POST /user/admin/sign/up

> 管理员注册用户

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST userAdminRamSignUp

POST /user/admin/ram/sign/up

> 管理员注册RAM用户

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# OrganizationController

## POST organizationRegister

POST /organization/register

> 组织账号注册

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET organizationGetCurrent

GET /organization/current

> 获取组织账户信息

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

<h2 id="tocS_AuthChangePasswordEntity">AuthChangePasswordEntity</h2>

<a id="schemaauthchangepasswordentity"></a>
<a id="schema_AuthChangePasswordEntity"></a>
<a id="tocSauthchangepasswordentity"></a>
<a id="tocsauthchangepasswordentity"></a>

```json
{
  "password": "string"
}

```

改密模型

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|password|string|true|none||none|

<h2 id="tocS_AuthLoginEntity">AuthLoginEntity</h2>

<a id="schemaauthloginentity"></a>
<a id="schema_AuthLoginEntity"></a>
<a id="tocSauthloginentity"></a>
<a id="tocsauthloginentity"></a>

```json
{
  "user": "string",
  "password": "string"
}

```

登陆模型

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|user|string|true|none|用户|允许使用用户名、邮箱、手机号登陆|
|password|string|true|none|密码|none|

<h2 id="tocS_UserDO">UserDO</h2>

<a id="schemauserdo"></a>
<a id="schema_UserDO"></a>
<a id="tocSuserdo"></a>
<a id="tocsuserdo"></a>

```json
{
  "id": 0,
  "username": "string",
  "nickname": "string",
  "email": "string",
  "telCountryArea": 0,
  "tel": "string",
  "verify": true,
  "password": "string",
  "oldPassword": "string",
  "ram": 0,
  "createdAt": "string",
  "updatedAt": "string",
  "ban": true,
  "permission": "string",
  "contactQq": "string",
  "contactWechat": "string",
  "contactOrganization": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|id|integer|true|none|主键|none|
|username|string|true|none|用户名|none|
|nickname|string|false|none|昵称|none|
|email|string|true|none|邮箱|none|
|telCountryArea|integer|false|none|国区|none|
|tel|string|false|none|电话|none|
|verify|boolean|false|none|账号验证|none|
|password|string|false|none|密码|none|
|oldPassword|string|false|none|旧密码|none|
|ram|integer|true|none|子用户|不为空则为子用户|
|createdAt|string|true|none|创建时间|none|
|updatedAt|string|true|none|修改时间|none|
|ban|boolean|true|none|是否被封禁|none|
|permission|string|true|none|所属权限|none|
|contactQq|string|true|none|联系方式|QQ|
|contactWechat|string|true|none|联系方式|Wechat|
|contactOrganization|string|true|none|联系方式|组织、企业、学校|

<h2 id="tocS_ResponseData">ResponseData</h2>

<a id="schemaresponsedata"></a>
<a id="schema_ResponseData"></a>
<a id="tocSresponsedata"></a>
<a id="tocsresponsedata"></a>

```json
{
  "output": "string",
  "code": 0,
  "message": "string",
  "data": "string"
}

```

通用返回

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|output|string|true|none|英文输出|进行检查|
|code|integer|true|none|错误代码|业务类型错误代码|
|message|string|true|none|中文解释|none|
|data|string|false|none||none|

<h2 id="tocS_AuthRegisterEntity">AuthRegisterEntity</h2>

<a id="schemaauthregisterentity"></a>
<a id="schema_AuthRegisterEntity"></a>
<a id="tocSauthregisterentity"></a>
<a id="tocsauthregisterentity"></a>

```json
{
  "username": "string",
  "email": "string",
  "tel_country": 0,
  "telephone": "string",
  "password": "string"
}

```

注册模型

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|username|string|true|none|用户名|支持正则表达式 ^[0-9A-Za-z-_]{3,40}$|
|email|string|true|none|邮箱|none|
|tel_country|integer|true|none|国区范围|none|
|telephone|string|true|none|手机号|none|
|password|string|true|none|密码|none|

