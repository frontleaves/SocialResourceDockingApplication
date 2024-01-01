# SocialResourceDocking 开发者

<div align="right">Author 筱锋xiao_lfeng | Version: V1.0.0</div>

## 功能简介

![](https://i-cdn.akass.cn/2023/12/6590ef4dc968c.png!wp60)

> 该系统由四个核心组成部分构成：登录模块、功能模块、数据交换、页面展示
> 登录部件：确保用户安全接入系统
> 功能模块：分为政府类、企业类、社区类、其他类，主要用于打破大学生与社会的信息差，方便各类社会组织和大学生双向上传需求：例如义工服务、创新创业合作、行业培训、社会实践、公益活动等，以此来满足双方的需求。
> 数据交换：保证信息流在系统内部和外部各实体间的高效、安全传输
> 界面展示：优化了用户体验，使得信息查阅和管理清晰、直观。

本项目旨在构建一款综合性系统，通过四个核心部分的协同工作，实现政府、企业、社区与大学生之间的信息共享与合作。通过该系统，大学生可以更便捷地参与各类社会活动，获得创新创业机会，完成行业培训，参与社会实践和公益活动。同时，各社会组织也能更轻松地找到合适的大学生资源，促进双向合作，打破信息壁垒，实现资源的共享和优化。通过数据交换保障信息的高效安全传输，通过优化界面展示提高用户体验，本项目旨在为大学生和社会组织提供一个便捷、高效、安全的合作平台。

### 概要描述

本系统服务的客户群体涵盖学生、老师、企业、政府相关部门以及各类机构。系统功能主要以双向参与为特点，为学生提供多方位支持。对政府而言，系统可用于社会实践和义工服务，帮助招募志愿者，并推送文章和政策解读以培养青年思想。对企业，系统支持创新创业合作，提供悬赏解决方案，申请孵化和资金支持，以及进行行业培训和职业发展。生态环保与可持续发展方面，企业可发布成果并征求解决方案。系统还服务社区，支持公益活动和各类文艺活动。其他主体如医疗结构和培训机构可通过平台宣讲知识、技能并发布相关服务。系统的多功能性旨在促进各方合作、交流与发展。

### 特点描述

本系统的显著特点在于其多功能性和双向参与机制。首先，系统通过覆盖学生、老师、企业、政府和各类机构等广泛客户群体，构建了一个全方位的服务平台。其次，系统支持政府举办社会实践和义工服务活动，同时提供文章推送和政策解读，以培养青年思想，将个人发展与国家命运紧密联系。对企业而言，系统不仅提供创新创业合作平台，还支持行业培训和职业发展，促使学生更好地理解实际岗位需求。生态环保与可持续发展方面，企业可以在平台上发布成果并吸引学生参与创新思考。此外，系统服务社区，鼓励学生参与公益和文艺活动，强化社区凝聚力。最后，系统还对其他主体如医疗结构和培训机构提供宣讲知识、技能的机会，实现全方位的社会资源对接。这一综合性的特点使得系统成为一个有力的创新与合作平台，为各方搭建交流桥梁，推动社会各领域的共同发展。

### 架构说明

> 根据提供功能模块叙述，将上述模块进行划分，可主要划分为如下模块

- 招募模块
- 文章模块
- 题解模块
- 孵化模块
- 交友模块
- 活动模块
- 服务模块
- 交易模块

![](https://i-cdn.akass.cn/2023/12/659022ba205f2.jpg!wp60)



## 数据库架构设计

### 数据表组织

![exported_from_idea](https://i-cdn.akass.cn/2024/01/65925b1189b20.jpg!wp60)

### 数据表设计

```mysql
-- 用户数据表
-- srd_user
create table srd_user
(
    id                bigint unsigned auto_increment comment '用户主键'
        primary key,
    username          varchar(40)                          not null comment '用户名',
    nickname          varchar(20)                          null comment '昵称',
    email             varchar(50)                          not null comment '邮箱',
    tel_country_area  int        default 86                not null comment '电话所属国区',
    tel               varchar(20)                          not null comment '电话号码',
    verify            tinyint(1) default 0                 not null comment '用户是否校验',
    password          varchar(100)                         not null comment '密码',
    old_password      varchar(100)                         null comment '旧密码',
    created_at        timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at        timestamp                            null comment '信息修改时间',
    ban               tinyint(1) default 0                 not null comment '是否被封禁',
    permission        json                                 null comment '权限组',
    contact_qq        varchar(15)                          null comment 'qq号',
    contact_wechat    varchar(30)                          null comment '微信号',
    organization_type tinyint unsigned                     null comment '其他/学校/政府/企业/组织',
    organization_list bigint unsigned                      not null comment '所属列表',
    constraint srd_user_email_uindex
        unique (email),
    constraint srd_user_username_uindex
        unique (username)
)
    comment '用户数据表';
```

```mysql
-- RAM用户
-- srd_user_ram
create table srd_user_ram
(
    id               bigint unsigned auto_increment comment '主键'
        primary key,
    user_id          bigint unsigned                      not null comment '主用户ID',
    username         varchar(40)                          not null comment '用户名',
    nickname         varchar(20)                          null comment '昵称',
    email            varchar(50)                          not null comment '邮箱',
    tel_country_area int        default 86                not null comment '电话国家区号',
    tel              varchar(20)                          not null comment '电话',
    password         varchar(100)                         not null comment '密码',
    created_at       timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at       timestamp                            null comment '更新时间',
    ban              tinyint(1) default 0                 not null comment '是否禁用',
    permission       json                                 null comment '权限组',
    contact_qq       varchar(15)                          null comment '联系QQ',
    contact_wechat   varchar(30)                          null comment '联系微信',
    constraint srd_user_ram_email_uindex
        unique (email),
    constraint srd_user_ram_username_uindex
        unique (username),
    constraint srd_user_ram_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete cascade
);
```

```mysql
-- 用户Token
-- srd_user_token
create table srd_user_token
(
    id         bigint unsigned auto_increment comment '令牌主键'
        primary key,
    user_type  tinyint(1) default 0 not null comment '用户类型',
    user_id    bigint unsigned      not null comment '用户id',
    token      varchar(50)          not null comment '令牌',
    expired_at timestamp            not null comment '过期时间',
    created_at timestamp            not null comment '创建时间',
    ip         varchar(45)          null comment 'IP地址',
    user_agent varchar(255)         null comment '用户UA'
)
    comment '用户Token';
```

```mysql
-- 学校类型
-- srd_resources_school_type
create table srd_resources_school_type
(
    id         int unsigned auto_increment comment '学校类型主键'
        primary key,
    name       varchar(100) not null comment '类型名字',
    created_at timestamp    not null comment '创建时间',
    updated_at timestamp    not null comment '修改时间'
)
    comment '学校类型';
```

```mysql
-- 学校数据库
-- srd_resources_school
create table srd_resources_school
(
    id              bigint unsigned auto_increment comment '学校主键'
        primary key,
    name            varchar(255) not null comment '学校名称',
    type            int unsigned null comment '学校类型',
    locate_province varchar(255) not null comment '省份',
    locate_city     varchar(255) not null comment '城市',
    locate_area     varchar(255) not null comment '所在地区',
    locate_lat      double       not null comment '所在纬度',
    locate_lng      double       not null comment '所在经度',
    created_at      timestamp    not null comment '创建时间',
    updated_at      timestamp    not null comment '更新时间',
    constraint srd_resources_school_srd_resources_school_type_id_fk
        foreign key (type) references srd_resources_school_type (id)
            on delete set null
)
    comment '学校数据库';
```

```mysql
-- 企业类型
-- srd_resources_organization_type
create table srd_resources_organization_type
(
    id         int unsigned auto_increment comment '类型主键'
        primary key,
    name       varchar(100) not null comment '类型名称',
    created_at timestamp    not null comment '创建时间',
    updated_at timestamp    not null comment '修改时间'
)
    comment '企业类型';
```

```mysql
-- 企业列表
-- srd_resources_organization
create table srd_resources_organization
(
    id                 bigint unsigned not null comment '企业主键'
        primary key,
    name               varchar(255)    not null comment '企业全名',
    code_credit        varchar(18)     not null comment '统一社会信用代码',
    code_agency        varchar(10)     null comment '组织机构代码',
    type               int unsigned    null comment '企业类型',
    company_created_at timestamp       not null comment '营业期限（起始）',
    company_updated_at timestamp       not null comment '营业期限（结束）',
    created_at         timestamp       not null comment '创建时间',
    updated_at         timestamp       not null comment '修改时间',
    constraint srd_resources_company_srd_resources_company_type_id_fk
        foreign key (type) references srd_resources_organization_type (id)
            on delete set null
)
    comment '企业列表';
```

```mysql
-- 校验码
-- srd_verify_code
create table srd_verify_code
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    type       tinyint unsigned not null comment '类型（0:邮箱，1:手机）',
    contact    varchar(50)      not null comment '联系方式',
    code       varchar(12)      not null comment '校验码',
    expired_at timestamp        not null comment '过期时间',
    created_at timestamp        not null comment '创建时间'
)
    comment '校验码';
```

```mysql
-- 分类
-- srd_classify
create table srd_classify
(
    id         int unsigned auto_increment comment '分类主键'
        primary key,
    name       varchar(10)                         not null comment '分类名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '更新时间'
)
    comment '分类';
```

```mysql
-- 话题
-- srd_topic
create table srd_topic
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     null comment '话题创建人（RAM用户创建以主用户为准）',
    name       varchar(20)                         not null comment '话题名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    constraint srd_topic_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete set null
)
    comment '话题';
```

```mysql
-- 文章
-- srd_article
create table srd_article
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_type  tinyint unsigned                           not null comment '普通/组织/RAM',
    user_id    bigint unsigned                            not null comment '用户主键',
    title      varchar(50)                                not null comment '文章标题',
    classify   json                                       not null comment '文章类型',
    topic      bigint unsigned                            null comment '话题',
    `desc`     varchar(100)                               null comment '描述',
    article    longtext                                   not null comment '文章正文',
    state      tinyint unsigned default '0'               not null comment '状态',
    created_at timestamp        default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                                  null comment '更新时间',
    deleted_at timestamp                                  null comment '删除时间',
    constraint srd_article_srd_topic_id_fk
        foreign key (topic) references srd_topic (id)
            on delete set null
)
    comment '文章';
```

```mysql
-- 评论
-- srd_comment
create table srd_comment
(
    id           bigint unsigned auto_increment comment '组件'
        primary key,
    comment_type int unsigned                        not null comment '评论类别',
    comment_id   bigint unsigned                     not null comment '对应评论类别的主键',
    user_type    tinyint(1)                          not null comment '用户类型',
    user_id      bigint unsigned                     not null comment '用户主键',
    comment      text                                not null comment '评论',
    replay       bigint unsigned                     null comment '回复',
    created_at   timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at   timestamp                           null comment '修改时间',
    constraint srd_comment_srd_comment_id_fk
        foreign key (replay) references srd_comment (id)
            on delete cascade
)
    comment '评论';
```

```mysql
-- 招募类型
-- srd_recruit_type
create table srd_recruit_type
(
    id         int unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     null comment '词条创建者',
    name       varchar(20)                         not null comment '词条名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    constraint srd_recruit_type_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete set null
)
    comment '招募类型';
```

```mysql
-- 招募
-- srd_recruit
create table srd_recruit
(
    id          bigint unsigned auto_increment comment '组件'
        primary key,
    user_type   tinyint(1)                           not null comment '用户类型',
    user_id     bigint unsigned                      not null comment '用户主键',
    title       varchar(50)                          not null comment '招募标题',
    type        int unsigned                         null comment '招募类型',
    classify    json                                 null comment '分类',
    `desc`      longtext                             not null comment '招募描述',
    number      int        default 1                 not null comment '招募人数',
    recruited   json                                 null comment '已招入用户',
    price_type  tinyint(1) default 0                 not null comment '是否有金额',
    price_start int                                  not null comment '起始价格',
    price_end   int                                  not null comment '结束价格',
    created_at  timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at  timestamp                            null comment '修改时间',
    constraint srd_recruit_srd_recruit_type_id_fk
        foreign key (type) references srd_recruit_type (id)
            on delete set null
)
    comment '招募';
```

```mysql
-- 项目孵化
-- srd_incubation
create table srd_incubation
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    name       varchar(50)                         not null comment '项目名称',
    type       int unsigned                        not null comment '类别',
    `desc`     longtext                            not null comment '详细描述',
    state      tinyint   default 0                 not null comment '当前状态',
    company    bigint unsigned                     null comment '签约企业',
    contract   text                                null comment '签约合同',
    mooney     int                                 null comment '经济',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    signing_at timestamp                           null comment '签名时间',
    constraint srd_incubation_srd_resources_organization_id_fk
        foreign key (company) references srd_resources_organization (id),
    constraint srd_incubation_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
)
    comment '项目孵化';
```

```mysql
-- 交友
-- srd_user_friend
create table srd_user_friend
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                      not null comment '用户主键',
    friend_id  bigint unsigned                      not null comment '好友',
    state      tinyint(1) default 0                 not null comment '对方是否同意',
    created_at timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                            null comment '修改时间',
    constraint srd_user_friend_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete cascade,
    constraint srd_user_friend_srd_user_id_fk_2
        foreign key (friend_id) references srd_user (id)
            on delete cascade
)
    comment '交友';
```

```mysql
-- 题解类型
-- srd_solve_problem_type
create table srd_solve_problem_type
(
    id         int unsigned auto_increment
        primary key,
    name       varchar(20)                         not null comment '类型名字',
    `desc`     varchar(255)                        null comment '类型描述',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间'
)
    comment '题解类型';
```

```mysql
-- 题解模块
-- srd_solve_problem
create table srd_solve_problem
(
    id         bigint unsigned auto_increment comment '组件'
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    title      varchar(50)                         not null comment '题解标题',
    type       int unsigned                        null comment '题解类型',
    `desc`     longtext                            not null comment '题解描述',
    money      double    default 0                 not null comment '题解金额',
    solve_by   bigint unsigned                     null comment '解决用户',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    solved_at  timestamp                           null comment '解决时间',
    constraint srd_solve_problem_srd_solve_problem_type_id_fk
        foreign key (type) references srd_solve_problem_type (id)
            on delete set null,
    constraint srd_solve_problem_srd_user_id_fk
        foreign key (solve_by) references srd_user (id),
    constraint srd_solve_problem_srd_user_id_fk_2
        foreign key (user_id) references srd_user (id)
)
    comment '题解模块';
```

```mysql
-- 交流
-- srd_talk
create table srd_talk
(
    id         bigint unsigned auto_increment
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    topic      bigint unsigned                     null comment '话题',
    talk       mediumtext                          not null comment '聊天',
    replay     bigint unsigned                     null comment '回复',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    constraint srd_talk_srd_talk_id_fk
        foreign key (replay) references srd_talk (id)
            on delete set null,
    constraint srd_talk_srd_topic_id_fk
        foreign key (topic) references srd_topic (id)
            on delete set null,
    constraint srd_talk_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete cascade
)
    comment '交流';
```



## 整体架构

> 整体架构图如下图所示

![](https://i-cdn.akass.cn/2023/12/6590ffb4c722e.jpg)



## 用户整体架构设计

> 用户架构分配图（区分用户区别）

![用户分级](https://i-cdn.akass.cn/2023/12/658fa3b9f2441.jpg)

### 说明

1. 自主注册与非自主注册用户主要区别在于是否在网站上注册
2. 用户注册需要进行用户激活校验，需要用户进行邮件内容校验
3. 用户操作较为敏感的信息，需要进行邮箱校验码进行验证，验证通过后允许操作
4. RAM用户的权限不应该超过普通用户所具有的权限（另外：管理员用户不允许有RAM用户的权限）
5. 普通用户进行权限组切换的时候需要检查名下所有RAM用户（若存在RAM用户需要进行移除，`切换权限组时候不允许存在RAM用户`）



### 用户授权

> 用户授权采用授权 token 的形式进行授权，在用户执行登陆或注册的时候执行生成 token 并且校验所生成的 token 是否重复（务必保证生成的 token 在数据表中处于唯一状态）

Token（令牌）对应格式：`(补)(Timestamp)-^[0-9A-Za-z-_]{20}$-^[0-9]{14}$`

​	其中 `(补)` 对应时间戳（timestamp位数不为14的情况下）

​	`(timestamp)` 为时间戳函数，截至目前时间戳位数处于 13 位

​	令牌总计字节一共 **50** 位



用户进行登陆和注册的时候，在操作执行完毕之后进行 Token 创建并且绑定给用户表，还需要将用户的 ip 地址和 userAgent 信息上传到数据库，以确保 token 的有效性。（请注意：由于目前互联网环境，用户很可能在访问网站的时候出现很多个IP进行访问，对于跨地域时候尤其明显。所以进行 token 校验时候需要仅需检查 userAgent 是否一致即可，作出大致判断，无需详细检查\<UserAgent也可复制\>的。）



### 用户组别

![](https://i-cdn.akass.cn/2023/12/6590272384eb8.jpg!wp60)

对于组织用户，除学校组织单独组织数据表，其余所有组织以 organization 数据表为准



## 组织用户架构设计

组织用户设计中，允许一位主干进行账号注册操作，即组织注册登记。主干账号登记后，允许主干账号开设RAM子账号。RAM账号的开设不得多于100个账号（不含100个）

> 组织用户注册授权模式

![](https://i-cdn.akass.cn/2023/12/6590413a11ba5.jpg!wp60)



## 模块设计

### 文章模块

![](https://i-cdn.akass.cn/2023/12/6590499e6e880.jpg!wp60)

### 招募模块

![](https://i-cdn.akass.cn/2023/12/6590f5b00f6d9.jpg!wp60)

### 孵化模块

![](https://i-cdn.akass.cn/2023/12/6590f9163e267.jpg!wp60)

### 服务模块

> 服务模块为一大板块，其中包含了 `题解模块、活动模块、交友模块、推广模块等` 子模块

![](https://i-cdn.akass.cn/2023/12/6590fe79d2b13.jpg)

