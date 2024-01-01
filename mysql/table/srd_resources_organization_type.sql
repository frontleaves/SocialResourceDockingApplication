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