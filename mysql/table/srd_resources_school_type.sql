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