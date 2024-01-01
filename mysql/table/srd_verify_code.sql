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