# SocialResourceDocking 开发者

<div align="right">Author 筱锋xiao_lfeng | Version: V1.0.0</div>

## 功能简介

<img src="https://i-cdn.akass.cn/2023/12/658eca572c274.png!wp60" alt="638d793b19a56b406d31b7f333371991" style="zoom: 45%;" />

> 该系统由四个核心组成部分构成：登录模块、功能模块、数据交换、页面展示
> 登录部件：确保用户安全接入系统
> 功能模块：分为政府类、企业类、社区类、其他类，主要用于打破大学生与社会的信息差，方便各类社会组织和大学生双向上传需求：例如义工服务、创新创业合作、行业培训、社会实践、公益活动等，以此来满足双方的需求。
> 数据交换：保证信息流在系统内部和外部各实体间的高效、安全传输
> 界面展示：优化了用户体验，使得信息查阅和管理清晰、直观。

本项目旨在构建一款综合性系统，通过四个核心部分的协同工作，实现政府、企业、社区与大学生之间的信息共享与合作。通过该系统，大学生可以更便捷地参与各类社会活动，获得创新创业机会，完成行业培训，参与社会实践和公益活动。同时，各社会组织也能更轻松地找到合适的大学生资源，促进双向合作，打破信息壁垒，实现资源的共享和优化。通过数据交换保障信息的高效安全传输，通过优化界面展示提高用户体验，本项目旨在为大学生和社会组织提供一个便捷、高效、安全的合作平台。



## 数据库架构

```mysql
-- srd_user
create table srd_user
(
    id                   bigint unsigned auto_increment comment '用户主键',
    username             varchar(40)             not null comment '用户名',
    nickname             varchar(20)             null comment '昵称',
    email                varchar(50)             not null comment '邮箱',
    tel_country_area     int       default 86    not null comment '电话所属国区',
    tel                  varchar(20)             not null comment '电话号码',
    verify               boolean   default false not null comment '用户是否校验',
    password             varchar(100)            not null comment '密码',
    old_password         varchar(100)            null comment '旧密码',
    ram                  bigint unsigned         null comment '所属用户（不为空则为子用户）',
    created_at           timestamp default now() not null comment '创建时间',
    updated_at           timestamp               null comment '信息修改时间',
    ban                  boolean   default false not null comment '是否被封禁',
    contact_qq           varchar(15)             null comment 'qq号',
    contact_wechat       varchar(30)             null comment '微信号',
    contact_organization varchar(100)            null comment '企业/组织/学校',
    constraint srd_user_pk
        primary key (id)
)
    comment '用户数据表';

create unique index srd_user_email_uindex
    on srd_user (email);

create unique index srd_user_username_uindex
    on srd_user (username);
```



## 用户模块

> 用户模块分级示意图

![用户分级](https://i-cdn.akass.cn/2023/12/658fa3b9f2441.jpg)

### 说明

1. 自主注册与非自主注册用户主要区别在于是否在网站上注册（另外，注册
