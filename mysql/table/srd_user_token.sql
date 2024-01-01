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