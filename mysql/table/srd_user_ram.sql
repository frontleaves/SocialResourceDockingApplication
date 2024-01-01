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