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